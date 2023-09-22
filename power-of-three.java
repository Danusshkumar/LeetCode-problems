// problem stmt : https://leetcode.com/problems/power-of-three/

class Solution {
    public boolean isPowerOfThree(int n) {

        if(n == 1)
            return true;
            
        long pow = 3;
        while(pow <= n){
            if(pow == n)
                return true;
            pow *= 3;
        }
        
        return false;

    }
}
