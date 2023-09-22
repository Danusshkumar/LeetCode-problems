// problem stmt : https://leetcode.com/problems/perfect-number/

class Solution {
    public boolean checkPerfectNumber(int num) {

        int sum = 0;

        if(num == 1)
            return false;

        for(int i = 2;i*i<num;i++){
            if(num%i == 0){
                sum += i;
                sum += num/i;
            }
        }

        sum += 1;

        if(sum == num)
            return true;
        else
            return false;
    }
}
