import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SHADemo {
    public static String encryptPassword(String password) {
        String encryptedPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return encryptedPassword;
    }

    public static boolean isPasswordMatch(String password, String encryptedPassword) {
        return encryptPassword(password).equals(encryptedPassword);
    }

    public static void main(String[] args) {
        String encryptedPassword = SHADemo.encryptPassword("helloWorld");
        System.out.println(encryptedPassword);
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (isPasswordMatch(password, encryptedPassword)) {
            System.out.println("password is correct!");
        } else {
            System.out.println("password is incorrect!");
        }
    }
}
