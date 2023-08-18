/*

344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Explanation:
Like aray reversal, left and right pointers are fixed in each end and swapping takes place. These pointers move towards each other
and swapping occurs. These traversal happens until these two pointers meet each other. 

By this way, we can reverse an array

*/

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right){

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
