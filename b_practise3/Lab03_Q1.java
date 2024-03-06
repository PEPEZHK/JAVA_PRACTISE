import java.util.Scanner;
import java.util.Random;
public class Lab03_Q1 
{
    public static void main(String[] args) 
    {
        /**/
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        

        /**/ 
        int i ;
        i = 0 ;
        String firstPart;
        String secondPart;
        String encodedWord;
        int n ;
        
        
        /**/
        System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
        int choice = input.nextInt() ;
 
        /**/
        while (choice != 3) 
        {
            while (choice < 4)
            {
                while ( choice != 2 ) 
                {

                    System.out.print("\nEnter word to encode: ");
                    String word = input.nextLine();
                    while (word.length() == 0) 
                    {
                        word = input.nextLine();
                        break;
                    }
                    while (word.length() < 2 & word.length() != 0) 
                    {
                        System.out.println("\nInvalid length word - try again");
                        break;
                    }
                    while (word.length() >= 2 & word.length() != 0)
                    {
                        n = word.length();
                        StringBuilder sb = new StringBuilder(word);
                        while (i < n) 
                        {
                            i ++ ;
                            int randomIndex = ran.nextInt(sb.length() + 1);
                            int randomDigit = ran.nextInt(10);
                            sb.insert(randomIndex, randomDigit);
                        }
                        int splitIndex = ran.nextInt(sb.length() - 1) + 1 ;
                        firstPart = sb.substring(0, splitIndex);
                        secondPart = sb.substring(splitIndex);
                        encodedWord = secondPart + firstPart ; 
                        while ( i < encodedWord.length() )
                        {
                            char c ;
                            c = encodedWord.charAt(i) ;               
                            while (!Character.isDigit(c)) 
                            {
                                encodedWord = secondPart + " " + firstPart;
                                break;
                            }
                            while (Character.isDigit(c)) 
                            {
                                encodedWord = secondPart + firstPart;
                                break;
                            }
                            i ++ ;
                        }
                    
                        System.out.println("\nEncoded message: " + encodedWord);

                        System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
                        choice = input.nextInt() ;
                        while (choice != 3) 
                        {
                            while (choice < 4)
                            {
                                while ( choice != 1 & choice !=3)
                                {
                                    while ( i < encodedWord.length() )
                                    {
                                        char c ;
                                        c = encodedWord.charAt(i) ;
                                        while (Character.isWhitespace(c))
                                        {
                                            encodedWord = secondPart + firstPart;
                                            break;
                                        }                
                                        while (!Character.isDigit(c)) 
                                        {
                                            encodedWord = secondPart + " " + firstPart;
                                            break;
                                        }  
                                        i ++ ;
                                    }
            
                                    firstPart = firstPart.replaceAll("[0123456789]", "");
                                    secondPart = secondPart.replaceAll("[0123456789]", "");
                                    System.out.println("The decoded message is: " + firstPart + "" + secondPart);
                                    System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
                                    choice = input.nextInt() ;
                                    break;
                                }
                                
                            }
                            System.out.println("Invalid choice - try again....");
                            System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
                            choice = input.nextInt() ;
                            break;
                            
                    
                        }
                        System.out.println("Thank you, goodbye!");
                        
                        
                        
                    }   
                    
                    System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
                    choice = input.nextInt() ;
                    
                    break;
                }
                System.out.println("No message to decode....");
                System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
                choice = input.nextInt() ;
                
            }

            System.out.println("Invalid choice - try again....");
            System.out.print("1) Encode Message \n2) Decode Message \n3) Quit \nEnter choice: ");
            choice = input.nextInt() ;
            break;
            
            
        }
        System.out.println("Thank you, goodbye!");
        
        
        
            
        
    }    
}
