import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Array of words to choose from
        String[] words = {"java", "python", "javascript", "hangman", "developer"};
        
        // Select a random word
        Random random = new Random(System.currentTimeMillis());
        String word = words[random.nextInt(words.length)];
        
        // Initialize the display word with underscores
        char[] displayWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            displayWord[i] = '_';
        }
        
        // Number of incorrect guesses
        int incorrectGuesses = 0;
        
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Main game loop
        while (incorrectGuesses < 6) {
            System.out.println("Current word: " + String.valueOf(displayWord));
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.next().charAt(0);
            
            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessedLetter) {
                    displayWord[i] = guessedLetter;
                    correctGuess = true;
                }
            }
            
            if (!correctGuess) {
                incorrectGuesses++;
            }
            
            displayHangman(incorrectGuesses);
            
            // Check if the user has guessed the word
            if (String.valueOf(displayWord).equals(word)) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }
        
        if (incorrectGuesses == 6) {
            System.out.println("Sorry, you lost! The word was: " + word);
        }
        
        scanner.close();
    }
    
    // Method to display the hangman figure
    public static void displayHangman(int incorrectGuesses) {
        System.out.println("Incorrect guesses: " + incorrectGuesses);
        switch (incorrectGuesses) {
            case 0:
                System.out.println("  +---+\n      |\n      |\n      |\n      |\n      |\n=========");
                break;
            case 1:
                System.out.println("  +---+\n  O   |\n      |\n      |\n      |\n      |\n=========");
                break;
            case 2:
                System.out.println("  +---+\n  O   |\n  |   |\n      |\n      |\n      |\n=========");
                break;
            case 3:
                System.out.println("  +---+\n  O   |\n /|   |\n      |\n      |\n      |\n=========");
                break;
            case 4:
                System.out.println("  +---+\n  O   |\n /|\\  |\n      |\n      |\n      |\n=========");
                break;
            case 5:
                System.out.println("  +---+\n  O   |\n /|\\  |\n /    |\n      |\n      |\n=========");
                break;
            case 6:
                System.out.println("  +---+\n  O   |\n /|\\  |\n / \\  |\n      |\n      |\n=========");
                break;
        }
    }
}
