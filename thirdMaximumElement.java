/*

414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Explanation:
All logics are easy to understand except for the iniitialisation of firstMax, secondMax and thirdMax.
The problem is in the condition where if thirdMax not found, return the firstMax (maximum value)

If
we set thirdMax as Integer.MIN_VALUE and after processing, we compare the thirdMax with Integer.MIN_VALUE and if they are equal then return firstMax;
then it'll be wrong as there may be an array really with the value of Integer.MIN_VALUE, that's why we are using Long.MIN_VALUE and typecast into (int) while returning

*/

class Solution {
    public int thirdMax(int[] arr) {
        
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int i : arr){
            if(i > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            }
            else if(i < firstMax && i > secondMax){
                thirdMax = secondMax;
                secondMax = i;
            }
            else if(i < secondMax && i > thirdMax){
                thirdMax = i;
            }
        }
        
        if(thirdMax == Long.MIN_VALUE)
            return (int) firstMax;
        else
            return (int) thirdMax;
    }
}
