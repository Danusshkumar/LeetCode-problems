/*

1752. Check if Array Is Sorted and Rotated

Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

*/


class Solution {
    public boolean check(int[] arr) {
        // Here we are counting exception that may arise once if the array is rotated and it won't arise if it is not rotated
        // inorder to check the last element, we use (i+1)%n which will
        // give us 0 as the next index

        int exceptionCount = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] > arr[ (i+1)%n ])
                exceptionCount++;
        }

        return (exceptionCount <= 1) ? true : false;
    }
}
