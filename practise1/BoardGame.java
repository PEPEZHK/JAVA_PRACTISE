import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BoardGame 
{
    Random r = new Random() ;
    int amountOfPlayers ;
    Player[] players ;
    int[] roller ;
    Board board ;
    int[] catchedTraps ;
    int[] moves ;
    int[] indexes ;
    //Constructor
    public BoardGame()
    {
        
    }   

    public void setAmPlayers() 
    {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Input amount of players(2-4):");
        int amount = sc.nextInt() ;
        boolean acceptable = false ;

        //Creating while function in order if user enter more or less than acceptable amount of people
        while(!acceptable)
        {
            if (amount < 2 || amount > 4)
            {
                System.out.println("Input more than 2 or less that 4 players!");
                amount = sc.nextInt() ;
            }
            else 
            {
                amountOfPlayers = amount ;
                acceptable = true ;
            }
        }
    }

    public void setPlayers()
    {
        //Initializing Player array
        players = new Player[amountOfPlayers];
        int am = 0 ;

        Scanner in = new Scanner(System.in) ;
        System.out.println("Please enter a character (symbol) for each player");
        while (am < amountOfPlayers)
        {
            System.out.print("For player " + (am+1) + ":");
            players[am] = new Player(in.nextLine());
            am ++ ;
        }

        catchedTraps = new int[players.length] ;
        moves = new int[players.length] ;
    }

    public void rollDice()
    {
        System.out.println("Players are rolling dices.");
        roller = new int[amountOfPlayers] ;

        //Inserting to int. array the first rolled results in order to use this info to sort players
        for (int i = 0 ; i < roller.length ; i++) 
        {
            roller[i] = r.nextInt(6) + 1 ;
            System.out.print(players[i].getName() +":"+ roller[i] + " ");
        }
        System.out.println();
        showTies();
        sortPlayersByRoll();
    }

    public void showOrderOfPlayers() 
    {
        System.out.println("Order of players") ;
        for(int i = 0 ; i < players.length ; i++)
        {
            System.out.println((i+1) + ":" + players[i].getName());
        }
    }

    public void sortPlayersByRoll()
    {
        //Using bubbleSort to sort players by rolledDice
        for (int i = 0 ; i < roller.length - 1; i++)
        {
            for (int j = 0 ; j < roller.length - i - 1; j++)
            {
                if (roller[j] < roller[j+1])
                {
                    String temp = players[j+1].getName() ;
                    players[j+1].setName(players[j].getName()) ;
                    players[j].setName(temp);
                    int tempInt = roller[j+1] ;
                    roller[j+1] = roller[j] ;
                    roller[j] = tempInt ;
                }
                else 
                {
                    int random = r.nextInt(2) ;
                    if ( random == 0 )
                    {
                        String temp = players[j+1].getName() ;
                        players[j+1].setName(players[j].getName()) ;
                        players[j].setName(temp);
                        int tempInt = roller[j+1] ;
                        roller[j+1] = roller[j] ;
                        roller[j] = tempInt ;
                    }
                }
            }
        }
    }

    public void move(int move , int playerIndex) 
    {
        if (move*4 + indexes[playerIndex] > board.positions.length) 
        {
            move = board.positions.length - indexes[playerIndex] - 1;
        }
        else 
        {
            if (onTrap(move + indexes[playerIndex]))
            {
                catchedTraps[playerIndex] ++ ;
                System.out.println("Oops! You stepped on a TRAP");
                if (indexes[playerIndex]+move*4 < (board.width)*4) 
                {
                    char temp = board.positions[indexes[playerIndex]].charAt(0) ;
                    board.positions[indexes[playerIndex]] = " " ;
                    indexes[playerIndex] = (indexes[playerIndex]+move*4)%4 ;
                    board.positions[indexes[playerIndex]] = ""+temp ; 
                }
                else if (indexes[playerIndex]+move*4 > (board.width)*4 && indexes[playerIndex] < (board.width + (board.height-2))*4)
                {
                    char temp = board.positions[indexes[playerIndex]].charAt(0) ;
                    board.positions[indexes[playerIndex]] = " " ;
                    indexes[playerIndex] = (indexes[playerIndex]+move*4)%4 + (board.width + (board.height-2))*4;
                    board.positions[indexes[playerIndex]] = ""+temp ; 
                }
                else if (indexes[playerIndex]+move*4 > (board.width + board.height)*4 && indexes[playerIndex] < (board.width + board.height + board.width)*4)
                {
                    char temp = board.positions[indexes[playerIndex]].charAt(0) ;
                    board.positions[indexes[playerIndex]] = " " ;
                    indexes[playerIndex] = (indexes[playerIndex]+move*4)%4 + (board.width + (board.height-2) + board.width)*4;
                    board.positions[indexes[playerIndex]] = ""+temp ; 
                }
                else if (indexes[playerIndex]+move*4 > (board.width)*4 && indexes[playerIndex] < (board.width + (board.height-2) + board.height)*4)
                {
                    char temp = board.positions[indexes[playerIndex]].charAt(0) ;
                    board.positions[indexes[playerIndex]] = " " ; 
                    indexes[playerIndex] = (indexes[playerIndex]+move*4)%4 + (board.width + (board.height-2)*2 + board.height)*4 ;
                    board.positions[indexes[playerIndex]] = ""+temp ; 
                }
            }
            else 
            {
                char c = board.positions[indexes[playerIndex]].charAt(0) ;
                board.positions[indexes[playerIndex]] = " ";
                board.positions[indexes[playerIndex] + move*4] = ""+c ;    
                indexes[playerIndex]+=move*4 ;
            }
        }
        moves[playerIndex] += move ;
    }

    public boolean gameIsFinished(int playerIndex) 
    {
        if (indexes[playerIndex] >= board.positions.length - 4)
            return true ;
        return false ;
    }

    public void showTies()
    {
        for (int i = 0 ; i < roller.length ; i++)
        {
            for (int j = i + 1 ; j < roller.length ; j++)
            {
                if (roller[i] == roller[j])
                {
                    System.out.println("Breaking tie for:" + players[i].getName() + " and " + players[j].getName());
                }
            }
        }
    }

    public void displayPlayers()
    {
        for (Player p : players)
        {
            System.out.println(p.getName()); 
        }
    }

    public void firstPositions()
    {
        indexes = new int[players.length] ;
        for (int i = 0 ; i < players.length ; i++)
        {
            board.positions[i] = players[i].getName() ;
            indexes[i] = i ;
        }
    }

    public boolean onTrap(int pos) 
    {
        for (int i = 0 ; i < board.traps.length ; i++)
        {
            if (pos >= (board.traps[i]-1)*4 && pos <= board.traps[i]*4 && board.traps[i] != -1)
            {
                deactivateTrap(i) ;
                return true ;
            }  
        }
        return false ;
    }

    public int[] deactivateTrap(int pos) 
    {
        board.traps[pos] = -1 ;
        return board.traps ;
    } 
}
