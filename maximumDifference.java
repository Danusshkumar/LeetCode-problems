/*

2016. Maximum Difference Between Increasing Elements
Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.

Explanation:
Maximum index problem in far difficult then this problem
See here what maximum index problem is : https://github.com/Danusshkumar/geeks-for-geeks-problems/blob/main/MaximumIndex.java

Now coming to the point, we have to maintain the minimum and maximum of the array inorder to find the maximum difference.
But i < j, meaning that minimum element pointer must less than maxmimum element pointer ( minimum element appear before maximum element)

Here, we will maintain the minimum while iterating through the element and also trying to find the maximum difference if and only if the current element is greater than maximum

*/

class Solution {
    public int maximumDifference(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int diff = -1;
        for(int i = 0;i<n;i++){
            if(arr[i] > min){
                diff = ((arr[i] - min) > diff) ? (arr[i] - min) : diff;
            }
            min = (arr[i] < min) ? arr[i] : min;
        }

        return diff;
    }
}
