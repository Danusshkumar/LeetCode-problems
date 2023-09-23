// problem stmt : https://leetcode.com/problems/duplicate-zeros/

class Solution {

    public static void shift(int[] arr,int start,int end){
        for(int i = end;i>start;i--)
            arr[i] = arr[i-1];
    }

    public void duplicateZeros(int[] arr) {

        int n = arr.length;
        
        for(int i = 0;i<n;i++)
            if(i+1 < n && arr[i] == 0){
                shift(arr,i+1,n-1);
                arr[i+1] = 0;
                i++;
            }

    }
}
