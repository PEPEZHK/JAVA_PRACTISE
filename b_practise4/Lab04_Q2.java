import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.print("Enter chart data: ");
        String chartData = input.nextLine() ;
        int v ;
        v = 0 ;  
        int v1 ;
        v1 = 0 ;
        double n ;
        n = chartData.length() ;
        double sum ;
        sum = 0 ;
        
        while ( chartData.matches("[0-9]+") & v < 1)
        {
            int chartDataInt ;
            chartDataInt = Integer.parseInt(chartData);
            char[] digits = String.valueOf(chartDataInt).toCharArray();
            final int maxHeight ;
            maxHeight = 9 ;
            int numReviews ;
            numReviews = 1 ;
            StringBuilder sb = new StringBuilder(); 
         
            for (int i1 = 0 ; i1 < digits.length ; i1 ++) 
            { 
                
                sb.append("review " + numReviews + " ");
                
                numReviews ++ ; 
                        
            }

            String finalString = sb.toString();
            System.out.println(finalString);
            
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
           
            for (int j = 9; j > 0; j--) 
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
            System.out.printf("Average review: " + sum/n);
            v ++ ;
        }
        while ( !chartData.matches("[0-9]+") & v1 < 1) 
        {
            System.out.println("Invalid chart data!");
            v1 ++ ;
        }
        
        input.close();
    
        
        
        
        
                    
    }
}
