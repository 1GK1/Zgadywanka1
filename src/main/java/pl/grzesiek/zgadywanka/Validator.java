package pl.grzesiek.zgadywanka;

import java.util.List;
import java.util.stream.Collectors;

// creating new list with words that are longer than 3 letters
public class Validator {
    public List<String> validateList(List<String> result) {
        return result.stream()
                .filter(a -> a.length() > 3)
                .collect(Collectors.toList());
    }
}
