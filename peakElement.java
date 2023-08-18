/*
Peak element is a element that is greater than its neighbour.
We have to consider n - 1 th element and 0th element as one of their
neighbour which is utterly smaller (-infinity). In view of that kind of 
element, we only consider the neighbour that is inside the range.
The solution must run in O(log n) time.

There is no problem in linear time complexity, but for
O(log n), we have to use different method.
Note that we have to return the index
*/


class Solution {
    public int findPeakElement(int[] arr) {

        int n = arr.length;

        if(n != 1 && arr[0] > arr[1]) // n!= 0 as array index out of bound occurs when there is only one element is present
            return 0;
        if(n != 1 && arr[n - 1] > arr[n - 2]) // also checking for last element n!=0 for same array index out of bound exception
            return n - 1;

        for(int i = 1;i<n-1;i++)
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) // checking whether the neighbour elements are smaller then current element
                return i;


        if(n == 1) // if there is only one element, arr[-1] and arr[1] will be negative infinity and the element at index 0 will be peak element
            return 0;
        else
            return -1;
    }
}
