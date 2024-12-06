package leetcode;

public class Search_in_Rotated_Sorted_Array_33 {
    public static void main(String args[]){
        System.out.println("Leetcode problem 33 Search_in_Rotated_Sorted_Array:");
        int target =0;
        int[] nums ={4,5,6,7,0,1,2};        ;
        System.out.println("position:"+search(nums,target));
    }
        //binary search algo
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start+end)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[start] <= nums[mid]){   
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
