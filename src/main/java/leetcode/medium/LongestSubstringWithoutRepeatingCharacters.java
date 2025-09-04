package leetcode.medium;

import java.util.HashSet;
class LongestSubstringWithoutRepeatingCharacters {  
   public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char current = s.charAt(right);
            if (!seen.contains(current)) {
                seen.add(current);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}