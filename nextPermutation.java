/*

31. Next Permutation : https://leetcode.com/problems/next-permutation/description/

next permutation
Solution : https://www.geeksforgeeks.org/next-permutation/
Bing link : https://sl.bing.net/gSJtCwEXfW0
Also refer : problem solving - 2.md

*/


class Solution {

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int left, int right){
        while(left <= right){
            swap(arr,left,right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }

        if(i < 0){
            reverse(arr,0,n - 1);
            return;
        }

        int j = n - 1;
        while(j > 0 && arr[j] <= arr[i])
            j--;
        
        swap(arr,i,j);

        reverse(arr,i+1,n - 1);
    }
}
