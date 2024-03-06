import java.util.Scanner;

public class ApplicationMain {
    public static void main(String[] args) {
        
        String repeatGame = "Y" ;
        int choice;
        boolean gameisFinished = false ;
        String winner = "";
        while (!repeatGame.equals("N"))
        {
            Scanner sc = new Scanner(System.in) ;
            BoardGame game = new BoardGame() ;
            System.out.print("Do you want to create a board and initialize players?(Y/N) \nYour choise: ");
            String answer = sc.nextLine() ;
            if (answer.equals("Y"))
            {                game.setAmPlayers();
                System.out.print("Set height: ");
                int h = sc.nextInt() ;
                System.out.print("Set width: ");
                int w = sc.nextInt() ;
                game.setPlayers();
                game.rollDice();
                game.showOrderOfPlayers();
                game.board = new Board(h, w) ;
                game.firstPositions() ;
                game.board.createTraps() ;
                System.out.print("Do you want to see board?(Y/N)\nYour choice: ");
                Scanner in = new Scanner(System.in) ;
                String ans = in.nextLine() ;
                if (ans.equals("Y"))
                    game.board.displayBOard() ;
            }
            int player = 0 ;
            while (!gameisFinished) 
            {
                
                System.out.print("Do you want to roll a dice or see board?(1/2):");
                Scanner scan = new Scanner(System.in) ;
                choice = scan.nextInt() ;
                if (choice == 1)
                {
                    int dice = game.players[player].roll() ;
                    System.out.print("Player " + game.players[player].getName() + " rolls " + dice + ", how many cells you move? (0-" + dice + ") :");
                    int step = sc.nextInt() ;
                    if (step != 0)
                    {
                        game.move(step, player) ;
                        gameisFinished = game.gameIsFinished(player) ;
                        winner = game.players[player].getName() ;
                        player ++ ;
                    }
                    else 
                        player ++ ;
                }
                else if (choice == 2)
                {
                    game.board.displayBOard();
                }
                
                
                if (player == game.amountOfPlayers)
                    player = 0 ;
            }

            
                System.out.println("Winner is " + winner +". Congratulations!!!!!");
                System.out.println("Player  Move  Traps");
                for (int i = 0 ; i < game.players.length ; i++)
                {
                    System.out.println(game.players[i].getName() + "        " + game.moves[i] + "     " + game.catchedTraps[i]);
                }

                System.out.print("Do u want to play again?(Y/N):");
                Scanner in = new Scanner(System.in) ;
                repeatGame = in.nextLine() ;
        }
    }
}
