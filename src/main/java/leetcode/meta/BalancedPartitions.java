package leetcode.meta;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BalancedPartitions {
    public static void main(String[] args) throws IOException {
        // Read file.txt located in the same folder where the program is run
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/leetcode/meta/file.txt"));

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int[] arr = parseLine(line);
            List<int[][]> partitions = findBalancedPartitions(arr);
            printPartitions(arr, partitions);
        }
    }

    private static int[] parseLine(String line) {
        String[] parts = line.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static List<int[][]> findBalancedPartitions(int[] arr) {
        List<int[][]> result = new ArrayList<>();
        long total = 0;
        for (int v : arr) total += v;
        long left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            left += arr[i];
            long right = total - left;
            if (left == right) {
                int[] leftPart = Arrays.copyOfRange(arr, 0, i + 1);
                int[] rightPart = Arrays.copyOfRange(arr, i + 1, arr.length);
                result.add(new int[][] { leftPart, rightPart });
            }
        }
        return result;
    }

    private static void printPartitions(int[] arr, List<int[][]> parts) {
            for (int[][] p : parts) {
            System.out.println(Arrays.toString(p[0]) + " , " + Arrays.toString(p[1]));
        }
    }
}