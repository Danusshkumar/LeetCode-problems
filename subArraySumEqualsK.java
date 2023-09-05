/*

560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Explanation:

The main idea of your code is to use a hash map to store the prefix sums of the array and their frequencies. 
A prefix sum is the sum of all the elements from the beginning of the array up to a certain index. For example,
if the array is [1, 2, 3, 4], then the prefix sums are [1, 3, 6, 10].

The hash map will have the prefix sums as keys and their frequencies as values. For example, if the array is [1, 2, -1, 2],
then the hash map will be {0: 1, 1: 1, 3: 1, 2: 2}, where 0 is the initial prefix sum before adding any element.

The algorithm works as follows:

- Initialize a variable count to store the number of subarrays whose sum equals to k.
- Initialize a variable sum to store the current prefix sum.
- Initialize a hash map prefixSum and put (0, 1) in it. This means that there is one subarray with sum zero before adding any element.
- Loop through each element i in the array:
- Add i to sum to get the new prefix sum.
- Check if there is a key in prefixSum that equals to sum - k. This means that there is a subarray whose sum equals to k 
that ends at the current index. The number of such subarrays is equal to the value of that key in prefixSum.
- Add that value to count.
- Increment the value of sum in prefixSum by one. If sum is not in prefixSum, put (sum, 1) in it.
- Return count.

For example, if the array is [1, 2, -1, 2] and k is 3, then the algorithm will work as follows:

Initialize count = 0, sum = 0, and prefixSum = {0: 1}.
Loop through each element:
For i = 1, update sum = 1 and check if there is a key in prefixSum that equals to sum - k = -2. There is none, so do nothing. Update prefixSum = {0: 1, 1: 1}.
For i = 2, update sum = 3 and check if there is a key in prefixSum that equals to sum - k = 0. There is one, and its value is 1. This means that there is one 
 subarray whose sum equals to k that ends at this index. It is [1, 2]. Add that value to count, so now count = 1. Update prefixSum = {0: 1, 1: 1, 3: 1}.
For i = -1, update sum = 2 and check if there is a key in prefixSum that equals to sum - k = -1. There is none, so do nothing. Update prefixSum = {0: 1, 1: 1, 3: 1, 2: 1}.
For i = 2, update sum = 4 and check if there is a key in prefixSum that equals to sum - k = 1. There is one, and its value is 1. This means that
 there is one subarray whose sum equals to k that ends at this index. It is [2]. Add that value to count, so now count = 2. Update prefixSum = {0: 1, 1: 1, 3: 1, 2: 2}.
Return count = 2.

*/


class Solution {
    public int subarraySum(int[] arr, int k) {

        int count = 0;
        HashMap<Integer,Integer> prefixSum = new HashMap<Integer,Integer>();
        // prefixSum ==> prefixSum,frequencyOfPrefixSum
        
        int sum = 0;
        prefixSum.put(0,1);
        for(int i : arr){
            sum += i;

            if(prefixSum.containsKey(sum-k)){
                // note that while count incremented to 1
                // there will be one k and one sum - k there
                // that'll construct subarray. That's why 
                // 1 added to count and so on. 
                count += prefixSum.get(sum-k);
            }

            prefixSum.put(sum,prefixSum.getOrDefault(sum,0) + 1);

        }

        return count;
    }
}
