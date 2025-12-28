package leetcode.meta;

import java.io.*;
import java.util.*;

public class DinosaurSpeed {

    // gravitational constant
    private static final double G = 9.8;

    public static void main(String[] args) throws Exception {

        // Example CSV input as lists of strings (replace with file reading if needed)
        List<String> dataset1 = Arrays.asList(
                "NAME,LEG_LENGTH,DIET",
                "Hadrosaurus,1.2,herbivore",
                "Struthiomimus,0.92,omnivore",
                "Velociraptor,1.0,carnivore"
        );

        List<String> dataset2 = Arrays.asList(
                "NAME,STRIDE_LENGTH,STANCE",
                "Hadrosaurus,1.4,bipedal",
                "Struthiomimus,1.34,bipedal",
                "Velociraptor,2.72,bipedal",
                "Triceratops,1.0,quadrupedal"
        );

        List<String> result = computeFastestDinosaurs(dataset1, dataset2);

        for (String name : result) {
            System.out.println(name);
        }
    }

    public static List<String> computeFastestDinosaurs(List<String> dataset1, List<String> dataset2) {

        // Map: name → leg_length
        Map<String, Double> legLengthMap = new HashMap<>();

        // Parse dataset1
        for (int i = 1; i < dataset1.size(); i++) {
            String[] parts = dataset1.get(i).split(",");
            String name = parts[0];
            double legLength = Double.parseDouble(parts[1]);
            legLengthMap.put(name, legLength);
        }

        // List of (name, speed)
        List<Dino> dinos = new ArrayList<>();

        // Parse dataset2
        for (int i = 1; i < dataset2.size(); i++) {
            String[] parts = dataset2.get(i).split(",");
            String name = parts[0];
            double strideLength = Double.parseDouble(parts[1]);
            String stance = parts[2];

            // Only bipedal dinosaurs
            if (!stance.equalsIgnoreCase("bipedal")) continue;

            // Must exist in dataset1
            if (!legLengthMap.containsKey(name)) continue;

            double legLength = legLengthMap.get(name);

            // speed formula
            double speed = (strideLength / legLength - 1) * Math.sqrt(legLength * G);

            dinos.add(new Dino(name, speed));
        }

        // Sort by speed descending
        dinos.sort((a, b) -> Double.compare(b.speed, a.speed));

        // Extract names
        List<String> result = new ArrayList<>();
        for (Dino d : dinos) {
            result.add(d.name);
        }

        return result;
    }

    // Helper class
    static class Dino {
        String name;
        double speed;

        Dino(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }
    }
}
