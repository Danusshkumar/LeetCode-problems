/*

485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Explanation:

First approach : linear approach and easily be understood 

*/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int res = 0, currRes = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1)
                currRes++;
            else
                currRes = 0;
            res = Math.max(currRes,res);
        }

        return res;
    }
}
