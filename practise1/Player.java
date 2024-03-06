import java.util.Random;

public class Player {
    private String name ;
    Random r = new Random() ;

    //Constructor
    public Player(String name)
    {
        this.name = name ;
    }

    public String getName()
    {
        return name ;
    }

    public void setName(String name)
    {
        this.name = name ;
    }

    public void move(int steps)
    {

    }

    // Will be used in order to move
    public int roll()
    {
        return r.nextInt(6) + 1 ;
    }
}
