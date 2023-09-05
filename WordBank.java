import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {
    private ArrayList<String> wordList; 

    /**
     * Creates the Workbank object and takes a txt file into wordList
     */
    public WordBank() { 
        wordList = new ArrayList<String>(); 
        File text = new File("words.txt"); 
        Scanner scan;
        try {
            scan = new Scanner(text);
            while (scan.hasNext()) { 
                wordList.add(scan.next()); 
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }     
    }

    /**
     * Returns the arraylist, wordList
     * @return wordList
     */
    public ArrayList<String> getWordList() {
        return wordList;
    }

    /**
     * Gets the word at index i
     * @param i - index of word wanted
     * @return string at wordList index i
     */
    public String getWord(int i) { 
        return getWordList().get(i); 
    }

    /**
     * Gets a random word
     * @return a random string from wordList
     */
    public  String getWord(){
        int rand = (int) (Math.random() * (getWordList().size() + 1));
        return getWord(rand);
    }
    
 }
   
