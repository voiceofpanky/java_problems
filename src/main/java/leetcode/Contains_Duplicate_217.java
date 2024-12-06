package leetcode;

import java.util.HashSet;

public class Contains_Duplicate_217 {
    public static void main (String[] arg){
        int[] arr ={7,1,5,3,6,4,8};
        System.out.print(checkDuplicate(arr));

    }

    private static boolean checkDuplicate(int[] arr) {
        HashSet<Integer> seenDuplicate =new HashSet<Integer>();
        for(int num:arr){
            if(seenDuplicate.contains(num)){
                return true;
            }
            seenDuplicate.add(num);
        }

        return false;
    }
}
