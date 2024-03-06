import java.util.Scanner;
import java.lang.String;
import java.lang.Math;
public class Lab02_Q3 {
    public static void main(String[] args) {
        /**/Scanner input = new Scanner(System.in) ;
        System.out.print("Enter string: ");
        String sunshine ;
        sunshine = input.nextLine() ;
        /**/char first ;
        char middle ;
        char last ;
        first = sunshine.charAt(0);
        middle = sunshine.charAt(sunshine.length()/2) ;
        last = sunshine.charAt(sunshine.length()-1);
        
        /**/if (sunshine.length() < 3) 
        {
            System.out.println("Length of string is not sufficient");
        }
        else 
        {
            for (char c : sunshine.toCharArray()) 
            
            if  (Character.isUpperCase(c) || sunshine.indexOf('.') !=-1)
            {
                System.out.println("Characters not lowercase letters...");
                break;
            }
            else
            {
                
                if (sunshine.indexOf(' ') !=-1) 
                {
                    if ( Math.abs(first - middle)  >= 0  & Math.abs(first - middle)  <= 1 & Math.abs(middle - last) >= 2 & Math.abs(first - last) >= 2 ||Math.abs(first - last) >= 0 & Math.abs(first - last) <= 1 & Math.abs(last - middle) >= 2 & Math.abs(first - middle) >= 2 )
                    {
                        
                        System.out.println("String is special: true");
                        break;
                    }
                    else 
                    {
                        
                        System.out.println("String is special: false");
                        break;
                    }
                }
                else 
                {
                    if (Math.abs(middle - first)  <= 1 & Math.abs(last - middle)> 2 & Math.abs(last - first) > 2 ||Math.abs(last - first) <= 1 & Math.abs(middle - last) > 2 & Math.abs(middle - first) > 2 ) 
                    {
                        System.out.printf("\nfirst: %s middle: %s last: %s\n" , first , middle , last);
                        System.out.println("String is special: true");
                        break;
                    }
                    else 
                    {
                        System.out.printf("\nfirst: %s middle: %s last: %s\n" , first , middle , last);
                        System.out.println("String is special: false");
                        break;
                    }

                }
            }

        }
        input.close();
        
            
            
            
            
            
             
                
            
        
        
       
        
        
        
            

        
        
    }
}
