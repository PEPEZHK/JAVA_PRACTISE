package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Bard extends Unit{
    Random r = new Random() ;
    public Bard() {
        super("Bard", 1, 1, false);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void increaseLevel() {
        // TODO Auto-generated method stub
        System.out.println(name + " leveled up");
        level ++ ;
    }
    @Override
    public void decreaseLevel() {
        // TODO Auto-generated method stub
        if (level > 1)
        {
            System.out.println(name + " leveled down");
            level -- ;
            if (getMaxHealth() < health)
            {
                health = getMaxHealth() ;
            }
        }
    }

    @Override
    public void revive() {
        // TODO Auto-generated method stub
        isDead = false ;
        System.out.println(name + " is revived");
        if (level > 1)
        {
            decreaseLevel();
        }
        else 
        {
            health = getMaxHealth();
        }
    }

    @Override
    public int getMaxHealth()
    {
        return level ;
    }

    @Override
    public int getAttack()
    {
        return level ;
    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        if (isDead)
        {
            System.out.println("Good singer - dead singer");
        }
        else 
        {
            System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
            arenaOpponent.damage(this.getAttack());
        }
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println("Bard heals himself");
        heal(1);
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        int toIncrease = alliveMen(allyWaiting) ;
        System.out.println("Bard leveled up " + allyWaiting.get(toIncrease).name);
        allyWaiting.get(toIncrease).increaseLevel();
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
        return liveAllies.get(r.nextInt(liveAllies.size())) ;
    }
}
