/*

problem stmt : https://leetcode.com/problems/happy-number/

The number will finally comes to 1 or the number will starts to looping which means the number that came before will come again.
In that point of time, the looping starts and will be infinite, in that case, we have to return false. 
We have to check whether the number comes before the current iteration. Thus we are saving the result of every itreation in the list and we
are checking whether the current element is present in that list or not. If present the number is not going to end up with 1 and it'll do looping. Hence return false

*/

class Solution {
    public boolean isHappy(int n) {

        ArrayList<Integer> nums = new ArrayList<>();

        while(true){
            
            if(n == 1)
                return true;

            if(nums.contains(n))
                return false;

            nums.add(n);

            int sum = 0;
            while(n > 0){
                int digit = n%10;
                n /= 10;
                sum += digit*digit;
            }
            n = sum;
        }



    }
}
