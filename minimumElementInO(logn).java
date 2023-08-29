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

Why high = mid instead of high = mid - 1;
Let's take one example
4 5 6 1 2 3 ==> In this scenario, mid is 1 and high is 3. The condition is satisfied but still 1 is the minimum number.
So we also take it to consideration as it is not confirmed that mid element is not a minimum element.
That's why we add mid element to the left part by assigning high = mid.


Why low < high instead of low <= high:
If low <= high then the loop terminates only when they cross each other, this will cause unneccessary errors like ArrayIndexOutOfBoundException. 
So if we make the condition as low < high, after the loop termination, the low and high value will be same. 
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
