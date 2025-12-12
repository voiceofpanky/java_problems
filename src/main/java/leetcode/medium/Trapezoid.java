package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trapezoid {

    private static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count points per y-coordinate
        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }

        // Compute C(n,2) for each line
        List<Long> combs = new ArrayList<>();
        for (int count : freq.values()) {
            if (count >= 2) {
                combs.add((long) count * (count - 1) / 2);
            }
        }

        // Sum over all pairs
        long total = 0;
        long prefixSum = 0;
        for (long c : combs) {
            total = (total + (c * prefixSum) % MOD) % MOD;
            prefixSum = (prefixSum + c) % MOD;
        }

        return (int) total;
    }

    public static void main(String[] args) {
        Trapezoid sol = new Trapezoid();
        int[][] points = {
                {1,0}, {2,0}, {3,0}, {2,2}, {3,2}
        };
        int result = sol.countTrapezoids(points);
        System.out.println("Number of trapezoids: " + result);
    }

}
