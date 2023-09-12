/*

1200. Minimum Absolute Difference : https://leetcode.com/problems/minimum-absolute-difference/description/

Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr

Explanation : sorting the array will make valuewise closer elements in adjacent. By comparing adjacents, we will get the minimum difference.
Now we are getting every pairs in which the difference is equal to minimum difference

*/


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int min =  Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 0;i<n - 1;i++)
            min = Math.min(min,Math.abs(arr[i] - arr[i + 1]));

        for(int i = 0;i<n - 1;i++){
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if(min == diff){
                List<Integer> ls = new ArrayList<Integer>();
                ls.add(arr[i]);
                ls.add(arr[i + 1]);
                res.add(ls);
            }
        }
        return res;
    }
}
