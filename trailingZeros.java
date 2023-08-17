/*

172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Explanation:

We have to calculate the number of tens as the number 10 only contributes to trailing zeros
then we have to calculate the maximum possible 2,5 pairs as it give rise to 10. There is no other factor pairs for 10.
The maximum possible 2,5 pairs will be equal to number of 5's
present within 1 to n as no.of 5s are less than no.of 2s from 1 to n as 5 appear less frequently than 2 as 5 is a larger element when compared to 2.

Note: for 25,125, etc. There will be more than one 5s. We also have to taken them into account. That's why we have inner for loop.
First iteration of inner loop corresponds, to check 5 and second iteration for checking 25 and so on.
On checking 25, we will add only on count as one of the five in the 25 will already be added into account when we check the count on behalf of 5.
*/


class Solution {
    public int trailingZeroes(int n) {
      
        int count = 0;
        for(int i = 1;i<=n;i++){
            for(int k = 5;k<=n;k *= 5){
                if(i%k == 0)
                    count++;
            }
        }

        return count;

    }
}
