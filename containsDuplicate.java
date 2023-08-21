/*

217. Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Explanation:

We are traversing every element in the array and check whether it's found in the set or not. If found, the element is 
duplicated and thus return true (contains duplicate). Until final element, if we doesn't find any duplicates, then return false.
We are using HashSet as searching element on the HashMap takes O(1) time complexity.

*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums ){
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
