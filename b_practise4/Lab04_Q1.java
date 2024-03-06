import java.util.Scanner;
public class Lab04_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int minimum ;
        int maximum ;
        
        do 
        {
            
            System.out.print("Enter the minimum and maximum number of people: ");
            String[] range = input.nextLine().split(" ");
            minimum = Integer.parseInt(range[0]);
            maximum = Integer.parseInt(range[1]);
            if (minimum >= maximum) 
            {
                System.out.println("Invalid input - minimum must be less than maximum...");
            }
            else 
            {
                
            }
            
        }while (minimum >= maximum);
        final int d = 365 ;
        System.out.println("NUMBER OF PEOPLE                     PROBABILITY");
        for (int r = minimum ;r <= maximum ;r ++) 
        {
            double sameBirthday ;
            sameBirthday = 1 ;
            
            for( int i = 1 ;i <= r ;i ++) 
            {
                sameBirthday *= (d - (i - 1)) / (double) d;
            }
            sameBirthday = 1 - sameBirthday;
            System.out.printf("%d                                   %.3f\n", r , sameBirthday);
            
        }
        
        input.close();
             
    }
}
