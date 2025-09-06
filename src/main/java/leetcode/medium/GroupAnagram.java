package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    //approach 1
   // public List<List<String>> groupAnagrams(String[] strs) {
        // Map<String, List<String>> res = new HashMap<>();
        // for (String s : strs) {
        //     int[] count = new int[26];
        //     for (char c : s.toCharArray()) {
        //         count[c - 'a']++;
        //     }
        //     String key = Arrays.toString(count);
        //     res.putIfAbsent(key, new ArrayList<>());
        //     res.get(key).add(s);
        // }
        // return new ArrayList<>(res.values());
    
        //approach 2
         public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }

    

    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(input);
        System.out.println(result);
    }
}  

