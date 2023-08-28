/*

15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Explanation:
Refer : problem solving - 2.md on placement-resource

*/

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int n = arr.length;
        int target = 0;
        for(int i = 0;i<n - 2;i++){
            int f = arr[i];
            int sum = target - f;
            
            // two pointer approach
            int low = i + 1;
            int high = n - 1;
            while(low < high){
                if(arr[low] + arr[high] == sum){
                    //return the pair of low and high
                    List<Integer> currRes = new ArrayList<Integer>();
                    currRes.add(arr[i]);
                    currRes.add(arr[low]);
                    currRes.add(arr[high]);
                    resSet.add(currRes);
                    high--; // low++ or high-- both are accepted
                }
                else if(arr[low] + arr[high] < sum){
                    low++;
                }
                else {
                    high--;
                }
            }
        }

        for(List<Integer> i : resSet){
            res.add(i);
        }

        return res;

    }
}
