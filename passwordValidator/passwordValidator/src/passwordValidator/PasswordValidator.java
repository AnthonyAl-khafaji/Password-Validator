package passwordValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static void main(String[] args) {
        String password = "YourPassword123!"; // Change this to the password you want to validate
        if (isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }

    public static boolean isValidPassword(String password) {
        // Check length requirement
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check at least three categories
        int categoriesCount = 0;
        if (containsLowerCase(password)) {
            categoriesCount++;
        }
        if (containsUpperCase(password)) {
            categoriesCount++;
        }
        if (containsDigit(password)) {
            categoriesCount++;
        }
        if (containsSpecialCharacter(password)) {
            categoriesCount++;
        }

        return categoriesCount >= 3;
    }

    private static boolean containsLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean containsUpperCase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsSpecialCharacter(String password) {
        Pattern specialCharPattern = Pattern.compile("[~!@#$%^&*()-=+_]");
        Matcher matcher = specialCharPattern.matcher(password);
        return matcher.find();
    }
}