package leetcode.meta;

import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Solution class with DFS right-side view /*******************************************/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;

        // First time reaching this depth → rightmost node
        if (depth == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
/*******************************************//*******************************************/
// Main class to take input and print output
public class BinaryTreeRightSideView199 {

    // Build tree from level-order input (like LeetCode)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        // Example input (same format as LeetCode)
        Integer[] input = {1, 2, 3, null, 5, null, 4};

        TreeNode root = buildTree(input);

        Solution sol = new Solution();
        List<Integer> result = sol.rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}