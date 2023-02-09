package main.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResolveUrl {
    public static void main(String... args) throws IOException {
        String filePath = "C:\\Users\\19776\\Documents\\Tips\\DM\\A2 DM\\sports.csv";
        var lines = Files.readAllLines(Path.of(filePath));
        String outPath = "C:\\Users\\19776\\Documents\\Tips\\DM\\A2 DM\\SportsArticles\\sports.csv";
        var out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(outPath), StandardCharsets.UTF_8
                ));
        out.println(lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            var line = lines.get(i);
            var strs = line.split(",");
            var url = strs[1];
            var sites = strs[1].split("/");
            for (int j = 0; j < strs.length; j++) {
                if (j == 1)
                    out.print(sites[2] + ",");
                else if (j == strs.length - 1)
                    out.println(strs[j]);
                else
                    out.print(strs[j] + ",");
            }
//            System.out.println(line);
        }
        out.flush();
        out.close();
//        System.out.println();
    }
}
