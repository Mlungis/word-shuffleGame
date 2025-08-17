import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {
    public static void main(String[] args) {
        ArrayList<String> wordBank = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordBank.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading words.txt");
            return;
        }

        if (wordBank.isEmpty()) {
            System.out.println("No words found.");
            return;
        }

        String secretWord = wordBank.get(new Random().nextInt(wordBank.size()));
        MyArrayList<WrapperClass> wordList = WrapperClass.loadWord(secretWord);

        Scanner scanner = new Scanner(System.in);
        int incorrectGuesses = 0;
        final int MAX_GUESSES = 7;

        while (incorrectGuesses < MAX_GUESSES) {
            System.out.println("Word: " + wordList);
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            boolean correct = false;
            for (int i = 0; i < wordList.size(); i++) {
                WrapperClass wc = wordList.get(i);
                if (wc.getLetter() == guess && !wc.shows()) {
                    wc.showletter();
                    correct = true;
                }
            }

            if (!correct) {
                incorrectGuesses++;
                wordList.showHint();
            }

            if (wordList.verifyWinner()) {
                System.out.println("Word: " + wordList);
                System.out.println("You win!");
                return;
            }
        }

        System.out.println("You lost. The word was: " + secretWord);
    }
}