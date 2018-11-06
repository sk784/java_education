import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DopDZ {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(checkPass());
    }

    public static boolean checkPass(){
        System.out.println("Введите пароль");
        String password = scanner.next();
        Pattern p = Pattern.compile("[\\w]{8,}");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
