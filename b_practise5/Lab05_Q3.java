import java.util.Scanner;
public class Lab05_Q3 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in) ;
        int choice ;
        
        do 
        {
            displayMenu();
            choice = getChoice() ;
            
            if (choice > 4) 
            {
                System.out.println("Invalid choice");
                displayMenu();
                choice = getChoice();
                
                if (choice < 4) 
                {
                    if (choice == 1) 
                    {
                        System.out.print("Enter the group size: ");
                        int size = in.nextInt();
                        double probability ;
                        probability = Math.round(sameBirthday(size))  ;
                        System.out.printf("The probability of two people in a group of "+size+" having the same birthday is %.2f\n" , probability);

                    }
                    else  
                    {
                        if (choice == 2) 
                        {
                            Scanner input = new Scanner(System.in);
                            System.out.print("Enter chart data: ");
                            String chartData; 
                            chartData = input.nextLine();
                            boolean isNumeric ;
                            isNumeric = isValidNumeric(chartData) ;
                            if (isNumeric == false) 
                            {
                                    
                                System.out.println("Invalid chart data!");
                                System.out.print("Enter chart data: ");
                                chartData = input.nextLine() ;
                            }
                            else 
                            {
                                final String LABEL = "review";
                                for (int i = 1; i <= chartData.length(); i++)
                                {
                                    System.out.printf("%10s",LABEL+" "+i + " ");
                                }
                                displayChart(chartData) ;

                            }
                        }
                        else 
                        {
                            System.out.print( "Enter word to convert: " );
                            String word ;
                            word = in.next();
                            System.out.println("Original word: " + word + "Converted word: " + convertWord(word));
                        }
                    }
                    if (choice == 4) 
                    {
                        System.out.println("GOODBYE!");
                    }
                }
                if (choice == 4) 
                {
                    System.out.println("");
                }
            }
            if (choice < 4) 
            {
                if (choice == 1) 
                {
                    System.out.print("Enter the group size: ");
                    int size = in.nextInt();
                    double probability ;
                    probability = Math.round(sameBirthday(size))  ;
                    System.out.printf("The probability of two people in a group of "+size+" having the same birthday is %.2f\n" , probability);

                }
                else  
                {
                    if (choice == 2) 
                    {
                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter chart data: ");
                        String chartData; 
                        chartData = input.nextLine();
                        boolean isNumeric ;
                        isNumeric = isValidNumeric(chartData) ;
                        if (isNumeric == false) 
                        {
                            
                            System.out.println("Invalid chart data!");
                            System.out.print("Enter chart data: ");
                            chartData = input.nextLine() ;
                        }
                        else 
                        {
                            final String LABEL = "review";
                            for (int i = 1; i <= chartData.length(); i++)
                            {
                                System.out.printf("%10s",LABEL+" "+i + " ");
                            }
                            displayChart(chartData) ;

                        }
                    }
                    else 
                    {
                        System.out.print( "Enter word to convert: " );
                        String word ;
                        word = in.next();
                        System.out.println("Original word: " + word + "Converted word: " + convertWord(word));
                    }
                }
                
            }
        }
        while (choice != 4) ;
        in.close();
    }

    public static void displayMenu () 
    {
        System.out.println("1 - Find Probability of Same Birthday \n2 - Draw Chart \n3 - Convert Word \n4 - QUIT ");
    }
    
    public static int getChoice() 
    {
        Scanner choice1 = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = choice1.nextInt() ;
        return choice ;
    }

    public static double sameBirthday( int size ) 
    {
        double sameBirthday ;
        final int d = 365 ;
        sameBirthday = 1 ;
        
        for (int i = 1; i < size ; i ++) 
        {
            sameBirthday *= (d - i) / (double) d;
        } 
        sameBirthday = 1 - sameBirthday;
        
        return sameBirthday ;
    }

    public static void displayChart (String chartData) 
    {
        double sum ;
        sum = 0 ;
        int[] arr = new int[chartData.length()] ;
        for ( int i = 0 ; i < arr.length ; i ++) 
        {
            arr[i] = Integer.parseInt(String.valueOf(chartData.charAt(i)));
                
        }
        for (int i = 0 ; i < arr.length ; i ++)
        {
            sum += arr[i] ;
        }
        String line ;
        line = "";   
        for (int j = 10; j > 0; j--) 
        {
                
            line = "";
                
            for (int i = 0; i < arr.length; i++) 
            {
                int v5 ;
                v5 = 0 ;
                int v6 ;
                v6 = 0 ;
        
                for ( ; arr[i] != j & v6 < 1 ; ) 
                {   
                    line += "         ";
                    v6 ++ ;
                }    
                for ( ; arr[i] == j & v5 < 1 ; ) 
                {
                    line += "     *** ";
                    arr[i]--;
                    v5++ ;
                } 
            } 
            System.out.println(line);   
        }
        
    }

    public static boolean isValidNumeric (String chartData) 
    {
        boolean isValid ;
        int pos;
        pos = -1;
        do 
        {
            pos++;
        }
        while( pos < chartData.length() && Character.isDigit(chartData.charAt(pos)));
        if ( pos != chartData.length() )
        {
            isValid = false ;
        }
        else 
        {
            isValid = true ;
        }
        return isValid ;
    }

    public static int findMax (String chartData) 
    {
        int maxDigit;
        int sum;
        maxDigit = -1;
        sum = 0;
        for ( int i = 0; i < chartData.length(); i++ )
        {
            int current = Character.getNumericValue(chartData.charAt(i));
            if (  current > maxDigit ){
                maxDigit = current; 
            }
            sum += current;
        }
        return maxDigit ;
    }

    public static int countLetter (String word , int index) 
    {
        char c = word.charAt(index);
        int count = 0 ;
        for (int i = 0 ; i <word.length() ; i ++) 
        {
            if (word.charAt(i) == c) 
            {
                count++ ;
            }
        }
        return count ;

    }
    
    public static String convertWord (String word)
    {
        String newWord ;
        newWord = "" ;
        
        int count ;

        for( int i = 0; i < word.length(); i++)
        {
            if ( !Character.isLetter(word.charAt(i)) )
            {
                newWord += '*';
            }
            else 
            { 
                count = 1;
                for ( int j = 0; j < word.length(); j++){
                if( i != j && Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(word.charAt(j))){
                    count++;
                }
                    
                }
                if( count != 1 ){
                    newWord += ")";
                }
                else {
                    newWord += "(";
                }
            }
        }
        return newWord ;
    }
}
