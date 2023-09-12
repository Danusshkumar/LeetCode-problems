/*

912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Explanation : MergeSort implementation 

*/


class Solution {

    public static void merge(int[] arr,int l, int h){
        int m = l + (h - l)/2;
        int n1 = m - l + 1, n2 = h - m;
        int[] a = new int[n1];
        int[] b = new int[n2];

        for(int i = 0;i<n1;i++)
            a[i] = arr[i + l];
        
        for(int i = 0;i<n2;i++)
            b[i] = arr[i + m + 1];

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(a[i] <= b[j]){
                arr[k] = a[i];
                i++;
            }
            else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = a[i];
            i++;
            k++;
        }
            
        while(j < n2){
            arr[k] = b[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int h){
        int m = l + (h - l)/2;
        if(l < h){
            mergeSort(arr,l,m);
            mergeSort(arr,m + 1, h);
            merge(arr,l,h);
        }
    }

    public int[] sortArray(int[] nums) {
        //merge sort
        mergeSort(nums,0,nums.length - 1);
        return nums;
    }
}
