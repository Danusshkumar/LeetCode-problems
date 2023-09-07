/*

11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Explanation:
The solution works on the fact that we must see the buildings and we have to change the building with minimum height, if both have 
same heights the move the both as moving anyone definitely not going to contribute to our maxVolume (volume)

*/

class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0,j = n - 1;
        int volume = 0;
        int currVolume = 0;

        while(i < j){
            int h = Math.min(arr[i],arr[j]);
            currVolume = h * (j - i);
            volume = Math.max(volume,currVolume);
            if(arr[i] < arr[j])
                i++;
            else if(arr[j] < arr[i])
                j--;
            else {
                i++;
                j--;
            }
        }
        return volume;
    }
}
