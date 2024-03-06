import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.* ;



public class Lab_06 
{
    
    private static final int CAMPUS_RADIUS = 250;
    private static final int MAX_MONTHS = 60;
    private static String[] arrayOfNames = {"Gollum","Spiderman","Mocha","Gora","Zeytin","Spot","Pamuk","Duman","Pasha","Tickles","Kahve","Tekir","Benek","Checkers", "Karamel","Tik Tak", "Havuç", "Blizzard", "Splatter", "Sprite","Hamur","Pofuduk","Popsicle","Ash","Gofret","Latte","Aslan","Patches","Lucky","Fluffy"};
    private static ArrayList<String> catNames = new ArrayList<String>( Arrays.asList( arrayOfNames ));
    
    public static ArrayList<String> getRandomNameList( int num )
    {
       /*Implement the method here.....
	    * The method should add num random names from the global static catNames list to a new ArrayList and 
		* return the random list of names. There should be no duplicates, and you should make sure that num is 
		* less than the number of names in the catNames list, if not, num should be set to the size of the 
		* catNames list.*/
        Random rand = new Random() ;
        ArrayList<String> namesList = new ArrayList<String>() ; 
        if (catNames.size() >= num) 
        {
            for (int i = 0 ; i < num ; i ++) 
            {


                int index ; 
                index = rand.nextInt(num) ;
                
                if (namesList.contains(catNames.get(index)))  
                {

                }
                else 
                {
                    namesList.add(catNames.get(index));
                }
                

            }
        }
        else 
        {
            num = catNames.size() ;
            for (int i = 0 ; i < num ; i ++) 
            {
                int index ; 
                index = rand.nextInt(num) ;
                if (namesList.contains(catNames.get(index)))  
                {

                }
                else 
                {
                    namesList.add(catNames.get(index));
                }
                

            }
        }
        return namesList ;	
    }
	
    public static ArrayList<String> getRandomLocationList( int num )
    {
        ArrayList<String> randomLocations = new ArrayList<String>();
        int randX;
        int randY;

        Random rand = new Random();
        int locCount = 0; //name counter

        while (  locCount < num )
        {    
            randX = rand.nextInt( CAMPUS_RADIUS * 2 );
            randY = rand.nextInt( CAMPUS_RADIUS * 2 );
            //if name not already added to list
            if( Math.sqrt( Math.pow(randX,2) + Math.pow(randY,2)) <= CAMPUS_RADIUS * 2 )
            {
                randomLocations.add( randX + "," + randY );
                locCount++;
            }
        }
        return randomLocations;
    }

    public static ArrayList<Integer> getRandomMonthList( int num )
    {
        ArrayList<Integer> randomMonths = new ArrayList<Integer>();
        int month;
    
        Random rand = new Random();

        for ( int i = 0; i < num; i++ ){    
            month = rand.nextInt( MAX_MONTHS );
            randomMonths.add( month );
        }
        return randomMonths;
    }

