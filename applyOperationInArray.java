/*

2460. Apply Operations to an Array : https://leetcode.com/problems/apply-operations-to-an-array/description/

You are given a 0-indexed array nums of size n consisting of non-negative integers.
You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:

If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0's to the end of the array.

For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
Return the resulting array.

Note that the operations are applied sequentially, not all at once.

Explanation : 

Apply the above said operation in array and move all zeros to end without modifying the sequential position of non-zero elements in the array
Moving zeros to end without changing the order : https://github.com/Danusshkumar/LeetCode-problems/blob/main/moveZerosToEnd.java


*/


class Solution {
    public int[] applyOperations(int[] arr) {

        int n = arr.length;

        //above said operation is done
       for(int i = 0;i<n - 1;i++){
           if(arr[i] == arr[i+1]){
               arr[i] *= 2;
               arr[i+1] = 0;
           }
       }

       //found first zero position
       int j = 0;
       for(j = 0;j<n;j++)
        if(arr[j] == 0)
            break;

        //moving all zeros to the end
        for(int i = j + 1;i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return arr;
    }
}
