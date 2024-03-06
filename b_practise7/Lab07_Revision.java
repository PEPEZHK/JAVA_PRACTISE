import java.util.Arrays;
import java.util.Scanner;


public class Lab07_Revision 
{
    private static String[] namesOfFriends = {"Ela","Eren","Alona","Jen","Mark","Mel","Ender"} ;
    private static int[] departureTime = {12,7,11,12,10,9,10} ;
    private static int[] arrivalTime = {9,5,8,7,9,7,8} ; 
    public static void main(String[] args) 
    {
        int min = 1 ; 
        int max = 12 ;
        int[] values = new int[max-min] ;
        for (int i = 0 ; i < values.length ; i ++) 
        {
            values[i] = i ; 
        }
        
        
        int[] test = BestTime.bestInterval(values) ;
        
        String[] indexes = BestTime.indexess(values) ;
        
        if (test[2] < test[1]) 
        {
            System.out.println("The shortest interval to attend is: " +  values[test[2]+1] + " " + values[test[1]+1] + " to meet with " + test[0] + " friends");

            String line , line1;
            line = "" ; 
            
            for (int i = 0 ; i < 1; i ++) 
            {
                line1 = indexes[test[1]+1] ;
                for (int j = 0 , k = 1 ; j < line1.length() ; j ++ , k ++) 
                {
                    line += " " + namesOfFriends[Integer.parseInt(line1.substring(j,k))] ;
                }
                
            }

            System.out.println("At " + values[test[1]+1] + ": " + line);
            
            
            
            String line2 , line3;
            line2 = "" ; 
            for (int i = 0 ; i < 1 ; i ++) 
            {
                line3 = indexes[test[2]] ;
                for (int j = 0 , k = 1 ; j < line3.length() ; j ++ , k ++) 
                {
                    line2 += " " + namesOfFriends[Integer.parseInt(line3.substring(j,k))] ;
                }
                
            }
            System.out.println("At " + values[test[2]] + ": " + line2);
        }
        else 
        {
            System.out.println("The shortest interval to attend is: " +  values[test[1]+1] + " " + values[test[2]+1] + " to meet with " + test[0] + " friends");
            String line , line1;
            line = "" ;
            
            for (int i = 0 ; i < 1 ; i ++) 
            {
                line1 = indexes[test[2]] ;
                for (int j = 0 , k = 1 ; j < line1.length() ; j ++ , k ++) 
                {
                    line += " " + namesOfFriends[Integer.parseInt(line1.substring(j,k))] ;
                }
                
            }

            System.out.println("At " + values[test[2]] + ": " + line); 
            
            
            
            String line2 , line3;
            line2 = "" ; 
            for (int i = 0 ; i < 1 ; i ++) 
            {
                line3 = indexes[test[1]+1] ;
                for (int j = 0 , k = 1 ; j < line3.length() ; j ++ , k ++) 
                {
                    line2 += " " + namesOfFriends[Integer.parseInt(line3.substring(j,k))] ;
                }
                
            }
            System.out.println("At " + values[test[1]+1] + ": " + line2);
        }
        
        
    }

    

    
}

class BestTime 
{
    private static String[] namesOfFriends = {"Ela","Eren","Alona","Jen","Mark","Mel","Ender"} ;
    private static int[] departureTime = {12,7,11,12,10,9,10} ;
    private static int[] arrivalTime = {9,5,8,7,9,7,8} ; 




    public static int[] bestInterval (int[] values) 
    {
        int count = 0 ;
        String index ;
        String[] indexes = new String[values.length]; 
        int[] amountOFFrineds = new int[values.length] ;
        for (int i = values[0] ; i < amountOFFrineds.length ; i ++) 
        {
            count = 0 ; 
            index = "" ;
            for (int j = 0 ; j < namesOfFriends.length ; j ++) 
            {
                for (int k = arrivalTime[j] ; k < departureTime[j] ; k ++) 
                {
                    if (values[i] != departureTime[j])
                    {
                        if (values[i] == k) 
                        {
                            count ++ ;
                            index += j + "/" ;
                        } 
                    }
                    
                }
            }
            amountOFFrineds[i] = count ;
            indexes[i] = index ; 
        }
        
        String[] sorted = new String[amountOFFrineds.length] ;
        for (int s = 0 ; s < sorted.length ; s ++) 
        {
            sorted[s] = indexes[s].replaceAll("/", "") ;
        }
        
        int maxFriends ;
        maxFriends= amountOFFrineds[0] ;
        int maxIndex ;
        maxIndex = 0 ;
        for (int i = 0 ; i < amountOFFrineds.length ; i ++) 
        {
            if (amountOFFrineds[i] > maxFriends) 
            {
                maxFriends = amountOFFrineds[i] ;
                maxIndex = i ;
            }
        }
        int[] counters = new int[amountOFFrineds.length] ;
        String arr ;
        String arr1 ;
        int counter ;
        
        arr = sorted[maxIndex] ;
        for (int j = 0 , m = 1; j < sorted.length ; j ++ , m++) 
        {
            counter = 0 ;
            
            arr1 = sorted[j] ;
            for (int c = 0 , z = 1 ; c  < arr1.length() ; c ++ , z ++) 
            {
                if (arr.equalsIgnoreCase(arr1)) 
                {

                }
                else 
                {
                    if (arr.contains(arr1.substring(c, z))) 
                    {
                        counter ++;
                    }
                    else 
                    {

                    }
                }
            }
            
            counters[j] = counter ;
        }
            
        int maxFriends1 = counters[counters.length-1] ;
        int index2 ;
        index2 = 0 ;
        for (int i = 0 ; i < counters.length ; i ++) 
        {
            if (counters[i] == 0) 
            {

            }
            else 
            {
                if (counters[i] < maxFriends1) 
                {
                    maxFriends1 = counters[i] ;
                    index2 = i ;
                }
            }
        }
        int totalOFFriends = namesOfFriends.length - maxFriends1 ;
        int[] interval = {totalOFFriends, index2 , maxIndex} ;

        

        return interval ;
    }

    public static String[] indexess(int[] values) 
    {
        int count = 0 ;
        String index ;
        String[] indexes = new String[values.length]; 
        int[] amountOFFrineds = new int[values.length] ;
        for (int i = values[0] ; i < amountOFFrineds.length ; i ++) 
        {
            count = 0 ; 
            index = "" ;
            for (int j = 0 ; j < namesOfFriends.length ; j ++) 
            {
                for (int k = arrivalTime[j] ; k < departureTime[j] ; k ++) 
                {
                    if (values[i] != departureTime[j])
                    {
                        if (values[i] == k) 
                        {
                            count ++ ;
                            index += j + "/" ;
                        } 
                    }
                    
                }
            }
            amountOFFrineds[i] = count ;
            indexes[i] = index ; 
        }
        
        String[] sorted = new String[amountOFFrineds.length] ;
        for (int s = 0 ; s < sorted.length ; s ++) 
        {
            sorted[s] = indexes[s].replaceAll("/", "") ;
        }
        return sorted ;
    }
}

