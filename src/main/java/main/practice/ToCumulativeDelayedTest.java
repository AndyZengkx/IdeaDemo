package main.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ToCumulativeDelayedTest {
    public static List<String> ticks;
    public static Comparator cmp = new Comparator<String[]>() {
        public int compare(String[] o1, String[] o2) {
            if (o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        }
    };

    public static List<String> getData(String fileName) throws IOException {
        var lines = Files.readAllLines(Path.of(fileName));
        return lines;
    }

    public static List<String> toCumulativeDelayed(List<String> ticks, int quantityBlock) {
        var ans = new ArrayList<String>();
        var data = new ArrayList<String[]>();
        HashMap<String, double[]> map = new HashMap<>();
        for (var str : ticks)
            data.add(str.split(","));
        Collections.sort(data, cmp);
        for (var line : data) {
            double[] mapRecord = map.get(line[1]);
            double[] record = new double[2];//0:cumulativeQuantity, 1:cumulativeNotional
            int cumulativeQuantity = mapRecord == null ? 0 : (int) mapRecord[0];
            double cumulativeNotional = mapRecord == null ? 0 : mapRecord[1];
            if (cumulativeQuantity < quantityBlock) {
                int newUsedQuantity = Math.min(Integer.parseInt(line[2]), quantityBlock - cumulativeQuantity);
                record[0] = cumulativeQuantity + newUsedQuantity;
                record[1] = cumulativeNotional + newUsedQuantity * Double.parseDouble(line[3]);
                map.put(line[1], record);
                if (record[0] == quantityBlock) {
                    ans.add(line[0] + "," + line[1] + "," + (int) record[0] + "," + record[1]);
                }
            }
        }
        for (var line : ans)
            System.out.println(line);
        return ans;
    }

    public static void main(String... args) throws IOException {
        toCumulativeDelayed(getData("C:\\Users\\19776\\Documents\\Tips\\TestData.txt"), 5);
    }
}
