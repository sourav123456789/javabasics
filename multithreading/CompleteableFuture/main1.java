import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class main1 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("files-custom/input.txt");
        CompletableFuture.supplyAsync(() -> readFile(file))
                .thenApplyAsync(main1::transform)
                .thenAcceptAsync(main1::writeLines)
                .thenAccept((c) -> System.out.println("completed"))
                .join();

        System.out.println("main method completed");


    }

    private static void writeLines(List<String> lines) {
        File file = new File("files-custom/output.txt");
        try {
            if(file.createNewFile()) {
                System.out.println("File is created!!!");
            }
            Files.write(file.toPath() , lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<String> transform(List<String> lines) {
        return lines.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static List<String> readFile(File file)  {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
