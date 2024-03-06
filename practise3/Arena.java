package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
    ArrayList<Unit> playerUnits ;
    ArrayList<Unit> computerUnits ;
    Unit playerUnit ;
    Unit compUnit ;
    Random r = new Random() ;
    public Arena()
    {
        playerUnits = new ArrayList<>() ;
        playerUnits.add(new Warrior()) ;
        computerUnits = new ArrayList<>() ;
        computerUnits.add(new Warrior()) ;
    }

    public void fillArena()
    {
        for (int i = 0 ; i < 6 ; i ++) 
        {
            int randomUnit = r.nextInt(7) + 1;
            switch (randomUnit) 
            {
                case 1 : playerUnits.add(new Warrior()) ; break ;
                case 2 : playerUnits.add(new Archer()) ; break ;
                case 3 : playerUnits.add(new Healer()) ; break ;  
                case 4 : playerUnits.add(new Wizard()) ; break ;
                case 5 : playerUnits.add(new Rogue()) ; break ;
                case 6 : playerUnits.add(new Bard()) ; break ;
                case 7 : playerUnits.add(new Necromancer()) ; break ;
            } 
            randomUnit = r.nextInt(7) + 1;
            switch (randomUnit) 
            {
                case 1 : computerUnits.add(new Warrior()) ; break ;
                case 2 : computerUnits.add(new Archer()) ; break ;
                case 3 : computerUnits.add(new Healer()) ; break ;  
                case 4 : computerUnits.add(new Wizard()) ; break ;
                case 5 : computerUnits.add(new Rogue()) ; break ;
                case 6 : computerUnits.add(new Bard()) ; break ;
                case 7 : computerUnits.add(new Necromancer()) ; break ;
            } 
        }
    }

    public void battle(int playerInd , int compInd) 
    {
        playerUnit = playerUnits.get(playerInd) ;
        playerUnits.remove(playerInd) ;
        compUnit = computerUnits.get(compInd) ;
        computerUnits.remove(compInd) ;

        
        playerUnit.firstPhase(compUnit, playerUnits, computerUnits);
        if (dedik(compUnit))
        {
            System.out.println("System: " + compUnit.name + " is dead");
            System.out.println("Game: Battle ended after phase 1");
            playerUnits.add(playerUnit) ;
            computerUnits.add(compUnit) ;
            playerUnit.increaseLevel();
        }
        else 
        {
            compUnit.firstPhase(playerUnit, computerUnits, playerUnits);
            if (dedik(playerUnit) && dedik(compUnit))
            {
                System.out.println("Game: Both of them are dead");
                System.out.println("Battle ended after phase 1");
                playerUnits.add(playerUnit) ;
                computerUnits.add(compUnit) ;
            }
            else if (dedik(playerUnit))
            {
                System.out.println("Player: " + playerUnit.name + " is dead");
                System.out.println("Game: Battle ended after phase 1");
                playerUnits.add(playerUnit) ;
                computerUnits.add(compUnit) ;
                compUnit.increaseLevel();
            }
            else 
            {
                playerUnit.secondPhase(compUnit, playerUnits, computerUnits);
                if (dedik(compUnit))
                {
                    System.out.println("System: " + compUnit.name + " is dead");
                    System.out.println("Game: Battle ended after phase 2");
                    computerUnits.add(compUnit) ;
                    playerUnits.add(playerUnit) ;
                    playerUnit.increaseLevel();
                }
                else 
                {
                    compUnit.secondPhase(playerUnit, computerUnits, playerUnits);
                    if (dedik(playerUnit) && dedik(compUnit))
                    {
                        System.out.println("Game: Both of them are dead");
                        System.out.println("Game: Battle ended after phase 2");
                        playerUnits.add(playerUnit) ;
                        computerUnits.add(compUnit) ;
                    }
                    else if (dedik(playerUnit))
                    {
                        System.out.println("Player: " + playerUnit.name + " is dead");
                        System.out.println("Game: Battle ended after phase 2");
                        playerUnits.add(playerUnit) ;
                        computerUnits.add(compUnit) ;
                        compUnit.increaseLevel();
                    }
                    else 
                    {
                        playerUnit.thirdPhase(compUnit, playerUnits, computerUnits);
                        if (dedik(compUnit))
                        {
                            System.out.println("System: " + compUnit.name + " is dead");
                            System.out.println("Game: Battle ended after phase 2");
                            computerUnits.add(compUnit) ;
                            playerUnits.add(playerUnit) ;
                            playerUnit.increaseLevel();
                        }
                        else 
                        {
                            compUnit.thirdPhase(playerUnit, computerUnits, playerUnits);
                            if (dedik(playerUnit) && dedik(compUnit))
                            {
                                System.out.println("Game: Both of them are dead");
                                System.out.println("Game: Battle ended after phase 3");
                                playerUnits.add(playerUnit) ;
                                computerUnits.add(compUnit) ;
                            }
                            else if (dedik(playerUnit))
                            {
                                System.out.println("Player: " + playerUnit.name + " is dead");
                                System.out.println("Game: Battle ended after phase 3");
                                playerUnits.add(playerUnit) ;
                                computerUnits.add(compUnit) ;
                                compUnit.increaseLevel();
                            }
                        }
                    }
                }
            }
        }
        if (!playerUnit.isDead && !compUnit.isDead)
        {
            playerUnits.add(playerUnit) ;
            computerUnits.add(compUnit) ;
        }
    }

    public boolean dedik(Unit poluy)
    {
        return poluy.isDead ;
    }

    public void showWinner()
    {
        int winner = alliveMen(computerUnits) ;
        if (winner == -1)
        {
            System.out.println("Player wins");
        }
        else  
        {
            System.out.println("Computer wins");
        }
    }

    public boolean everyoneIsDead(ArrayList<Unit> arr)
    {
        for (int i = 0 ; i < arr.size() ; i++)
        {
            if (!arr.get(i).isDead)
            {
                return false ;
            }
        }
        return true ;
    }

    public boolean finishGame()
    {
        boolean pl = everyoneIsDead(playerUnits) ;
        boolean comp = everyoneIsDead(computerUnits) ;
        if (pl || comp)
        {
            return true ;
        }
        return false ;
    }

    public void showCompUnits()
    {
        System.out.println("Computer units");
        for (int i = 0 ; i < computerUnits.size() ; i++)
        {
            System.out.println((i+1) + "." +computerUnits.get(i).getInfo());
        }
    }

    public void showPlayerUnits()
    {
        System.out.println("Player units");
        for (int i = 0 ; i < playerUnits.size() ; i++)
        {
            System.out.println((i+1) + "." +playerUnits.get(i).getInfo());
        }
    }

    public boolean battleIsFinished(Unit player , Unit comp)
    {
        if (player.isDead || comp.isDead)
        {
            return true ;
        }
        return false ;
    }

    public int alliveMen(ArrayList<Unit> allies) 
    {
        ArrayList<Integer> liveAllies = new ArrayList<>();
        for (int i = 0 ; i < allies.size() ; i++)
        {
            if (!allies.get(i).isDead)
            {
                liveAllies.add(i) ;
            }
        }
        if (liveAllies.isEmpty())
        {
            return -1 ;
        }
        return liveAllies.get(r.nextInt(liveAllies.size())) ;
    }
}
