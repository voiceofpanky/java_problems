package leetcode.meta;
import java.util.*;
public class SortFrequencyWithOrder {

        public static String customSort(String input, String order) {
            // Step 1: Count frequency of each character in input
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : input.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            // Step 2: Build result using the custom order
            StringBuilder result = new StringBuilder();
            for (char c : order.toCharArray()) {
                int count = freqMap.getOrDefault(c, 0);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                freqMap.remove(c); // remove processed character
            }

            // Step 3: Append remaining characters (if any)
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    result.append(entry.getKey());
                }
            }

            return result.toString();
        }

        public static void main(String[] args) {
            String input = "abcca";
            String order = "cba";
            String sorted = customSort(input, order);
            System.out.println("Sorted output: " + sorted); // Output: ccbaa
        }
    }

