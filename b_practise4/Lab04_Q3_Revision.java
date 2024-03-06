import java.util.Scanner;

public class Lab04_Q3_Revision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter word to convert: ");
        String word;
        word = input.nextLine();
        int n;
        n = 0;
        int n2;
        n2 = 0;
        int n5;
        n5 = 0;
        int n6;
        int z;
        int a;
        z = 122;
        a = 97;
        int n7;

        int x;
        x = word.length();

        int c;
        while (word.matches("[a-z]+") & n < 1) {
            String converted = "";
            char mostRepeated;
            int maxRepLetter;
            maxRepLetter = 1;
            char[] array = word.toCharArray();

            for (int i = 0; i < array.length; i++) {
                n7 = 0;
                n6 = 0;

                c = array[i] + x;

                while (c <= 122 & n7 < 1) {
                    char newChar;
                    newChar = (char) (c);
                    converted += newChar;

                    n7++;
                }
                while (c > 122 & n6 < 1) {
                    c = c - z + a;

                    char newChar;
                    newChar = (char) (c);
                    converted += newChar;

                    n6++;
                }

            }

            char[] arrayCon = converted.toCharArray();
            mostRepeated = arrayCon[0];
            for (int i = 0, j = 0; i < converted.length() - 1; i = j) {
                int count;
                count = 1;
                while (++j < converted.length() && arrayCon[i] == arrayCon[j]) {
                    count++;
                    maxRepLetter = count;
                    mostRepeated = arrayCon[i];
                }

            }
            String mostRep;
            mostRep = String.valueOf(mostRepeated);
            converted = converted.replaceAll(mostRep, "(");
            converted = converted.replaceAll("|", "");

            n++;
            System.out.println("Length: " + x);
            System.out.println("Converted word: " + converted);

        }
        while (!word.matches("[a-z]+") & n5 < 1) {
            System.out.println("Invalid input! Only enter lowercase letters.");
            n5++;
        }
        input.close();

    }

}
