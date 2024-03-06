import java.util.Scanner;
import java.util.Random;
public class Lab03_Q1_Revision 
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
        System.out.print("1) Encode Message \n2) Decode Message \n3) Encode2 Message \n4) Decode2 Message \n5) Quit \nEnter choice: ");
        int choice = input.nextInt() ;
 
        /**/
        while ( choice == 1 ) 
        {
            System.out.print("\nEnter word to encode: ");
            String word = input.nextLine();
            while (word.length() == 0) 
            {
                word = input.nextLine();
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
                break;
            }
            
            while (word.length() < 2 & word.length() != 0) 
            {
                System.out.println("\nInvalid length word - try again");
                break;
            }
            break;
            
               

            
        }

        /**/
        while ( choice == 2 ) 
        {
            
            String word = input.nextLine();
            while (word.length() == 0) 
            {
                word = input.nextLine();
                break;
            }
            while (word.length() == 0) 
            {
                System.out.println("No message to decode....");
                break;
            }
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
            
            while (word.length() < 2 & word.length() != 0) 
            {
                System.out.println("\nInvalid length word - try again");
                break;
            }
            break;

        }

        /**/
        while ( choice == 3 ) 
        {
            
            String encoded2Word = "";
            char c ;
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
            
            while ( i < word.length() ) 

            {
                c = word.charAt(i) ;
                encoded2Word = c + "*" + encoded2Word;
                i++;
            }
            encoded2Word = encoded2Word.substring(0, encoded2Word.length()-1);
            
            

           
            
            
            while (encoded2Word.contains(" "))
            {
                String[] whiteSpace = encoded2Word.split(" ") ;
                firstPart = whiteSpace[0] ;
                secondPart = whiteSpace[1] ; 
                firstPart = firstPart.substring(0, firstPart.length() - 1) ;
                secondPart = secondPart.substring(1, secondPart.length() ) ;
                encoded2Word = firstPart + " " + secondPart;
                System.out.println("Encoded message: " + encoded2Word); 
                break;
            }
                
                
            
            while (!encoded2Word.contains(" "))
            {
                System.out.println("Encoded message: " +encoded2Word );
                break;
            }
        
            break;
           
        }

        /**/
        while ( choice == 4 ) 
        {
            String decoded2Word;
            char c;
            String encoded2Word = "" ;
            String word = input.nextLine();
            while (word.length() == 0) 
            {
                word = input.nextLine();
                break;
            }
            while (word.length() == 0) 
            {
                System.out.println("No message to decode....");
                break;
            }
            while (word.length() < 2 & word.length() != 0) 
            {
                System.out.println("\nInvalid length word - try again");
                break;
            }
            while ( i < word.length() ) 

            {
                c = word.charAt(i) ;
                encoded2Word = c + "*" + encoded2Word;
                i++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(encoded2Word);
            sb.reverse();
            
            decoded2Word = sb.toString();
            decoded2Word = decoded2Word.replaceAll("[*]", "") ;
            System.out.println("Decoded message: " + decoded2Word);
        
        }
        while ( choice == 5 ) 
        {
            System.out.println("Thank you, goodbye!");
            break;
        } 
        while ( choice > 5 ) 
        {
            System.out.println("Invalid choice - try again....");
            break;
        }
            
        
    }    
}
