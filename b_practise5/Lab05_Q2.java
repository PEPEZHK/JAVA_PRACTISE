import java.util.Scanner;

public class Lab05_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string for conversion: ");
        String text = in.nextLine();
        if (text.length() == 0) {
            System.out.println("No phrase entered.");
        } else {
            System.out.printf("Text you entered: '%s'", text);
            String convertText = Conversion.convertedText(text);
            int numCount;
            numCount = Conversion.countNumbers(convertText);
            System.out.printf("\nAfter conversion: '%s'", convertText);
            if (text.matches(convertText)) {
                System.out.printf("After conversion: '%s'\n", convertText);
                System.out.println("No conversion happened.");
            } else {
                if (numCount == 0) {
                    System.out.printf("After conversion: '%s'\n", convertText);
                    System.out.println("!! Attention !! There is no number in this text");

                } else {
                    System.out.printf("After conversion: '%s'\n", convertText);
                }
            }
        }
        in.close();
    }
}

class Conversion {
    static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";

    public static char convertChar(char c) {
        int index;
        index = KEY.indexOf(c);
        if (c == 'p') {
            return c;
        } else {
            if (index != -1 && index % 2 == 0) {
                return KEY.charAt(index + 1);
            } else {
                return c;
            }
        }

    }

    public static String convertedText(String text) {
        StringBuilder sb;
        sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            sb.append(convertChar(c));
        }
        return sb.toString();
    }

    public static int countNumbers(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
}
