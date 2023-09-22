/*

problem stmt : https://leetcode.com/problems/reverse-integer/

*/

class Solution {
    public int reverse(int x) {

        int sign = 1;

        if(x < 0){
            sign = -1;
        }

        int rev = 0;
        int numCopy = Math.abs(x);
        
        while(numCopy > 0){
            int digit = numCopy%10;

            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
                return 0;
            
            rev = rev*10 + digit;
            numCopy /= 10;
        }




        return (rev*sign);
    }
}
