/*

136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Explanation : 

XOR of same number gives 0 as XOR of same bits gives zero. 
XOR with 0 gives the number itself
XOR operator supports associativity ==> (a^b)^c = a^(b^c)

Keeping this properties of XOR in mind, 
We do XOR operation for all of the arrays. This way all the numbers that appeared twice will got eradicated as number XOR itself gives 0. 
The number that appeared only once will be there stored in the variable result finally.
 

*/

class Solution {
    public int singleNumber(int[] arr) {
        int res = arr[0];
        int n = arr.length;
        for(int i = 1;i<n;i++)
            res ^= arr[i];
        return res;
    }
}
