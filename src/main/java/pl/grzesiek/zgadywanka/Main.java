package pl.grzesiek.zgadywanka;

import java.io.FileNotFoundException;

public class Main {
public static boolean fileFound = true;

    public static void main(String[] args) {

        final Game game = new Game();
        final String fileName;
        try {
            fileName = getFileNameFromProgramArguments(args);
            game.init(fileName);
            //handling situation where no file was loaded
            while (!(game.isGameOver() || game.wordsFromFile.isEmpty())) {
                game.start();
                game.playGame();
            }
        } catch (FileNotFoundException e) {
            fileFound = false;
            e.printStackTrace();
        }

        if (fileFound) {
            System.out.println("Game is over. Thanks for your time!");
        }
    }

    private static String getFileNameFromProgramArguments(final String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            return args[0];
        } else {
            throw new FileNotFoundException("Cannot find program argument, please specify them in the: Run/Debug configuration -> Program Arguments.");
        }
    }
}


