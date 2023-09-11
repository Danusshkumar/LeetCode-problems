/*

2483. Minimum Penalty for a Shop
https://leetcode.com/problems/minimum-penalty-for-a-shop/description/

Explanation : self-explanatory

*/

class Solution {
    public int bestClosingTime(String str) {
        /*
        Interesting problem :
        Let's take customer visit as 0 and 1
        Let's take close and open time as 0 and 1
        0 | 0 ==> no penalty
        0 | 1 ==> penalty
        1 | 0 ==> penalty
        1 | 1 ==> no penalty

         */

        // I am creating the array for what if the store is closed at jth hour
        int n = str.length();
        // we are going to use two variables to get the penalty values

        //left and right
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            //counting Y as there
            right += str.charAt(i) == 'Y' ? 1 : 0;
        }

        int res = -1;
        for(int i = 0;i<=n;i++){
            int curr = left + right;
            if(curr < min){
                min = curr;
                res = i;
            }

            if(i == n)
                break;

            //updating left, right values
            if(str.charAt(i) == 'Y'){
                // no change in left
                right -= 1;
            }
            else if(str.charAt(i) == 'N'){
                left += 1;
                // no change in right
            }
        }

        return res;

    }
}
