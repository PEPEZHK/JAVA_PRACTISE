package lab3;

import java.util.ArrayList;

public class Warrior extends Unit{
    public Warrior() {
        super("Warrior", 3, 1, false) ;
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
        return level + 1;
    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        if (isDead)
        {
            System.out.println("Welcome to Valhalla warrior");
        }
        else 
        {
            System.out.println("Warrior does nothing");
        }
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
        arenaOpponent.damage(this.getAttack());
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting)
    {
        System.out.println(name + " attacks " + arenaOpponent.name + " by " + getAttack());
        arenaOpponent.damage(this.getAttack());
    }
}
