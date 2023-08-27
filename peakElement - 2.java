/*

162. Find Peak Element
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Explanation:
Finding peak element in O(logn) time complexity
Refer : problem solving - 2.md in placement-resource repository

*/


class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if( ( ( mid == 0) || (arr[mid] >= arr[mid-1]) ) && ( ( mid == n-1) || (arr[mid] >= arr[mid+1]) ) )
                return mid;
            else if(mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else 
                low = mid + 1;
        }

        return -1;
    }
}
