package pl.grzesiek.zgadywanka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Test;

public class GameTest {

    private static final String FILE_NAME = "input.txt";
    private List<String> expectedResult;
    private List<String> result;
    private Game game;


    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    public void checkUserAnswer_CorrectLetter_ReturnDecodedWordToGuess() {
        String exceptedResult = "a*********";
        String result = game.checkUserAnswer("automobile", "**********", 'a');
        assertEquals(exceptedResult, result);

        String exceptedResult1 = "a********e";
        String result1 = game.checkUserAnswer("automobile", "a*********", 'e');
        assertEquals(exceptedResult1, result1);

        String exceptedResult2 = "au*******e";
        String result2 = game.checkUserAnswer("automobile", "a********e", 'u');
        assertEquals(exceptedResult2, result2);
    }


    @Test
    public void checkUserAnswer_MultiCorrectLetters_ReturnDecodedWordToGuess() {
        String exceptedResult = "***o*o****";
        String result = game.checkUserAnswer("automobile", "**********", 'o');
        assertEquals(exceptedResult, result);
    }


    @Test
    public void checkUserAnswer_IncorrectLetter_ReturnUncodedWordToGuess() {
        String exceptedResult = "**********";
        String result = game.checkUserAnswer("automobile", "**********", 'x');
        assertEquals(exceptedResult, result);
    }


    @Test
    public void codeWordToGuess_Show3Letters_ReturnCodedWordWith3LettersExposed() {
        String expectedResult = "p*p*p***";
        String result = game.codeWordToGuessNew("papapooa", 'p');
        assertTrue(expectedResult.length() == result.length());
        assertEquals(expectedResult, result);
    }

    @Test
    public void codeWordToGuess_Show1Letter_ReturnCodedWordWith1LetterExposed() {
        String expectedResult = "m*********";
        String result = game.codeWordToGuessNew("montenegro", 'm');
        assertTrue(expectedResult.length() == result.length());
        assertEquals(expectedResult, result);
    }

    @Test
    public void codeWordToGuess_Show2Letter_ReturnCodedWordWith1LetterExposed() {
        String expectedResult = "m********m";
        String result = game.codeWordToGuessNew("montenegrm", 'm');
        assertTrue(expectedResult.length() == result.length());
        assertEquals(expectedResult, result);
    }


//    MethodName_StateUnderTest_ExpectedBehavior

}