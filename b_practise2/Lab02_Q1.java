import java.util.Scanner;

public class Lab02_Q1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a real number: ");
        String string = input.nextLine();

        System.out.println("------------------------------------");
        for (char c : string.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                System.out.println("Invalid input - value must be numeric....");
                System.out.println("You entered: " + string);

                break;
            } else {
                double x = Double.parseDouble(string);
                double function;

                if (x > 15) {
                    function = Math.sqrt(Math.pow(x, 5) + 1);

                } else if (x <= 15 & x >= 0) {
                    function = Math.exp(x) - 15;

                } else {
                    function = x / (x + 10);

                }
                System.out.printf("f(x)= %.2f", function);
                break;

            }

        }
        input.close();
    }

}
