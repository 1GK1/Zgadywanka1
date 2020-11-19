package pl.grzesiek.zgadywanka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Test;

class GameTest {

    private static final String FILE_NAME = "input.txt";
    private List<String> expectedResult;
    private List<String> result;
    private Game game;


    @BeforeEach
    void setup() {
        game = new Game();


//        result = game.prepareListOfWords(FILE_NAME);
//        Collections.sort(result);
//        expectedResult = new ArrayList<>();
//        expectedResult.add("mean");
////        expectedResult.add("hey");
//        expectedResult.add("wine");
//        expectedResult.add("bite");
//        Collections.sort(expectedResult);
    }

//    @Test
//    void checkIfFileReaderWorksss() {
//
//        assertEquals(expectedResult, result);
//    }
//
//
//    @Test
//    void testIfHasItems() {
//        Assert.assertThat(
//                result,
//                hasItems("wine", "bite"));
//    }
//
//    @Test
//    public void testAssertThatHasItems() {
//        assertThat(
//                Arrays.asList("Java", "Kotlin", "Scala"),
//                hasItems("Java", "Kotlin"));
//    }
//
//
//    // just one test in one Class? What to do if I need to do more?
//
//
//    @Test
//    void checkIfFileReaderWorks() {
////        fail("FAIL - test not completed");
//        result = game.prepareListOfWords(FILE_NAME);
//        Collections.sort(result);
//        String expected = "Baeldung";
//        String actual = "Baeldung";
//        String car = "a";
//
//        Assertions.assertAll(
//                "INFO:",
//                () -> assertEquals(expectedResult, result, "List is not equal"),
//                () -> assertEquals(expected, actual, "NOT EQUAL"),
//                () -> assertNull("The car should be null", car)
//
//        );
//    }


//     @Test
//     public void givenMultipleAssertion_whenAssertingAll_thenOK() {
//         assertAll(
//                 "heading",
//                 () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
//                 () -> assertEquals("java", "JAVA".toLowerCase()),
//                 () -> assertEquals(null, null, "null is equal to null")
//         );
//     }

//    @Test
//    public void whenAssertingEquality_thenEqual() {
//        String expected = "Baeldung";
//        String actual = "Baeldung";
//
//        assertEquals(expected, actual, "NOT EQUAL");
//    }
//
//
//    @Test
//    public void whenAssertingNull_thenTrue() {
//        String car = null;
//        assertNull("The car should be null", car);
//    }
//
//    @Test
//    public void whenAssertingConditions_thenVerified() {
//        assertTrue("5 is greater then 4", 5 > 4);
//        assertFalse("5 is not greater then 6", 5 > 6);
//    }

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