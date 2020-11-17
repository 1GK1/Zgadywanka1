package pl.grzesiek.zgadywanka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final FileReader reader;
    private final Validator validator;
    public String wordToGuess;
    public String codedWord;
    public List<String> wordsFromFile;
    public Scanner scanner;
    public char letterToShow;
    private char letterAnswered;
    private int numberOfAttempts;
    private int attempt;
    private boolean gameOver;


    public Game() {
        scanner = new Scanner(System.in);
        gameOver = false;
        reader = new FileReader();
        validator = new Validator();
        wordsFromFile = new ArrayList<>();
    }

    public void init(String fileName) {
        wordsFromFile = prepareListOfWords(fileName);
        final String message =
                wordsFromFile.isEmpty()
                        ? "File not found or is empty"
                        : "Game begins...\n";
        if (wordsFromFile.isEmpty()) {
            Main.fileFound = false;
        }
        System.out.println(message);
    }

    public List<String> prepareListOfWords(String fileName) {
        try {
            return validator.validateList(reader.getListFromFile(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private String prepareWordToGuess() {
        Draw random = new Draw();
        wordToGuess = random.drawWordFromList(wordsFromFile);

        // deleting current words from the list - it will not be considered in the next round
        wordsFromFile.remove(wordToGuess);

        letterToShow = random.drawLetterFromWord(wordToGuess);
        return wordToGuess;
    }

    public String codeWordToGuessNew(String wordToGuess, char letterToShow) {
        StringBuilder stringBuilder = new StringBuilder();
        int pdone = 1;
        int pdone1 = 2;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letterToShow) {
                stringBuilder.append(letterToShow);
            } else {
                stringBuilder.append("*");
            }
        }
        return stringBuilder.toString();
    }

//    public String codeWordToGuess(String wordToGuess, char letterToShow) {
//        String hiddenWord = "";
//        for (int i = 0; i < wordToGuess.length(); i++) {
//            if (wordToGuess.charAt(i) == letterToShow) {
//                hiddenWord += letterToShow;
//            } else {
//                hiddenWord += "*";
//            }
//        }
//        return hiddenWord;
//    }

    public void start() {
        wordToGuess = prepareWordToGuess();
        codedWord = codeWordToGuessNew(wordToGuess, letterToShow);

        numberOfAttempts = (int) (wordToGuess.length() * 1.5);
        System.out.printf(
                "Your coded word has %d letters. You have %d attempts to guess it.\n\n",
                wordToGuess.length(), numberOfAttempts);
        System.out.println("Coded word: " + codedWord);
    }

    public void playGame() {
        attempt = 1;
        do {
            System.out.print("Input letter [or press 1 to exit]: ");
            letterAnswered = scanner.next().charAt(0);
            switch (letterAnswered) {
                case '1':
                    System.out.println("\nThe player has stopped the game.");
                    endGame();
                    return;
                default:
                    codedWord = checkUserAnswer(wordToGuess, codedWord, letterAnswered);
                    break;
            }
            System.out.printf("\nCoded word after %d attempt: %s %n", attempt, codedWord);

            if (codedWord.equals(wordToGuess)) {
                System.out.println("You guessed the coded word! Congrats!");
                newGame();
            }
            attempt++;
        } while (attempt <= numberOfAttempts && !isGameOver());


        if (isGameOver()) {
            return;
        }

        System.out.printf("\nSorry, but you lost all your attempts. The coded word was: \"%S\".", wordToGuess);

        newGame();
    }

    private void newGame() {

        if (isWordFromFileEmpty()) {
            System.out.println("\nThere are no more words to guess.");
            endGame();
        } else {
            System.out.println("\nDo you want to play again [y - new game, any key to close]? ");
            if (scanner.next().equals("y")) {
                System.out.println("\nNew game");
                start();
                playGame();
            } else {
                System.out.println("\nThe player has stopped the game.");
                endGame();
            }
        }
    }

    public void endGame() {
        setGameOver(true);
    }

    public String checkUserAnswer(String wordToGuess, String codedWord, char letterFromUser) {
        char[] outputWordChars = codedWord.toCharArray();
        for (int i = 0; i < outputWordChars.length; i++) {
            if (wordToGuess.charAt(i) == letterFromUser) {
                outputWordChars[i] = letterFromUser;
            }
        }
        return String.valueOf(outputWordChars);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isWordFromFileEmpty() {
        return wordsFromFile.isEmpty();
    }
}













/*
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private char letterAnswered;
    public String wordToGuess;
    public String codedWord;
    public List<String> result;
    public Scanner scanner;
    public char letterToShow;
    private int numberOfAttempts;
    private int attempt;
    static public int gameNo = 1;

//    private Draw draw;


    public Game() {
        System.out.println("Game starts...");
        scanner = new Scanner(System.in);
        Draw draw = new Draw();
    }

    // I want to invoke this method only once, when the game begins; if the player wants to continue the game, the same list of words must be used
    public void init(String fileName) {
        prepareListOfWords(fileName);
//        System.out.println("The list has words: " + result.size());
//        System.out.println(result);
    }

    private String prepareWordToGuess() {
        Draw random = new Draw();
        wordToGuess = random.drawWordFromList(result);
        result.remove(wordToGuess);
//        System.out.println("The list has words: " + result.size());
        System.out.println();
        letterToShow = random.drawLetterFromWord(wordToGuess);
        return wordToGuess;
    }

    public void prepareListOfWords(String fileName) {
        if (result == null) {
            try {
//                System.out.println("Preparing list of words");
                FileReader reader = new FileReader();
                Validator validator = new Validator();
                result = reader.getListFromFile(fileName);
                result = validator.validateList(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("List of words is ready...");
        }
    }

    private String codeWordToGuess(String wordToGuess, char letterToShow) {
        String hiddenWord = "";
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letterToShow) {
                hiddenWord += letterToShow;
            } else {
                hiddenWord += "*";
            }
        }
        return hiddenWord;
    }

    public void start() {
        wordToGuess = prepareWordToGuess();
        codedWord = codeWordToGuess(wordToGuess, letterToShow);

        numberOfAttempts = (int) (wordToGuess.length() * 1.5);
        System.out.printf("Your coded word has %d letters. You have %d attempts to guess it.\n\n", wordToGuess.length(), numberOfAttempts);
        System.out.println("Coded word: " + codedWord);
    }

    public void playGame() {
        attempt = 1;
        do {
            System.out.print("Input letter [or press 1 to exit]: ");
            letterAnswered = scanner.next().charAt(0);
            codedWord = checkUserAnswer(wordToGuess, codedWord, letterAnswered);
            System.out.printf("\nCoded word after %d attempt: %s %n", attempt, codedWord);

            if (codedWord.equals(wordToGuess)) {
                System.out.println("You guessed the coded word! Congrat!");
                newGame();
            }
            attempt++;
        } while (attempt <= numberOfAttempts);

        System.out.printf("\nSorry, but you lost all your attempts. The coded word was: \"%S\".", wordToGuess);
        newGame();
    }

    private void newGame() {
        System.out.println("\n\nDo you want to play again [y - new game, any key to close]? ");
        if(scanner.next().equals("y")){
            gameNo++;
            System.out.println("New game\n");
        } else {
            System.out.println("Bye, bye...");
            System.exit(0);
        }
    }

    private String checkUserAnswer(String wordToGuess, String codedWord, char letterFromUser) {

        if (letterAnswered == '1') {
            System.out.println("\nThe player has stopped the game.");
            System.exit(0);
        }

        char[] outputWordChars = codedWord.toCharArray();
        for (int i = 0; i < outputWordChars.length; i++) {
            if (wordToGuess.charAt(i) == letterFromUser) {
                outputWordChars[i] = letterFromUser;
            }
        }
        return String.valueOf(outputWordChars);
    }
}

*/
