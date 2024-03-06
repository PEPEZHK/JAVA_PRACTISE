import java.util.Scanner;
public class Lab05_Q1 {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in) ;
        String integer ;
        String zero ;
        zero = "0" ;
        
        int count ;
        count = 0 ;
        do 
        {
            System.out.print("Enter a positive integer: ");
            integer = input.nextLine();
        }
        while (!integer.matches("[0-9]+") || integer.equalsIgnoreCase(zero));
        int num ;
        num = Integer.parseInt(integer);
    
        System.out.println("multiplicative persistence of " + integer + " is " + persistence(num ,count));
        input.close();
    }

    public static int persistence ( int num, int count) 
    {
        if (num < 10) 
        {
            return count ;
        }
        else 
        {
            while (num >= 10) 
            {
                int productNum ;
                productNum = 1 ;
                while (num > 0) 
                {
                    productNum *= num % 10 ;
                    num /= 10 ;
                }
                num = productNum ;
                count ++ ;
            } 
            return count ;
        }
    }
}
