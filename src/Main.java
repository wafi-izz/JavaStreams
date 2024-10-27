import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/file.txt");
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
            for (String line : lines.toList()){
                System.out.println(line);
            }
            
            //reading the file twice cant happen. the stream could be busy or closed
            for (String line : lines.toList()){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}