package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public String read(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readString(path);
    }
}
