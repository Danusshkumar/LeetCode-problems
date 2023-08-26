/*
153. Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Explanation:

We are going to use binary search approach for this problem.
Calculate the mid element of the array or subarray.
And compare the mid element with the high element. If mid element is smaller than high element, it's increasing meaning that there is no rotation start found there.
The minimum element will always be the starting point of the rotation. 
So move to first half. If the midElement < highElement condition not satisfied, then move to right side as there will be rotationStart found there.

Continue this process until you find the rotationStart (minimumElement) and return the lowElement
*/

class Solution {

    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[high])
                high = mid;
            else
                low = mid + 1;
        }
        return arr[low];
    }
}
