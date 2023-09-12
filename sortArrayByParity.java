/*

905. Sort Array By Parity : https://leetcode.com/problems/sort-array-by-parity/description/

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Explanation : Sorted using Lomuto partition

*/

class Solution {

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] sortArrayByParity(int[] arr) {
        //use Lomuto's partition
        int l = 0,h = arr.length - 1;
        int i = l - 1;
        //taking last element as pivot
        for(int j = 0;j<h;j++){
            if(arr[j]%2 == 0){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return arr;
    }
}
