package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Healer extends Unit{
    Random r = new Random() ;
    public Healer() {
        super("Healer", 3, 1, false);
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
        return level + 2 ;
    }

    @Override
    public int getAttack()
    {
        return level ;
    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        if (health == getMaxHealth())
        {
            int toHeal = alliveMen(allyWaiting);
            if (toHeal != -1)
            {
                System.out.println("Healer healed " + allyWaiting.get(toHeal).name);
                allyWaiting.get(toHeal).heal(allyWaiting.get(toHeal).level);
            }
        }
        else if (isDead)
        {
            System.out.println("Healer can not heal himself because he is dead");
        }
        else
        {
            System.out.println("Healer heals himself");
            heal(level);
        }
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
        arenaOpponent.damage(this.getAttack());
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        int toRevive = DeadMen(allyWaiting) ;
        if (toRevive != -1)
        {
            System.out.println("Healer revived " + allyWaiting.get(toRevive).name);
            allyWaiting.get(toRevive).revive();
        }
        else 
        {
            System.out.println("Noone to revive");
        }
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

    public int alliveMen(ArrayList<Unit> allies) 
    {
        ArrayList<Integer> liveAllies = new ArrayList<>();
        for (int i = 0 ; i < allies.size() ; i++)
        {
            if (!allies.get(i).isDead && allies.get(i).health < allies.get(i).getMaxHealth())
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