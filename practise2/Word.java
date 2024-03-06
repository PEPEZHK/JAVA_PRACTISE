import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Word {
    private ArrayList<Word> canBeFollowedBy ;
    private String word ;
    public Word(String w)
    {
        word = w ;
        this.canBeFollowedBy = new ArrayList<Word>() ;
    }  
    
    public String getWord()
    {
        return word ;
    }

    public void setWord(String eWord) 
    {
        word = eWord ;
    }

    public ArrayList<Word> getArr() 
    {
        return canBeFollowedBy ;
    }

    public void addFollowedBy(Word w) 
    {
        getArr().add(w);
    }

    public boolean equals(Object other) 
    {
        if (other instanceof Word)
        {
            Word oTher = (Word) other ;
            return this.getWord().equals(oTher.getWord()) ;
        }
        return false ;
    }

    public Word getRandomFollow() 
    {
        Random r = new Random();
        if (canBeFollowedBy.size() == 0) return null ;
        return canBeFollowedBy.get(r.nextInt(canBeFollowedBy.size()));
    }
}
