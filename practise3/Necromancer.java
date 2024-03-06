package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Necromancer extends Unit{
    Random r = new Random() ;
    public Necromancer() {
        super("Necromancer", 2, 1, false);
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
        return level + 1 ;
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
            System.out.println("Funny when person who revives deadmen dies");
        }
        else 
        {
            System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
            arenaOpponent.damage(this.getAttack());
        }
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        int toRevive= DeadMen(allyWaiting) ;
        if (toRevive != -1)
        {
            System.out.println("Necromancer revived " + allyWaiting.get(toRevive).name);
            allyWaiting.get(toRevive).revive();
        } 
        else 
        {
            System.out.println(name + " damages himself due to not having deadman");
            damage(1);
        }
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println("Necromancer decreased level of his opponent " + arenaOpponent.name);
        arenaOpponent.decreaseLevel();
    }

    public int DeadMen(ArrayList<Unit> allies)
    {
        ArrayList<Integer> deadAllies = new ArrayList<>();
        for (int i = 0 ; i < allies.size() ; i++)
        {
            if (allies.get(i).isDead)
            {
                deadAllies.add(i) ;
            }
        }
        if (deadAllies.isEmpty()) 
        {
            return -1 ;
        }
        return deadAllies.get(r.nextInt(deadAllies.size())) ;
    }
}
