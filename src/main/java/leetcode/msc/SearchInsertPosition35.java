package leetcode.msc;

public class SearchInsertPosition35 {
    public static void main(String args[]){
        System.out.println("Leetcode problem 35 search insert position:");
        int target =11;
        int[] nums ={1,3,5,7,8,9};        ;
        System.out.println("position:"+searchInsertPosition(nums,target));
    }

    private static int searchInsertPosition(int[] nums, int target) {
        int start =0;
        int end =nums.length-1;
        while (start<=end){
            int mid =(start+end)/2;

            if(nums[mid]>target){
                end=mid-1;
            }
            else if (nums[mid]<target){

                start =mid+1;
            }
           else if(nums[mid]==target){
                return mid;
            }
            else {
                return -1;
            }
        }
        return start;
    }
}
