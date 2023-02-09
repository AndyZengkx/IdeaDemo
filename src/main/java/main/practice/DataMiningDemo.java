package main.practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataMiningDemo {
    public static void main(String... args) throws IOException {
        String fileName = "C:\\Users\\19776\\Documents\\Tips\\DM\\Assignment1\\abalone.data";
        String outPath = "C:\\Users\\19776\\Documents\\Tips\\DM\\Assignment1\\abalone.arff";
        File f = new File(outPath);
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        var lines = Files.readAllLines(Path.of(fileName));
        for (int k = 0; k < lines.size(); k++) {
            var strs = lines.get(k).split(",");
            for (int i = 0; i < 9; i++)
                if (i == 8) {
                    int val = Integer.parseInt(strs[i]);
                    if (val <= 5) System.out.println("A");
                    else if (5 < val && val <= 10) System.out.println("B");
                    else if (10 < val && val <= 15) System.out.println("C");
                    else System.out.println("D");
                } else if (i != 5 && i != 6 && i != 7)
                    System.out.print(strs[i] + " ");
        }
    }
}
