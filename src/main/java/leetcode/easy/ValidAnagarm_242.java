package leetcode.easy;

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length())
        {
            return false;
        }
               HashMap<Character, Integer> countS = new HashMap<>();
             HashMap<Character, Integer> countT = new HashMap<>();

            for(int i=0;i<s.length();i++)
            {
                countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i),0)+1);
                countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i),0)+1);

            }
            return countS.equals(countT);
                          
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(sol.isAnagram(s, t)); // Output: true
    }
    
}