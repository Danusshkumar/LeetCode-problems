/*
LeetCode problem : 1
Problem statement : Two sum
Explanation: 
The solution is based on the two pointers approach.
Inorder to make some logic, we have to sort the array. Sorting the array with Arrays.sort() function in java would take O(n * logn) time complexity.

Now set the pointers on left and right side of the sorted array.
If the current values' sum is equal to target then return 
else if current values' sum is less than target then
  we have to increase the sum value, so we increment the left pointer
else if current values' sum is greater than target then
  we have to decrease the sum value, so we decrement the right pointer

We have to understand the logic behind this approach:
Let's say arr[i] + arr[j] > target, 
arr[i] is the smallest element when compared to other elements in the right. So arr[j] doesn't even pair with these smaller element,
so it can't pair with any other element right to it. So we can safely ignore the arr[j] and decrement the j pointer as j--
Similarly if
arr[i] + arr[j] < target,
arr[j] is the bigger element so far and arr[i] can't able make pair means, it definitely won't make pair with arr[j-1] or arr[j-2], so that 
we can safely ignore arr[i] and can increment i pointer as i++
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sortedArray = nums;
        Arrays.sort(sortedArray);
        int left = 0, right = nums.length - 1;
        int[] result = new int[2];
        int firstIndex = -1;
        int secondIndex = -1;
        while(left < right){
            firstIndex = -1;
            secondIndex = -1;
            int sum = nums[left] + nums[right];
            if(sum == target){
                for(int i = 0;i<nums.length - 1;i++){
                    if(nums[left] == nums[i] && firstIndex == -1)
                        firstIndex = i;
                    else if(nums[right] == nums[i])
                        secondIndex = i;
                }
            }
            else if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
        }
        return new int[] {firstIndex,secondIndex};
    }
}
