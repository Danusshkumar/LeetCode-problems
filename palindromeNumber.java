/*

9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

Explanation:
The number is said to be palindrome if the number is reversed and still be equal to previous number. 

We can access the last element of number uby % 10. 
We can remove the last element of number by / 10.

By this, we built the reverse of the number and checks whether the original number and reverse number is equal or not

*/


class Solution {
    public boolean isPalindrome(int x) {
        int xCopy = x;

        int revX = 0;
        while(x > 0){
            revX *= 10;
            int digit = x%10;
            revX += digit;
            x  /= 10;
        }

        if(revX == xCopy)
            return true;
        else 
            return false;
    }
}
