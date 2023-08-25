/*

2149. Rearrange Array Elements by Sign

You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Explanation:
Logic is simple. Create two arrays for storing positive numbers (including 0) and negative numbers respectively.
Add the postive and negative numbers to corresponding arrays without changing the position (traverse array from start to end)
Then add the elements from positive and negative arrays to resultant array alternatingly by their index.
even index ==> positive
odd index ==> negative
Then, return the array

*/


class Solution {
    public int[] rearrangeArray(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.length;
        
        for(int i : arr)
            if(i >= 0)
                pos.add(i);
            else
                neg.add(i);
        
        int posPtr = 0;
        int negPtr = 0;
        
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            if(i%2 == 0){
                res[i] = pos.get(posPtr);
                posPtr++;
            }
            else {
                res[i] = neg.get(negPtr);
                negPtr++;
            }
        }
        return res;
    }
}
