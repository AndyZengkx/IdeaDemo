package main.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ToCumulativeWithIter {
    public static List<String> ticks;

    public static List<String> getData(String fileName) throws IOException {
        var lines = Files.readAllLines(Path.of(fileName));
        return lines;
    }

    public static List<String> toCumulative(List<String> ticks) {
        // throw new RuntimeException();
        var ans = new ArrayList<String>();
        var data = new ArrayList<String[]>();
        var map = new HashMap<String, Double[]>();
        for (var str : ticks)
            data.add(str.split(","));
        Collections.sort(data, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                return o1[0].compareTo(o2[0]);
            }
        });
        data.add(new String[]{"", "", "0", "0"});
        if (ticks.size() == 0)
            return ans;
        String preTime = data.get(0)[0], preTicker = data.get(0)[1];
        int cumulativeQuantity = 0;
        double cumulativeNotional = 0;
        var stringBuilder = new StringBuilder();
        stringBuilder.append(preTime + ",");
        for (var line : data) {
            if (line[0].equals(preTime) && line[1].equals(preTicker)) {
                preTime = line[0];
                preTicker = line[1];
                cumulativeQuantity += Integer.parseInt(line[2]);
                cumulativeNotional += cumulativeQuantity * Double.parseDouble(line[3]);
            } else {
                map.put(preTicker, new Double[]{(double) cumulativeQuantity, cumulativeNotional});
                stringBuilder.append(preTicker + "," + cumulativeQuantity + "," + cumulativeNotional + ",");
                preTicker = line[1];
                var previousResult = map.get(line[1]);
                if (previousResult == null) {
                    cumulativeQuantity = 0;
                    cumulativeNotional = 0;
                } else {
                    cumulativeQuantity = previousResult[0].intValue();
                    cumulativeNotional = previousResult[1];
                }
                cumulativeQuantity += Integer.parseInt(line[2]);
                cumulativeNotional += Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
                if (!line[0].equals(preTime)) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    ans.add(new String(stringBuilder));
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append(line[0] + ",");
                    preTime = line[0];
                }
            }
        }
        for (var line : ans) System.out.println(line);
        return ans;
    }

    public static void main(String... args) throws IOException {
        toCumulative(getData("C:\\Users\\19776\\Documents\\Tips\\TestData.txt"));
    }
}
