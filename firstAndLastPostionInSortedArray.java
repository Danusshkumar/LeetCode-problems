/*

34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Explanation:
We are doing the recursive binary search until we find the target element

In first occurrence:
We are checking whether found place is first occurence or not by comparing it with prevElement. If it is not, binarySearch towards left

In last occurrence:
We are checking whether found place is last occurrence or not by comparing it with nextElement. If it is not, binarySearch towards right

*/


class Solution {

    public int[] searchRange(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int[] res = {-1,-1};

        while(low <= high){
            int mid = low + (high - low)/2;
            if(target < arr[mid]){
                high = mid - 1;
            }
            else if(target > arr[mid]){
                low = mid + 1;
            }
            else {
                if(mid == 0 || arr[mid - 1] != target){
                    res[0] = mid;
                    break;
                }
                else
                    high = mid - 1;
            }
        }

        low = 0;
        high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(target < arr[mid]){
                high = mid - 1;
            }
            else if(target > arr[mid]){
                low = mid + 1;
            }
            else {
                if(mid == arr.length - 1 || arr[mid + 1] != target){
                    res[1] = mid;
                    break;
                }
                else
                    low = mid + 1;
            }
        }

        return res;
        
    }
}
