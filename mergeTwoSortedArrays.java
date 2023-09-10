/*


88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Explanation: The function is based on mergeSort

*/


class Solution {

    public static void mergeArray(int[] arr,int left,int mid, int right){
        int[] a = new int[mid - left + 1];
        int[] b = new int[right - mid];

        for(int i = 0;i<a.length;i++){
            a[i] = arr[left + i];
        }

        for(int i = 0;i<b.length;i++){
            b[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0,k = left;

        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                arr[k] = a[i];
                i++;
            }
            else if(a[i] > b[j]){
                arr[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < a.length){
            arr[k] = a[i];
            i++;
            k++;
        }

        while(j < b.length){
            arr[k] = b[j];
            j++;
            k++;
        }
    }

    public static void mergeFunction(int[] arr,int left, int right){
        int mid = left + (right - left)/2;
        if(right > left){
            mergeFunction(arr,left,mid);
            mergeFunction(arr,mid+1,right);
            mergeArray(arr,left,mid,right);
        }
    }

    public void merge(int[] a, int m, int[] b, int n) {
        for(int i = 0;i<n;i++)
            a[m+i] = b[i];
        int l = 0, r = (m+n) - 1;
        mergeFunction(a,l,r);
    }
}
