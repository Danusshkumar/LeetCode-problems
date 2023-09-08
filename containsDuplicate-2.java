/*

219. Contains Duplicate II : https://leetcode.com/problems/contains-duplicate-ii/description/
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Explanation:
My approach is a bruteforce approach and is easy to understand and self explanatory

*/


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> al = map.get(nums[i]);
                for(Integer pos : al){ 
                    //previous position
                    if(Math.abs(pos - i) <=k)
                        return true;
                }
                al.add(i);
                map.put(nums[i],al);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(nums[i],al);
            }
        }

        return false;
    }
}


// Second optmised approach :

/*

this approach is based on the fact that : [1,2,3,4,1,6,7,3,1]
if k = 2, then d/b arr[0] and arr[4] is greater than k means, then d/b arr[8] and arr[0] must not be
greater than k, because arr[8] is there after arr[4]. So we can update the 0 with 4 as there is some possiblity
that d/b arr[4] and arr[8] is less than k, right.
Based on this fact, I rewrite the approach

*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int pos = map.get(nums[i]);
                if(Math.abs(pos - i) <=k)
                    return true;
                else
                    map.put(nums[i],i);
            }
            else{
                map.put(nums[i],i);
            }
        }

        return false;
    }
}
