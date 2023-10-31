import java.util.Scanner;

public class validationbryce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password for validation: ");
        String password = sc.nextLine();

        if (isValid(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid.");
        }
    }

    public static boolean isValid(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int countLower = 0, countUpper = 0, countNumber = 0, countSpecial = 0;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) {
                countLower++;
            } else if (Character.isUpperCase(ch)) {
                countUpper++;
            } else if (Character.isDigit(ch)) {
                countNumber++;
            } else if ("~!@#$%^&*()-=+_".indexOf(ch) >= 0) {
                countSpecial++;
            } else {
                return false;
            }
        }

        int countValidTypes = 0;
        if (countLower > 0) countValidTypes++;
        if (countUpper > 0) countValidTypes++;
        if (countNumber > 0) countValidTypes++;
        if (countSpecial > 0) countValidTypes++;

        return countValidTypes >= 3;
    }
}
