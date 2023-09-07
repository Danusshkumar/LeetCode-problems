/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Explantion : 
Read the explanation here: https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/

Second approach with handling edge cases (when the value becomes zero)
explanation for this : self-explanatory with comments

*/

//mySolution 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int n = nums.length;

        //product calculation
        for(int num : nums)
            if(num != 0)
            prod *= num;

        //result array
        int[] res = new int[n];

        //result generation except for 0
        for(int i = 0;i<n;i++)
            if(nums[i] != 0)
                res[i] = prod/nums[i];

        //counting number of zer
        int countZero = 0;
        for(int num : nums)
            if(num == 0)
                countZero++;
        
        //calculating 1st zero position
        int zeroPos = -1;
        for(int i = 0;i<n;i++)
            if(nums[i] == 0){
                zeroPos = i;
            }

        // if no.of zero is greater than 0, then we can fill
        // the result array with 0
        if(countZero > 1)
            Arrays.fill(res,0);
        else if(countZero == 1){
            // if there is only one zero, then all the element
            // except the zero position will be filled with zero.
            // The zero occured position will be assigned with product
            // Note that product here is product without 0
            Arrays.fill(res,0);
            res[zeroPos] = prod;
        }
        // else if there is no zero, we can return the result as it is.

        return res;
    }
}

//Optimised solution without extra space and divided by 0 problem
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
