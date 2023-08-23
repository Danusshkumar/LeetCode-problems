/*

724. Find Pivot Index

Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Explanation:

We have to keep track of left side sum and right side sum without using any extra space.
First we get the sum of array stored in right side array.
left_side sum is 0 initially.

decrement the right side value with current element
Check the condition
increment the left side value with current element 

By this way, we can keep track of element's left side and right side sum


*/

class Solution {
    public int pivotIndex(int[] arr) {

        int n = arr.length;
        int right = 0;
        int left = 0;
        for(int i = 0;i<n;i++)
            right += arr[i];

        for(int i = 0;i<n;i++){
            
            right -= arr[i];
            
            if(left == right)
                return i;
                
            left += arr[i];

        }
        return -1;
    }
}
