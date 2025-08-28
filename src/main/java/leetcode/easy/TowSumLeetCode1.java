package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TowSumLeetCode1 {

    public static void main(String [] args){

        int[] nums = {2,7,11,15};
        int target =18;
        System.out.println(""+ Arrays.toString(findTwoSum(nums, target)));


    }
    public static int[] findTwoSum(int[] nums, int target){
        //Approach 1:
        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
        int req_num=0;
        for(int i=0;i<nums.length-1;i++) {
           req_num = target - nums[i];
           if(hm.containsKey(req_num))
            {
               int[] arr ={hm.get(req_num),i};
               return arr;
            }
           else
           {
               hm.put(nums[i],i);
           }
        }
        return null;

        //Approach 2:
//        HashMap<Integer,Integer> map =new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            Integer complementIndex=map.get(nums[i]);
//            if(complementIndex!=null){
//                return new int[] {i,complementIndex};
//            }
//            map.put(target-nums[i],i);
//
//        }
//        return nums;

    }
}
