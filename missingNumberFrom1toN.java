/*

268. Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Explanation:
All the elements in the array will be distinct from 1 to n with one number missing.
Then differenc of (sum of numbers from 1 to n) and the (sum of element in that array) will give us the (missing number)
Simple logic 😊

*/


class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = ( n * (n+1))/2;
        int arraySum = 0;
        for(int i = 0;i<n;i++)
            arraySum += arr[i];
        
        return sum - arraySum;
    }
}
