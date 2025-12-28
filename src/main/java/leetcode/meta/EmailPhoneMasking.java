package leetcode.meta;
import java.util.*;

public class EmailPhoneMasking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter email or phone number:");
        String input = sc.nextLine();

        String result = maskPII(input);

        System.out.println("Masked Output:");
        System.out.println(result);
    }

    public static String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }

    private static String maskEmail(String email) {
        email = email.toLowerCase();
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];

        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
    }

    private static String maskPhone(String number) {
        StringBuilder digits = new StringBuilder();

        // Extract digits only
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) digits.append(c);
        }

        int total = digits.length();
        String last4 = digits.substring(total - 4);
        int country = total - 10;

        StringBuilder masked = new StringBuilder();

        if (country > 0) {
            masked.append("+");
            for (int i = 0; i < country; i++) masked.append("*");
            masked.append("-");
        }

        masked.append("***-***-").append(last4);

        return masked.toString();
    }
}