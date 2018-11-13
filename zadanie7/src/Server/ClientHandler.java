package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
// класс для работы к клиентами
public class ClientHandler {

    private MainServer server;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private String nick2;

    public ClientHandler(MainServer server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // цикл для авторизации
                        while (true) {
                            String str = in.readUTF();
                            // если приходит сообщение начинающееся с /auth значит пользователь хочет авторизоваться
                            if(str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                // запрашиваем ник в БД
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);

                                Map<String, ClientHandler> hm = new HashMap<>();
                                Set<Map.Entry<String, ClientHandler>> set = hm.entrySet();
                                for (Map.Entry<String, ClientHandler> me : set) {
                                    if (me.getKey().equalsIgnoreCase(newNick))
                                        System.out.println("Этот пользователь уже подключен!");
                                    else
                                        // если ответ не равен null отправляем ответ клиенту о том, что авторизация прошла успешно
                                        if (newNick != null) {
                                            sendMsg("/authok");
                                            nick = newNick;
                                            server.subscribe(ClientHandler.this);
                                            break;
                                        } else {
                                            sendMsg("Неверный логин/пароль!");
                                        }
                                }
                            }
                        }

                        // цикл для работы
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            else if (str.startsWith("/w " + nick2)){

                                server.privateMsg(nick2,nick + ": " + str);
                            }
                            server.broadCastMsg(nick + ": " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // метод для оправки сообщения 1 клиенту
    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
