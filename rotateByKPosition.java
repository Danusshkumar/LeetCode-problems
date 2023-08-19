/*

189. Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Explanation :

We first have to reverse last k elements, then we have to reverse remaining element ( first n - k elements)
Then we have to reverse the entire array.
By this technique, we are able to rotate the array by k positions.
Also note that, if k is greater than n, then k will be k%n as 6 rotation in 5 elements is equal to 1 rotation in 5 elements.

Note : Array out of bound exception occurs if we apply this logic for the array with the length 1/

*/

class Solution {

    public void reverse(int[] nums,int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(n != 1){
        reverse(nums,n - k, n - 1);
        reverse(nums,0, n - k - 1);
        reverse(nums,0,n-1);
        }
        
    }
}
