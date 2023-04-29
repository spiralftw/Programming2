
import java.util.Random;
import java.util.*;
import java.util.ArrayList;

public class Hangman {
    public String wordToGuess;
    int amountOfGuesses;
    List<Character> guesses = new ArrayList<>();
    List<Character> correctGuesses = new ArrayList<>();
    String maskedWord;
    

    Hangman(WordList wordList, int amountOfGuesses){
        int size = wordList.giveWords().size();
        Random random = new Random();
        int randomValueInRange = random.nextInt(size);
        this.wordToGuess = wordList.giveWords().get(randomValueInRange);
        this.maskedWord = getMaskedWord(wordToGuess);
        this.amountOfGuesses = amountOfGuesses;
    }

    public boolean guess(Character c) {
        Character x = Character.toLowerCase(c);
        if (!guesses.contains(x)){
            guesses.add(x);
        }
        if (wordToGuess.indexOf(x) != -1) {
            correctGuesses.add(x);
            unmaskLetters(x);
            return true;
        } else {
            amountOfGuesses--;
            return false;
        }
    }
    

    public List<Character> guesses(){
        for(char guess : guesses){
            if (!guesses.contains(guess)) {
                guesses.add(guess);
            }
        }
        return guesses;
    }


    public int guessesLeft(){
        if(amountOfGuesses > 0){
            return amountOfGuesses;
        }else return 0;
    }

    public String word(){
        return wordToGuess;
    }

    public boolean theEnd() {
    if(maskedWord.equals(wordToGuess) || guessesLeft() == 0){
        return true;
    }else return false;  
    }


    public String getMaskedWord(String wordToGuess) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
          sb.append("*");
        }
        return sb.toString();
      }

    private void unmaskLetters(Character c) {
        StringBuilder maskedWordBuilder = new StringBuilder(maskedWord);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == c) {
                maskedWordBuilder.setCharAt(i, c);
            }
        }
    maskedWord = maskedWordBuilder.toString();
    }
}
