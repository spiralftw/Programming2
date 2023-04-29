
import java.io.*;
import java.util.*;

public class WordList{
    private ArrayList<String> words;

    WordList(String filename){
        words = new ArrayList<String>();
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String word = scanner.nextLine().toLowerCase();
                if (!words.contains(word)){
                    words.add(word);
                }
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("No such file found: " + filename);
        }
    }

    WordList(ArrayList <String> words){
        this.words = words;
    }

    public List<String> giveWords(){
        return words;
    }

    public WordList theWordsOfLength(int length) {

    ArrayList<String> wordsOfLength = new ArrayList<>();
    for (String word : words) {
        if (word.length() == length) {
            wordsOfLength.add(word);
        }
    }
        return new WordList(wordsOfLength);
    }

public WordList theWordsWithCharacters(String someString) {
    ArrayList<String> matchingWords = new ArrayList<>();
    for (String word : words) {
        if (word.length() == someString.length()) {
            boolean isMatch = true;
            for (int i = 0; i < someString.length(); i++) {
                char c = someString.charAt(i);
                if (c != '_' && c != word.charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                matchingWords.add(word);
            }
        }
    }
    return new WordList(matchingWords);
}
}

