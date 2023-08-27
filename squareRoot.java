/*

69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Explanation:
Refer : https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/video/MTU4OA%3D%3D

Overview:
We are using binary search and checking every mid element's square is equal to x or not if it is so, then x is a perfect square and return the element
If it is mid square is greater then move into left half
If is smaller than save that and move into right half for higher values

Here we are saving the value because, it may be the floor of that square root if perfect square is not found

*/


class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = 0;

        if(x == 0 || x == 1) //handling corner cases
            return x;

        while(low <= high){
            int mid = low + (high - low)/2;
            //int mdSq = mid * mid; ==> to avoid Integer overflow
            if(mid == x / mid) // mid * mid == x ==>  mdSq == x
                return mid;
            else if(mid < x / mid){ // mdSq < x
                res = mid;
                low = mid + 1;
            }
            else if(mid > x / mid){ // mdSq > x
                high = mid - 1;
            }
        }
        return res;
    }
}
