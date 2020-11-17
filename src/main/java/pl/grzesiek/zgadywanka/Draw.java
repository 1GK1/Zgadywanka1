package pl.grzesiek.zgadywanka;

import java.util.List;
import java.util.Random;

public class Draw {
    Random random = new Random();

    public String drawWordFromList(List<String> result) {
        int wordPositionInList = random.nextInt(result.size());
        return result.get(wordPositionInList);
    }

    public char drawLetterFromWord(String wordToGuess) {
        int letterPositionInWord = random.nextInt(wordToGuess.length());
        return wordToGuess.charAt(letterPositionInWord);
    }
}
