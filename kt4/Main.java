
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    String filename = "words.txt";
    Scanner scanner = new Scanner(System.in);
   
    WordList wordList = new WordList(filename);
    Hangman hangman = new Hangman(wordList, 10);
      

  while(!hangman.theEnd()){
      System.out.println("The hidden word...\n" + hangman.maskedWord);
      System.out.println("Guesses left: "+ hangman.guessesLeft());
      System.out.println("Guessed letters: "+ hangman.guesses());
      System.out.print("Guess a letter: ");
      char inputChar = scanner.next().toLowerCase().charAt(0);
      hangman.guess(inputChar);
      if(hangman.guessesLeft() < 1){
        System.out.println("Sorry, you lost!\nThe hidden word was: \"" + hangman.word() + "\"");
        break;
      }
      if (hangman.theEnd() == true){
        System.out.println("Congratulations! You won!!!\nThe hidden word was: \"" + hangman.word() + "\"");
      }
  }
  scanner.close();

    }
  }
