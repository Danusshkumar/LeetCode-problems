/*


4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Explanation:

First solution is easy to understand but it's Space complexity is O(n+m) and time complexity if O(NlogN) where N is the sum of length of first and second array

Second solution ( TC : O(log(min(n,m))) ):
Explanation : refer problem solving - 2.md

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n + m];
        for(int i = 0;i<n;i++){
            res[i] = nums1[i];
        }
        for(int i = 0;i<m;i++){
            res[n + i] = nums2[i];
        }

        Arrays.sort(res);
        double median = 0;
        if(res.length%2 == 0){
            int mid = (n+m)/2;
            int prevMid = mid - 1;
            median = (double)(res[mid] + res[prevMid])/2;
        }
        else {
            int mid = (n+m)/2;
            median = res[mid];
        }
        return median;
    }
}


// Approach 2 ( efficient approach )

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2){
          return findMedianSortedArrays(nums2,nums1);
        }
        int begin = 0, end = n1;



        
        while(begin <= end){
            int i1 = begin + (end - begin)/2;
            int i2 = (n1 + n2 + 1)/2 - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

            //main logic goes here
            if(max1 <= min2 && min1 >= max2){
                // done
                if( (n1+n2)%2 == 0 ){
                    //even number of elements
                    return (double) (Math.min(min1,min2) + Math.max(max1,max2))/2;
                }
                else {
                    // odd number of elements
                    return (double) Math.max(max1,max2);
                }

            }
            else if(max1 > min2){
                // move to right side
                end = i1 - 1;
            }
            else {
                //move to left side
                begin = i1 + 1;
            }
        }

        return -1;
    }
}
