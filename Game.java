import java.util.Arrays;
import java.util.Scanner;

public class Game extends Data {
  
Scanner scan = new Scanner(System.in);
String[] board = new String[baseBoard.length];

  
  public Game() {}

  public void createWord() {
    visibleWordLetters = new char[word.length()];
    hiddenWordLetters = word.toCharArray();
  }

  public void updateGraphics() {
    switch(mistakes) {
      case 1: board[2] = oneMistake; break;
      case 2: board[3] = twoMistake; break;
      case 3: board[3] = threeMistake; break;
      case 4: board[3] = FourMistake; break;
      case 5: board[4] = fiveMistake; break;
      case 6: board[4] = sixMistake; break;
  
  }
    }

  public void getLetter() {
    do {
    System.out.println("\nChoose a letter");
    currentLetter = Character.toLowerCase(scan.next().charAt(0));
    } while (checkLetterAvailability());

  }
  
  public boolean checkLetterAvailability() {
    for (int i = 0; i < currentLetters.length; i++) {
      if (currentLetter == currentLetters[i]) {
        removeIndex(i);
        return false;
      }
    }
    System.out.println("That letter is not available");
    return true;
  }

  public void printScreen() {
  updateGraphics();
    for (int i = 0; i < board.length; i++) {
      System.out.println(board[i]);
    }
    for (int i = 0; i < visibleWordLetters.length; i++) {
      if (visibleWordLetters[i] == '\0'){
        System.out.print("_");
      }
      else {
        System.out.print(visibleWordLetters[i]);
      }
    }
  }

  public void matchLetter() {
    int wrong = 0;
    for (int i = 0; i < hiddenWordLetters.length; i++) {
      if (currentLetter == hiddenWordLetters[i]) {
        visibleWordLetters[i] = currentLetter; 
        System.out.println(Arrays.toString(visibleWordLetters));
      } 
        else {
          wrong++;
        }
    }
    if (wrong == hiddenWordLetters.length) {
      mistakes++;
    }
  }
  
  public void getWord() {
    System.out.println("Type a word!");
    String newWord = "";
      do{
      System.out.println("It must be between 3 and 15 characters:");
      newWord = scan.next();
      }while (newWord.length() > 15 || newWord.length() < 3); 
        word = newWord.toLowerCase();
        clearScreen();
    }
  
  public void resetBoard() {
    for (int i = 0; i < board.length; i++) {
      board[i] = baseBoard[i];
    }
  }

  public void play() {
    while (true) {
    currentLetters = letters;
    mistakes = 0;
    getWord();
    createWord();
    resetBoard();
    do {
      printScreen();
      getLetter();
      matchLetter();
      clearScreen();
      } while(checkWin());
    }
  }
  
}