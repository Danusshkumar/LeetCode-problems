/*

338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Explanation:
We have to get the individual number from 0 to n and have to count the number of 1s in it if the number is represented in binary.

We have to get the last bit by num&1 and if the last bit is one then increment the count
Left shift the number by one time to take the next bit into account.
After all bits are checked finally add the count variable to our result array

*/

class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];
        for(int i = 0;i<=n;i++){
            int count = 0;
            int temp = i;
            while(temp > 0){
                int lBit = temp&1;
                if((lBit^1) == 0)
                    count++;
                temp >>= 1;
            }
            res[i] = count;
        }

        return res;
    }
}
