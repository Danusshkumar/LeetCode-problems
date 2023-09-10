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
