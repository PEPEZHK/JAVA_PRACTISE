import java.math.*;
import java.util.Scanner;
public class Lab02_Q2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int small = input.nextInt();
        int large = input.nextInt();
        int orderSize = input.nextInt();
        System.out.printf("Input the number of small and large jars available and the order size: %d %d %d  \n" , small , large , orderSize) ;
        int largeJars ;
        largeJars = 5 * large ;
        int preNecSmJars ;
        int necSmJars ;
        int necSmJarsPer ;
        necSmJarsPer = orderSize - largeJars ;


        if (orderSize < 5 ) 
        {
            System.out.println("\nOrder must be larger than 5 litres");
            
        }
        else 
        {
            if (0 < orderSize - small - largeJars) 
            {
                System.out.println("You do not have enough jars to complete the order");
            }
            else 
            {
                if (necSmJarsPer < 0) 
                {
                    while ( necSmJarsPer <= 0) 
                    {
                        necSmJarsPer += 5 ;
                    }
                    if (necSmJarsPer <= small) 
                    {
                        necSmJars = (necSmJarsPer - small) + small ;
                        System.out.printf("\nOrder of %d litres will contain %d small(1 litre)jars" , orderSize , necSmJars);
                    }
                    else 
                    {
                        System.out.println("You do not have enough jars to complete the order");
                    }
                    
                }
                else if (orderSize == largeJars ) 
                {
                    System.out.printf("\nOrder of %d litres will contain 0 small(1 litre)jars" , orderSize);
                }
                else if (orderSize > largeJars && orderSize - largeJars <= small) 
                {
                    necSmJars = (necSmJarsPer - small) + small ;
                    System.out.printf("\nOrder of %d litres will contain %d small(1 litre)jars" , orderSize , necSmJars);
                }

            }

        }
        

        input.close();
        
    }

    
}
