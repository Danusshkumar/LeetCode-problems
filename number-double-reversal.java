// problem stmt : https://leetcode.com/problems/a-number-after-a-double-reversal/

class Solution {

    public static int reverse(int num){
        int rev = 0;
        while(num > 0){
            int digit = num%10;
            rev = rev*10 + digit;
            num /= 10;
        }
        return rev;
    }

    public boolean isSameAfterReversals(int num) {

        int numCopy = num;
        int res = reverse(numCopy);
        res = reverse(res);

        if(res == num)
            return true;
        else
            return false;    
    }
}
