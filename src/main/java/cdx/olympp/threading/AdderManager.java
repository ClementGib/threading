package cdx.olympp.threading;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static cdx.olympp.threading.ThreadingApplication.EXPECTED_WORD;

public class AdderManager implements Runnable {
    final Path file;
    long counter = 0;

    public AdderManager(Path file) {
        this.file = file;
    }

    public Path getFile() {
        return file;
    }

    public long getCounter() {
        return counter;
    }

    private void process() {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                counter += WordCounter.count(EXPECTED_WORD, line);
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    @Override
    public void run() {
        process();
    }
}
