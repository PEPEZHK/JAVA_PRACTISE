import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ReadWriteExample {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in) ;
        WordBag wordBag = new WordBag() ;
        /*
         * READING FILE
         */

        // as reading a file involves first opening that file there can be exceptions
        // such exceptions should be handled in the code
        // (you will see more of this topic later in the course)
        // however, for now, just know that surrounding the part that can cause exceptions
        // with a try-catch block is one solution for the exceptions
        try 
        {
            System.out.println("Input file ''sentences.txt'' processed.");
            // create a new buffered reader with the given file to read its text
            // "sentences.txt" is the name of the file that is included in your project folder
            // you can also write the full path of the file
            BufferedReader reader = new BufferedReader(new FileReader(new File("lab2\\sentences.txt")));
            // read the first line of the text into currentLine
            String currentLine = reader.readLine();

            while (currentLine != null) 
            {

                // print the current line
                wordBag.processSentence(currentLine) ;

                // and get the next line
                currentLine = reader.readLine();
            }
        } 
        catch (FileNotFoundException e) 
        {
            // in case the file we provide cannot be found, this is the exception we get
            e.printStackTrace();
        }  
        catch (IOException e) 
        {
            // in case there is problem with reading the file, this is the exception we get
            e.printStackTrace();
        }
            // unless we encounter a null line
        System.out.println("1.Generate sentence\n2.Output sentences to Text File\n3.Exit");
        System.out.print("Please choose and option:");
        int choice = sc.nextInt() ;
        while (choice != 3)
        {
            if (choice == 1)
            {
                //Initializing soft limit
                System.out.print("Soft limit:");
                int soft = sc.nextInt() ;
                //Initializing hard limit
                System.out.print("Hard limit:");
                int hard = sc.nextInt() ;
                //creates output String
                String output = wordBag.generateSentence(soft, hard) ;
                System.out.println(output);
            }

            /*
            * WRITING TO FILE
            */

            // similar to reading a file, writing to a file can cause exceptions
            // therefore we need to surround our code in a try-catch block
            if (choice == 2)
            {
                Scanner in = new Scanner(System.in) ;
                System.out.print("File name: ");
                String fileName = in.nextLine() ;
                System.out.print("Enter amount of sentences: ");
                int sent = sc.nextInt() ;
                //Initializing soft limit
                System.out.print("Soft limit:");
                int soft = sc.nextInt() ;
                //Initializing hard limit
                System.out.print("Hard limit:");
                int hard = sc.nextInt() ;
                wordBag.writeToTextFile(fileName, sent, soft, hard);
            }
            System.out.println("1.Generate sentence\n2.Output sentences to Text File\n3.Exit");
            System.out.print("Please choose and option:");
            choice = sc.nextInt() ;
        }
        sc.close();
    }
}
