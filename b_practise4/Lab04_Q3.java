import java.util.Scanner;
public class Lab04_Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        String word ; 
        String convertedWord ;
        
        
        String wordExit ;
        wordExit = "exit" ;
        do 
        {
            System.out.print("Enter word to convert: ");
            word = input.nextLine();
            char c ;
            while (!word.equals(wordExit))
            {
                convertedWord = "" ;
                for ( int i = 0 ; i < word.length(); i ++)
                {
                    c = word.charAt(i) ; 
                    for (int b = 0 ; !Character.isLetter(c) & b < 1 ; b ++ ) 
                    {
                        convertedWord += "*";
                        
                    }
                    for (int b1 = 0 ; word.indexOf(c) == word.lastIndexOf(c) & b1 < 1 & Character.isLetter(c) ; b1 ++ ) 
                    {
                        convertedWord += "(";
                        
                    }
                    for (int b2 = 0 ; word.indexOf(c) != word.lastIndexOf(c) & b2 < 1 ; b2 ++ ) 
                    {
                        convertedWord += ")";
                        
                    }
                
                }
                System.out.println("Original word: " + word + " Converted word: " + convertedWord);
                System.out.print("Enter word to convert: ");
                word = input.nextLine();
            }
            
        } 
        while (!word.equalsIgnoreCase("exit")) ;
        input.close();
        

    }    
}
   