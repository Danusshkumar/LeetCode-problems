/*

1838. Frequency of the Most Frequent Element
Problem : https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

Explanation: self-explanatory with comments

*/


class Solution {
    public int maxFrequency(int[] nums, int k) {
        /*
        A sliding window approach
         */
        Arrays.sort(nums); //sort the array
        int left = 0, right = 0,res = 0,currRes = 0;
        long sum = 0;
        int n = nums.length;
        while(right < n){
            sum += nums[right]; // increment the right pointer
            while( (sum + k) < nums[right] * (right - left + 1)){
                // if the sum+k value is less than num[right]*windowSize
                // then decrease the window size from left
                // why nums[right] means, we can't decrement the value
                // if we take nums[left]
                sum -= nums[left];
                left++;
            }
            
            currRes = (right - left + 1);
            res = Math.max(res,currRes);
            //calculating maximum window size
            right++;
            //increasing window size
        }
        return res;
    }
}
