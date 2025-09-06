package leetcode.msc;

public class MaximumProductSubArray_152 {
    public static void main (String[] arg){
        int[] nums ={5,3,1-2,0,-5,8,-3};
        System.out.print(maxProduct(nums));

    }

    private static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        int result = max;

        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int temp = Math.max(cur, Math.max(max * cur, min * cur));
            min = Math.min(cur, Math.min(min * cur, max * cur));
            max=temp;

            result = Math.max(result, max);
        }
        return result;
    }

}
