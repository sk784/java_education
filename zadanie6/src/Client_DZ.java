import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_DZ {
    public static void main(String[] args){

        try (Socket socket = new Socket("localhost", 3345);
            Scanner sc = new Scanner(System.in);
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream()))
        {
            System.out.println("Клиент подключился");

            String clientCommand = sc.nextLine();
            oos.writeUTF(clientCommand);
            oos.flush();

            while(true) {
            String in = ois.readUTF();
            System.out.println(in);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}