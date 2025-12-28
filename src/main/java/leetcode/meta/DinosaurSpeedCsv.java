package leetcode.meta;
import java.io.*;
import java.util.*;

public class DinosaurSpeedCsv {

    private static final double G = 9.8;

    public static void main(String[] args) throws Exception {

        // Replace with your actual file paths
        String file1 = "src/main/java/leetcode/meta/dataset1.csv";
        String file2 = "src/main/java/leetcode/meta/dataset2.csv";

        List<String> dataset1 = readCsvFile(file1);
        List<String> dataset2 = readCsvFile(file2);

        List<String> result = computeFastestDinosaurs(dataset1, dataset2);

        for (String name : result) {
            System.out.println(name);
        }
    }

    // Reads a CSV file into a List<String>
    public static List<String> readCsvFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        }

        return lines;
    }

    public static List<String> computeFastestDinosaurs(List<String> dataset1, List<String> dataset2) {

        Map<String, Double> legLengthMap = new HashMap<>();
        List<Dino> dinos = new ArrayList<>();

        // Parse dataset1 (name → leg_length)
        for (int i = 1; i < dataset1.size(); i++) {
            String[] parts = dataset1.get(i).split(",");
            String name = parts[0];
            double legLength = Double.parseDouble(parts[1]);
            legLengthMap.put(name, legLength);
        }

        // Parse dataset2
        for (int i = 1; i < dataset2.size(); i++) {
            String[] parts = dataset2.get(i).split(",");
            String name = parts[0];
            double strideLength = Double.parseDouble(parts[1]);
            String stance = parts[2];

            if (!stance.equalsIgnoreCase("bipedal")) continue;
            if (!legLengthMap.containsKey(name)) continue;

            double legLength = legLengthMap.get(name);

            double speed = (strideLength / legLength - 1) * Math.sqrt(legLength * G);

            dinos.add(new Dino(name, speed));
        }

        // Sort by speed descending
        dinos.sort((a, b) -> Double.compare(b.speed, a.speed));

        List<String> result = new ArrayList<>();
        for (Dino d : dinos) {
            result.add(d.name);
        }

        return result;
    }

    static class Dino {
        String name;
        double speed;

        Dino(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }
    }
}