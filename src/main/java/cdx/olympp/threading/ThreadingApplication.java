package cdx.olympp.threading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ThreadingApplication {
    public static String EXPECTED_WORD = "thread";

    public static void main(String[] args) {
        SpringApplication.run(ThreadingApplication.class, args);

        final String FILES_FOLDER = "files";
        List<AdderManager> managers = new ArrayList<>();

        try {
            Set<Path> files = FilesManager.getFiles(FILES_FOLDER);

            for (Path file : files) {
                AdderManager adderManager = new AdderManager(file);
                adderManager.run();
                managers.add(adderManager);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long sum = 0;
        for (AdderManager adderManager : managers) {
            sum += adderManager.getCounter();
        }

        System.out.println("Final sum: " + sum);
    }

}
