package pl.grzesiek.zgadywanka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<String> getListFromFile(String fileName) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String a = scanner.next().trim();
            result.add(a);
        }
        return result;
    }
}

//public class FileReader {
//    public List<String> getListFromFile(String fileName) throws IOException {
////            todo simpler solution - dont you think ? To discuss - I get list with two elements - each one is the whole line...
//        String[] array = Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);
//        Arrays.stream(array)
//                .filter(a -> a.length() > 5)
//        .forEach(a -> System.out.println(a));
//
//        return Files.readAllLines(Paths.get(fileName));
//
//    }
//}


