/*

1979. Find Greatest Common Divisor of Array

Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

Explanation:

This method uses the optimised form of euclidean algorithm for finding greatest common divisor.

*/


class Solution {

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b );
    }


    public int findGCD(int[] arr) {

        int n = arr.length;
        //finding minimum and maximum of the array
        int min = arr[0];
        int max = arr[0];
        for(int i = 0;i<n;i++){
            min = (arr[i] < min) ? arr[i] : min;
            max = (arr[i] > max) ? arr[i] : max;
        }

        //finding greatest common divisor
        return gcd(min,max);


    }
}
