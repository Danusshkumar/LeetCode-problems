/*

35. Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Explanation:

This problem is as like as this problem : find the element x in the sorted array, if not found find k where k is the floor of x (the largest element in array that is smaller than x)
In this, we have to find the location where the element x may be inserted. This is the place that is next to k where k is the floor of x. so we return the (index of k + 1).

we can return if the element is found, that's why if(target == arr[mid]) return mid;
If not found, we have to keep track of mid value which is just less than x. 
In the else condition, the program will flow into else condition only if arr[mid] < target. By this we are tracking the element that are less than x and
finally we will get the position where the element that is immediately less than x. that is k. 
But we have to return the insertion position, right. That's why we return the position next to k (res + 1).

*/



class Solution {
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(target == arr[mid])
                return mid;
            else if(target < arr[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
                res = mid;
            }
        }

        if(res < n)
            return res + 1;
        else 
            return res;
    }
}
