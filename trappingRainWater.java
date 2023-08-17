/*

42. Trapping Rain Water:

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Explanation : 
  we have to calculate the rmaximum and left maximum of that block
  Note that we have to calculate the rMax and lMax for each and every blocks
  and min(rMax,lMax) is taken and this is the level of water on that block
  Now, block - level of water will be the extra space that can be filled by water
    

*/


class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        //creating and initialising lMax
        int[] lMax = new int[n];
        lMax[0] = arr[0];
        for(int i = 1;i<n;i++)
            lMax[i] = (arr[i] > lMax[i - 1]) ? arr[i] : lMax[i - 1];

        //creating and initialising rMax
        int[] rMax = new int[n];
        rMax[n - 1] = arr[n -1];
        for(int i = n - 2;i>=0;i--)
            rMax[i] = (arr[i] > rMax[i + 1]) ? arr[i] : rMax[i + 1];
        
        int waterVolume = 0;
        for(int i = 0;i<n;i++){
            int level = (lMax[i] < rMax[i]) ? lMax[i] : rMax[i]; //finding the level at the particular block
            waterVolume += level - arr[i];
        }

        return waterVolume;
    }
}