    public static double calculateDistance (String first , String second) 
    {
        Double x1 ;
        Double y1 ;
        

        Double x2 ;
        Double y2 ;
        
        
        x1 = Double.parseDouble(first.substring(0 , first.indexOf(","))) ;
        
        y1 = Double.parseDouble(first.substring(first.indexOf(",") + 1 , first.length())) ;

        
       
        x2 = Double.parseDouble(second.substring(0 , second.indexOf(","))) ;
        
        y2 = Double.parseDouble(second.substring(second.indexOf(",") + 1 , second.length())) ;

        double d ;
        
        d = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)) ;

        return d ;


    }

    public static boolean doesIntersect (String first , String second) 
    {


        double distance ;
        distance = calculateDistance(first, second) ;
        

        if (second.equals(first)) 
        {
            return null != null ;
        }
        else 
        {
            if (distance <= (100)) 
            {
                return true ;
            }
            else 
            {
                return false ;
            }
        }
        

        
    }

    public static int countIntersecting (String first , ArrayList<String> m1) 
    {
        int count ;
        count = 0 ;
        
        

        String location ;
        for (int i = 0 ; i < m1.size() ; i ++) 
        {
            location = m1.get(i) ;
            

            boolean intersection ;
            intersection = doesIntersect(first, location) ;

            if (intersection == true) 
            {
                count ++ ;
            }
            else 
            {

            }

        }

        return count ;

    }

    public static void displayIntersections (ArrayList<String> m , ArrayList<String> m1 , ArrayList<Integer> m3) 
    {
        int counterOfInter ;
        String first ;
        String second ;
        boolean intersects ;
        System.out.println("Before moving the cats: ");
        for (int i = 0 ; i < m.size() ; i ++) 
        {
            first = m1.get(i) ;

            counterOfInter = countIntersecting(first, m1) ;
            

            if (counterOfInter == 0) 
            {
                System.out.println(m.get(i) + " at location " + first + " for " + m3.get(i) + " months intersects with: NO CATS");
            }
            else 
            {
                System.out.println(m.get(i) + " at location " + first + " for " + m3.get(i) + " months intersects with: ");
                for (int j = 1 ; j < m1.size() ; j ++) 
                {
                    second = m1.get(j) ;

                    intersects = doesIntersect(first, second) ;
                    
                    if (intersects == true) 
                    {
                        System.out.println("       " + m.get(j) + " at location " + second + " for " + m3.get(j) + " months ");
                    }
                    else 
                    {

                    }
                }

            }
            System.out.println();
        }

        System.out.println("After moving the cats: ");
        

        for (int i = 0 ; i < m.size() ; i ++) 
        {
            moveCats(m1, m3) ;

            first = m1.get(i) ;

            counterOfInter = countIntersecting(first, m1) ;
            
            

            if (counterOfInter == 0) 
            {
                System.out.println(m.get(i) + " at location " + first + " for " + m3.get(i) + " months intersects with: NO CATS");
            }
            else  
            {
                
                System.out.println(m.get(i) + " at location " + first + " for " + m3.get(i) + " months intersects with: ");
                for (int j = 1 ; j < m1.size() ; j ++) 
                {
                    
                    second = m1.get(j) ;
                    

                    intersects = doesIntersect(first, second) ;
                    
                    if (intersects == true) 
                    {
                        System.out.println("       " + m.get(j) + " at location " + second + " for " + m3.get(j) + " months ");
                    }
                    else 
                    {

                    }
                }
                

            }
            
            System.out.println();
        }
    }

    public static int findMinMonthsAtLocation(String loc , ArrayList<String> locations, ArrayList<Integer> months) 
    {


        String second ;
    

        boolean intersects ;
        String locate ;
        locate = "" ;
        
        
        for (int i = 0 ; i < locations.size() ; i ++) 
        {
            second = locations.get(i) ;
            intersects = doesIntersect(loc, second) ;
            if (second.equals(loc)) 
            {
                locate += "/" + months.get(i) ;

            }
            else 
            {
                if (intersects == true) 
                {
                    locate += "/"+months.get(i) ;
                }
                else 
                {

                }
            }

        }
        

        locate = locate.substring(1, locate.length()) ;
        String[] month = new String[countIntersecting(loc, locations)] ;
        month = locate.split("/") ;
        

        int[] arr = new int[month.length] ;
        for (int b = 0 ; b < arr.length ; b ++) 
        {
            arr[b] = Integer.parseInt(month[b]) ; 
        }
            

        int min = Arrays.stream(arr).min().getAsInt();
        

        return min ; 


    }
        
    

    public static void moveCats(ArrayList<String> m1 , ArrayList<Integer> m3) 
    {


        Random rand = new Random() ;
        String first ;
        String second ;
        int index ;   
        int counterOfInter ;
        

        int x ; 
        int y ;
    
        
        for (int i = 0 ; i < m1.size() ; i ++) 
        {
            first = m1.get(i) ;
            
            counterOfInter = countIntersecting(first, m1) ;
            
            if (counterOfInter >= 2) 
            {
                
                index = findMinMonthsAtLocation(first, m1, m3) ;
                
                second = m1.get(m3.indexOf(index)) ;
                             
                while (countIntersecting(second, m1) != 0) 
                {
                    x = rand.nextInt(CAMPUS_RADIUS) ; 
                    y = rand.nextInt(CAMPUS_RADIUS) ;

                    if( Math.sqrt( Math.pow(x,2) + Math.pow(y,2)) <= CAMPUS_RADIUS * 2 ) 
                    {
                        m1.set(m3.indexOf(index), x + "," + y);
                    }
                    
                    second = m1.get(m3.indexOf(index)) ;
                    counterOfInter = countIntersecting(second, m1) ;          
                }  
                m3.set(m3.indexOf(index), 0) ;
            }
            

        }
        
        
    }
    public static void main(String[] args) 
    {

        
        Scanner in = new Scanner(System.in) ;
        String noInput = "no input" ;
        int num ;


        Random rand = new Random() ;
        if (in.nextLine().equalsIgnoreCase(noInput)) 
        {
            num = rand.nextInt(61);
        }
        else 
        {
            num = in.nextInt() ;
        }
        
        
        
        
        ArrayList<String> catNames = new ArrayList<>() ;
        catNames = getRandomNameList(num) ;


        ArrayList<String> locations = new ArrayList<>() ;
        locations = getRandomLocationList(catNames.size()) ;
        

        ArrayList<Integer> months = new ArrayList<>() ;
        months = getRandomMonthList(catNames.size()) ;


        displayIntersections(catNames, locations, months);        
        

        in.close();
        

    }
}

