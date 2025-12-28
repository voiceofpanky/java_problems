package leetcode.meta;

import java.util.*;

public class MergeThreeSortedArrays {

    static class Node {
        int value;
        int arrIndex;
        int elemIndex;

        Node(int value, int arrIndex, int elemIndex) {
            this.value = value;
            this.arrIndex = arrIndex;
            this.elemIndex = elemIndex;
        }
    }

    public static List<Integer> mergeThree(int[] a, int[] b, int[] c) {
        List<int[]> arrays = Arrays.asList(a, b, c);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (x, y) -> Integer.compare(x.value, y.value)
        );

        // Push first element of each array
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).length > 0) {
                minHeap.offer(new Node(arrays.get(i)[0], i, 0));
            }
        }

        List<Integer> result = new ArrayList<>();
        Integer prev = null; // for Meta variant: remove duplicates

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();

            // Meta variant: skip duplicates
            if (prev == null || prev != node.value) {
                result.add(node.value);
                prev = node.value;
            }

            // Push next element from the same array
            int nextIndex = node.elemIndex + 1;
            int[] arr = arrays.get(node.arrIndex);

            if (nextIndex < arr.length) {
                minHeap.offer(new Node(arr[nextIndex], node.arrIndex, nextIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7};
        int[] b = {2, 5, 8};
        int[] c = {3, 6, 9};

        System.out.println(mergeThree(a, b, c));
    }
}