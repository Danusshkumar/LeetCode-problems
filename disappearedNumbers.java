/*

448. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Explanation:
Create an ArrayList for output. add all numbers from nums to arraylist and fill the array with -1. Fill all the numbers
from ArrayList to nums as i - 1 index (i.e 24 on 23rd index) as index will come till n - 1 whereas the array size is n.
Now return the all index+1(i+1) for all current element -1.
This approach doesn't require any extraspace and has a time complexity of O(n)

*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i : nums)
            res.add(i);

        Arrays.fill(nums,-1);
        for(Integer i : res){
            nums[i - 1] = i;
        }

        res.clear();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == -1)
                res.add(i + 1);
        }

        return res;

    }
}
