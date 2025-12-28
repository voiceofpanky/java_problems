package leetcode.meta;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Skip middle if odd length
        if (fast != null) {
            slow = slow.next;
        }

        // Step 3: Reverse second half
        ListNode second = reverse(slow);

        // Step 4: Compare halves
        ListNode first = head;
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // Helper to build list from array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();

        // Example 1: [1, 2, 2, 1] → true
        int[] input1 = {1, 2, 2, 1};
        ListNode head1 = buildList(input1);
        System.out.println("Is palindrome: " + sol.isPalindrome(head1)); // true

        // Example 2: [1, 2] → false
        int[] input2 = {1, 2};
        ListNode head2 = buildList(input2);
        System.out.println("Is palindrome: " + sol.isPalindrome(head2)); // false
    }
}