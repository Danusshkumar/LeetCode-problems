/*

75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors 
in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Explanation:
The main idea of this solution is derived from move all zeros to end.
We can move a specific element to one end by using this technique.
there will be a index-pointer at position zero.
Looping through each element and if 0 found, swap it with index-pointer(j) and increment j.
By this, every time 0 is encountered, 0 will be moved to left and the index-pointer will be incremented for moving next 0 to left end.

By this technique, we move 0 to left end and then we move 1 to the left end. Remaining 2 will be automatically moved to last

*/

class Solution {
    public void sortColors(int[] arr) {
        
        int n = arr.length;
        int j = 0;
        for(int i = 0;i<n;i++)
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        
        for(int i = j;i<n;i++)
            if(arr[i] == 1){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
    }
}
