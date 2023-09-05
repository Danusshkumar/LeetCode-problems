/*
2760. Longest Even Odd Subarray With Threshold

You are given a 0-indexed integer array nums and an integer threshold.
Find the length of the longest subarray of nums starting at index l and ending at index r (0 <= l <= r < nums.length) that satisfies the following conditions:

nums[l] % 2 == 0
For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2
For all indices i in the range [l, r], nums[i] <= threshold
Return an integer denoting the length of the longest such subarray.

Note: A subarray is a contiguous non-empty sequence of elements within an array.

Explanation : 

Let me solve this problem with this solution that involves sliding window technique. In this we have to maintain the flag
which is responsible for starting of the longest subarray as we have some constraints for that subarray's first element.
flag = 0 means, the subarray not started and flag = 1 means that the subarrray is started. If the element is valid, then we may set our max as 1 if max is 0.

if subarray started just increment the right side pointer (left side pointer is assigned to starting element on starting the subarray (intialisation of subarray) ).
by satisfying the evenOddAlternative condition and threshold limit condition, we can increment the j value and assign the length of subarray (j - i + 1) (+1 is because that
final - initial always gives no.of.elements - 1).
If the condition is not satisfied, then set the flag as zero meaning that our subarray is closed and if the subarray initialisation condition is again satisfied, then new subarray
will be initialised. Note that j-- is to compensate j++ on the loop end, because if the subarray terminated due to dissatisficaition of evenOddAlternative. It may be the 
first element for another subarray. If we didn't put j--, that arr[j] won't be taken into account.

*/


class Solution {
    public int longestAlternatingSubarray(int[] arr, int th) {
        int max = 0, i = 0,j = 0, flag = 0;
        // i ==> starting, j ==> ending, flag ==> whether
        // the subarray is opened or not
        int n = arr.length;
        while(j < n){
            if(flag == 0){ //subarray closed, we can start a subarray
                if(arr[j]%2 == 0 && arr[j] <= th){
                    i = j; // setting starting and ending point
                    max = ( 1 > max ) ? 1 : max; // for starting of the array
                    flag = 1;
                }
            }
            else if(flag == 1){
                if(arr[j - 1]%2 != arr[j]%2 && arr[j] <= th){
                    //if the prevOne and currOne is even-odd or odd-even && if the currOne is less than threshold, then update max
                    max = ( (j-i+1) > max ) ? (j-i+1) : max;
                }
                else {
                    flag = 0;
                    j--; // j-- because ending element
                    // may be the starting element of another subarray
                }
            }
            j++;
        }
        return max;
    }
}
