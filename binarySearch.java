/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Explanation:
refer: problem solving - 2.md file in placement-resourse repository
*/

class Solution {
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                high = mid - 1;
            else if(target > arr[mid])
                low = mid + 1;
        }
        return -1;
    }
}
