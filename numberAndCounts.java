// problem stmt : https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
class Solution {
    public boolean digitCount(String num) {
        
        int[] freq = new int[10];
        for(int i = 0;i<num.length();i++){
            char ch = num.charAt(i);
            int val = ch - '0';
            freq[val]++;
        }

        for(int i = 0;i<num.length();i++){
            char ch = num.charAt(i);
            int val = ch - '0'; // no.of times it should occur
            if(freq[i] != val)
                return false;
        }

        return true;
    }
}
