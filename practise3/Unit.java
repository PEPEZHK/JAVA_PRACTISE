package lab3;

import java.util.ArrayList;

public abstract class Unit {
    String name ;
    int health ;
    int level ;
    boolean isDead ;
    public Unit(String name , int health , int level , boolean isDead)
    {
        this.name = name ;
        this.health = health ;
        this.isDead = isDead ;
        this.level = level ;
    }

    public void damage(int damageAmount)
    {
        if (health - damageAmount <= 0)
        {
            isDead = true ;
            health = 0;
        }
        else 
        {
            health -= damageAmount ;
        }
    }

    abstract void increaseLevel();

    abstract void decreaseLevel(); 

    abstract void revive();

    public void heal(int healAmount)
    {
        if (health + healAmount >= getMaxHealth())
        {
            health = getMaxHealth() ;
        }
        else 
        {
            health += healAmount ;
        }
    }

    public String getInfo()
    {
        return name + ", LVL:" + level + ", ATK:" + getAttack() + ", HEALTH:" + health + "/" + getMaxHealth();
    }

    abstract int getAttack();

    abstract int getMaxHealth();

    abstract void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);

    abstract void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);

    abstract void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);
}
