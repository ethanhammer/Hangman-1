public class Data {
  static boolean game = true;
  static char[] hiddenWordLetters;
  static char[] visibleWordLetters;
  static char currentLetter;
  final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  static int mistakes = 0;
  static char[] currentLetters;
  static String word = "";

  final static String[] baseBoard = {
      "____",
    "|/   |",
    "|     ",
    "|     ",
    "|     ",
    "|     ",
    "|     ",
    "|_____"
  };
  static String oneMistake = "|    O";
  static String twoMistake = "|    |";
  static String threeMistake = "|   /|";
  static String FourMistake = "|   /|/";
  static String fiveMistake = "|   /";
  static String sixMistake = "|   /|";

  public void removeIndex(int letter) { 
    char[] arr_new = new char[currentLetters.length-1];
    int j=letter;
    for(int i=0, k=0;i<currentLetters.length;i++){
      if(i!=j){
      arr_new[k]=currentLetters[i];
      k++;
      }       
    }
  currentLetters = arr_new;
  }
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }  
  
  public boolean checkWin() {
   int correct = 0;
   if (mistakes == 6) {
      System.out.println("YOU LOST! The word was " + word);
      return false;
    }
    for (int i = 0; i < visibleWordLetters.length; i++) {
      if (visibleWordLetters[i] == '\0'){
        return true;
      }
      else {
        correct++;
      }
    }
    if (correct == hiddenWordLetters.length) {
     System.out.println("YOU WON IN " + mistakes + " Mistakes! The word was " + word);
     return false;
    }
    return true;
  }
  
}