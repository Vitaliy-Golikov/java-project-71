package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = { "-f", "--format" }, paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public Integer call() throws Exception {
        try {
            // Вызываем метод generate и выводим результат
            String result = Differ.generate(filePath1, filePath2);
            System.out.println(result);
            return 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}