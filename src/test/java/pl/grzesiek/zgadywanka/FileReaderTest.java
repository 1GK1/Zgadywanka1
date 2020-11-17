package pl.grzesiek.zgadywanka;

import java.util.Arrays;

public class FileReaderTest {
    public static void main(String[] args) {


// not used
//    String b = "";
//    File file = new File("input.txt");
//    Scanner scanner = new Scanner(file);
//        while (scanner.hasNextLine()) {
//        b += scanner.nextLine().strip();
//        b += " ";
//    }
//
//    String[] array = b.split(" ");
    String[] array = {"a", "b","c"};
        System.out.println(Arrays.toString(array));
        " ".split(array[0]);

        Arrays.stream(array)
                .filter(a -> a.equals("b"))
                .forEach(a -> System.out.println(a));
//    List<String> list = Arrays.asList(array);
//        System.out.println(list);
//    String[] newArray = list.toArray(new String[0]);
//        System.out.println(Arrays.toString(array));
    }
}
