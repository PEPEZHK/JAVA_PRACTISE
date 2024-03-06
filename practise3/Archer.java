package lab3;

import java.util.ArrayList;
import java.util.Random;

public class Archer extends Unit{
    Random r = new Random() ;
    public Archer() {
        super("Archer", 2, 1, false);
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
        return level + 1 ;
    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        if (isDead)
        {
            System.out.println("Robin Hud is sleeping now");
        }
        else 
        {
            System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
            arenaOpponent.damage(this.getAttack());
        }
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        int toAttack = alliveMen(enemyWaiting) ;
        System.out.println(name + " attacks waiting enemy " + enemyWaiting.get(toAttack).name + " by " + getAttack());
        enemyWaiting.get(toAttack).damage(this.getAttack());
        if (enemyWaiting.get(toAttack).isDead) 
        {
            increaseLevel(); 
            System.out.println("Waiting " + enemyWaiting.get(toAttack).name + " is dead now");
        }
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println("Archer heals himself");
        this.heal(1);
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
