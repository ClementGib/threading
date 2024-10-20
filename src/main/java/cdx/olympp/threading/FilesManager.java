package cdx.olympp.threading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class FilesManager {

    public static Set<Path> getFiles(String pathStr) throws IOException {
        Path path = Paths.get(pathStr);
        return Files.list(path).filter(Files::isRegularFile).collect(Collectors.toSet());
    }
}
