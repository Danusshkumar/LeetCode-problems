/*

283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Explanation : 

Find the first zero position (j - pointer) and start traversing from it. If there is any non-zero values, swap it with zero
position and increment the zero position as the next position will definitely zero as it is not a non-zero value (ignored by non-zero value pointer - i pointer)

*/

class Solution {
    public void moveZeroes(int[] arr) {

        int j = 0;
        int n = arr.length;
        // find the first zero position
        for(j = 0;j<n;j++)
            if(arr[j] == 0)
                break;
        
        //if there is an non-zero number after zeros, then swap the
        // non-zero number with zero and increment the zero position 
        // to the next
        for(int i = j+1;i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
                // swap i and j
                // and increment j
            }
            else {
                continue;
            }

        }

    }
}
