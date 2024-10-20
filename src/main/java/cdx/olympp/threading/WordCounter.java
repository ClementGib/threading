package cdx.olympp.threading;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class WordCounter {
    public static long count(String expectedWord, String line) {
        return Arrays.stream(line.toLowerCase().split("\\s+"))
                .filter(expectedWord::equals)
                .count();
    }
}
