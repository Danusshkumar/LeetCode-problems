/*

53. Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Explanation : 

The solution works on kadane's algorithm. 
curr is the sum of all element till now. If current is greater then maximum then, we will set current as maximum.

This way, we will verify all the subarray starts with first elements and ends with 1 to n elements.
But we didn't check the arrays starts with remaining element. For that, kadane's algorithm follows a step.

If the current is less than zero, there is no meaning that current + next element would be a better maximum sum subarray. Thus the new
subarray starts there by making curr as 0. 
from curr + next element the subarray sum will be calculated and if this sum is greater than max, then this sum will be updated as max.

This is based on a simple concept that,
x + y < y if x is negative. 

*/


class Solution {
    public int maxSubArray(int[] arr) {

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i = 0;i<n;i++){
            curr += arr[i];

            if(curr > max)
                max = curr;

            if(curr < 0)
                curr = 0;
        }

        return max;
    }
}
