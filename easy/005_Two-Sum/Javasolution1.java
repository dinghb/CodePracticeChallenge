public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray=new int[2];
        outerloop:
        for(int i=0;i<nums.length-1;i++)
        {
            for(int k=1;i+k<nums.length;k++)
            if(nums[i]+nums[i+k]==target)
            {
                returnArray[0]=i;
                returnArray[1]=i+k;
                break outerloop;
            }
        }
        return returnArray;
    }
}