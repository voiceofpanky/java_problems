package leetcode;

public class MisingNumber_268 {

    public static int missingNumber(int[] nums){
        int xOr=0;
        int missingNumber=0;
        for(int i=0;i<=nums.length;i++){
            xOr=xOr^i;

        }
        for(int i=0; i<=nums.length-1;i++){
            xOr=xOr^nums[i];

        }
        return xOr;
    }

    public static void main(String[] args){
        int nums[] ={3,0,1};
       System.out.println(MisingNumber_268.missingNumber(nums));
    }

}
