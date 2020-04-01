import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

    public static final String DICTIONARY_PATH = "src\\dictionary.txt"; //File path

    //Function to check to see if the inputted word is found it the dictionary
    private boolean checkDictionary(String word)
    {
        String wff = ""; //word from file
        word = word.toLowerCase();
        try{
            BufferedReader read = new BufferedReader(new FileReader(DICTIONARY_PATH));
            while((wff = read.readLine()) != null)
            {
                if(word.equals(wff)) return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    //Few test cases
    public static void main(String[]args)
    {
      Dictionary dictionary = new Dictionary();
      System.out.println("Expected true: " + dictionary.checkDictionary("aahs"));
      System.out.println("Expected false: " + dictionary.checkDictionary("asdlfkjasdflkj"));
    }
}
