package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodingDecoding {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        EncodingDecoding encodingDecoding = new EncodingDecoding();
       // List<String> strs = List.of("hello", "world");
        List<String> strs = new ArrayList<>(Arrays.asList("neet","code","love","you"));
        String encoded = encodingDecoding.encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = encodingDecoding.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
