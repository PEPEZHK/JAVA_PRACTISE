import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board
{
    int width ;
    int height ;
    ArrayList<String> board = new ArrayList<>();
    String[] positions ;
    int[] traps ;
    //Constructor
    public Board(int h , int w)
    {
        height = h ;
        width = w ;
        positions = new String[(2 * (width + height - 2))*4] ;
        for (int i = 0 ; i < positions.length ; i++)
        {
            positions[i] = " " ;
        }
    }

    public void setWidth(int w)
    {
        width = w ;
    }

    public void setHeight(int h)
    {
        height = h ;
    }

    public void displayBOard() 
    {
        createBoard() ;
        for (String s : board)
        {
            System.out.print(s);
        }
    }

    //Method returns arraylist of the board
    public ArrayList<String> createBoard() 
    {
        board.clear(); 
        String[] firstLine = sortedToFirstLIne(positions) ;
        String[] secondLine = sortedToSecondLine(positions) ;

        int g = 0 , row = 0 , first = 0 , second = 0 , firstN = firstLine.length - 1 , secondN = secondLine.length - 1;
        String s = "" ;
        
        
        //Creating first line
        board.add(line()) ;
        for (int i = 0 , h = 1 ; i < height ; i++ , g = 0 , row = 0 , h++)
        {
            //while is used in order to create two lines at each cell, so predictable max. amount of people will fit in
            while (row < 2)
            {
                for (int j = 0; j < width*3 + 1 && first < firstLine.length && second < secondLine.length; j++)
                {
                    if ( i == 0 || i == height - 1) 
                    {
                        if (j == 0 || j == width*3) 
                        {
                            s += "#" ; 
                        }
                        else 
                        {
                            if ( j % 3 == 0 || j == width*height - 3)
                            {
                                s += "#" ;
                            }
                            else 
                            {
                                if ( i == 0) 
                                {
                                    if (row == 0)
                                    {
                                        s += firstLine[first] ;
                                        first ++ ;
                                    }
                                    else 
                                    {
                                        s += secondLine[second] ;
                                        second ++ ;
                                    }
                                }
                                if ( i == height - 1) 
                                {
                                    if (row == 0)
                                    {
                                        s += firstLine[firstN] ;
                                        firstN -- ;
                                    }
                                    else 
                                    {
                                        s += secondLine[secondN] ;
                                        secondN -- ;
                                    }
                                    
                                }
                            }
                        }
                    }
                    else 
                    {
                        if (j == 0 || j == width*3) 
                        {
                            s += "#" ;
                        }
                        else 
                        {
                            if (j == 3 || j == width*3-3) 
                            {
                                s += "#" ;
                            }
                            else if ( j > 3 && j < width*3 - 3)
                            {
                                s += " " ;
                            }
                            else if ( j < 3)
                            {
                                if (row == 0)
                                {
                                    s += firstLine[firstN] ;
                                    firstN -- ;
                                }
                                else 
                                {
                                    s += secondLine[secondN] ;
                                    secondN -- ;
                                }
                            }
                            else if ( j > width*3 - 3)
                            {
                                if (row == 0)
                                {
                                    s += firstLine[first] ;
                                    first ++ ;
                                }
                                else 
                                {
                                    s += secondLine[second] ;
                                    second ++ ;
                                }
                            }
                        }
                    }
                }
                board.add(s+"\n") ;
                s = "" ;  
                row ++ ;
            }
            //if statement is used in order to delete "#"s on the middle of the board
            if (h != 1 && h != height - 1 && h != height)
            {
                while (g < width*3 + 1) 
                {
                    if (g < 3) 
                    {
                        s += "#" ;
                    }
                    else if (g > 3 && g < width*3 - 3)
                    {
                        s += " " ;
                    }
                    else 
                    {
                        s += "#" ;
                    }
                    g++ ;
                }
                board.add(s+"\n") ;
                s = "" ;
            }
            else 
            {
                board.add(line()) ;
            }
        }
        return board ;
    }

    public static String[] sortedToFirstLIne(String[] positions)
    {
        int c = 0 ;
        String[] arr = new String[positions.length/2];
        for (int i = 0 , j = 0 ; i < positions.length && j < arr.length ;)
        {
            if (c == 2)
            {
                i += 2;
                c = 0 ;
            }
            else 
            {
                arr[j] = positions[i] ;
                j++ ;
                i++ ;
                c++ ; 
            }
        }
        return arr ;
    }

    public static String[] sortedToSecondLine(String[] positions)
    {
        int c = 0 ;
        String[] arr = new String[positions.length/2];
        for (int i = 2 , j = 0 ; i < positions.length && j < arr.length ;)
        {
            if (c == 2)
            {
                i += 2;
                c = 0 ;
            }
            else 
            {
                arr[j] = positions[i] ;
                j++ ;
                i++ ;
                c++ ; 
            }
        }
        return arr ;
    }

    public int[] createTraps()
    {
        Random r = new Random() ;

        traps = new int[r.nextInt(6)+1] ;

        for (int i = 0 ; i < traps.length ; i++)
        {
            traps[i] = r.nextInt(width*height-4) + 1;
        }

        return traps ;
    }

    public String line()
    {
        String s = "" ;
        int g = 0 ;
        while (g < width*3 + 1) 
        {
            s += "#" ;
            g++ ;
        }
        return s+"\n" ;
    }
}


