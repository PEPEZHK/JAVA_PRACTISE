import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordBag {
    ArrayList<Word> allWords ;
    Word start = new Word("START");
    Word endW = new Word("END");
    public WordBag()
    {
        this.allWords = new ArrayList<Word>() ;
    }

    public void processSentence(String str)
    {
        String[] words = str.split(" ") ;
        for (int i = 0 ; i < words.length - 1; i++) 
        {
            Word curWord = findOrCreate(words[i]);
            Word nextWord = findOrCreate(words[i+1]);
            if (i == 0) 
            {
                start.addFollowedBy(curWord);    
            } 
            curWord.addFollowedBy(nextWord);
            if (i+1 == words.length-1) 
            {
                endW.addFollowedBy(nextWord);
            }
        }
    }

    public Word findOrCreate(String wordText)
    {
        Word w = new Word(wordText) ;
        if (allWords.contains(w)) 
        {
            return allWords.get(allWords.indexOf((w))) ;
        }
        addWord(w); 
        return  allWords.get(allWords.indexOf((w))) ;
    }

    public void addWord(Word w) 
    {
        allWords.add(w);
    }

    public String generateSentence(int softLimit, int hardLimit)
    {
        String genSent = "" ;
        Word toInput = start.getRandomFollow() ; 
        genSent += toInput.getWord() + " " ;
        int c = 0 ;
        while (c < hardLimit) 
        {
            toInput = toInput.getRandomFollow() ;
            if (toInput == null) break ;
            genSent += toInput.getWord() + " " ;
            if (c > softLimit)
            {
                toInput = hasEndWord(toInput) ;
                if (endW.getArr().contains(toInput)) 
                {
                    genSent += toInput.getWord() + " ";
                    return genSent ;
                }
            }
            c++ ; 
        }
        return genSent ;
    }

    public void writeToTextFile(String outputName, int sentenceCount, int softLimit, int hardLimit)  
    {
        try 
        {
            FileWriter writer = new FileWriter(outputName) ;
            for (int i = 0 ; i < sentenceCount ; i++)
            {
                String sentence = generateSentence(softLimit, hardLimit) ;
                writer.write(sentence+"\n");
            }
            writer.close(); 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Word hasEndWord(Word word) 
    {
        if (word.getArr().size() > endW.getArr().size()) 
        {
            for (int i = 0 ; i < endW.getArr().size() ; i++)
            {
                if (word.getArr().contains(endW.getArr().get(i))) 
                {
                    return word.getArr().get(word.getArr().indexOf(endW.getArr().get(i))) ;
                }
            }
        }
        else 
        {
            for (int i = 0 ; i < word.getArr().size() ; i++)
            {
                if (word.getArr().contains(endW.getArr().get(i))) 
                {
                    return word.getArr().get(word.getArr().indexOf(endW.getArr().get(i))) ;
                }
            }
        }
        return word ;
    }
}
