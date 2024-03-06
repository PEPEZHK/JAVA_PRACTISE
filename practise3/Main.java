package lab3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        Random r = new Random() ;
        Arena arena = new Arena() ;
        boolean finish = false ;
        arena.fillArena();
        int choice ;
        
        int aliveOpps ;
        int compChoice = r.nextInt(7); 

        int turns = 0 ;
        while (!finish) 
        {
            System.out.println("Turn " + (turns + 1));
            System.out.println();
            arena.showCompUnits();
            System.out.println();
            arena.showPlayerUnits();
            System.out.print("Which unit you choose?:");
            choice = in.nextInt() - 1;
            aliveOpps = arena.alliveMen(arena.computerUnits);
    
            if (aliveOpps > -1)
            {
               compChoice = aliveOpps ;
               System.out.println("Computer decided to choose: " + arena.computerUnits.get(compChoice).getInfo());
            }
            else 
            {
                compChoice = r.nextInt(7);
                System.out.println("Computer decided to choose: " + arena.computerUnits.get(compChoice).getInfo());
            }
            arena.battle(choice, compChoice);
            finish = arena.finishGame() ;
            turns ++ ;
        }
        arena.showCompUnits();
        arena.showPlayerUnits();
        arena.showWinner();
        in.close();
    }
}
