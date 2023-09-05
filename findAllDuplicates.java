/*
442. Find All Duplicates in an Array

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.

Explanation:
aiob ==> arrayIndexOutOfBound
The logic is based on the simple reasoning.
We are looking for the element that the current element is pointing out by arr[arr[i]] that means and changing the same into negative.
If again we encounter the same negative element means we again encountered the arr[i] as we encountered before. That's why we are again getting pointed to negative element.
Thus the arr[i] is duplicated and add the same into result array. 

We are getting the absolute of current value as it may be marked as negative in any other previous elements. 
We are repeating this process until we reach the end of the array. 

Let me add my bing chat conversation content here for better understanding :

Bing:
We are adding num to the result array instead of nums[index] because num is the original value of the element that we have seen before, 
while nums[index] is the negative value of the corresponding element that we have flipped. For example, if we have an element 3, we can 
use it to access nums[2], which is the third element in the array. By flipping the sign of nums[2], we can mark it as visited, and 
indicate that we have seen 3 before. If we encounter another 3 later, we can check if nums[2] is negative, and if so, we can conclude 
that 3 is a duplicate. However, nums[2] is now -3, which is not the original value of the element. Therefore, we add 3 to the result 
array, not -3. 😊

Me:
this technique is based on the principle that means two or more element pointing to same element ? If that element is negative means it's
visited then we mark current element as duplicate, right ?

Bing:
Yes, you are right. This technique is based on the principle that two or more elements pointing to the same element indicate a duplicate.
If that element is negative, it means it has been visited before, and we mark the current element as a duplicate. 😊

*/

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<arr.length;i++){
            int num = Math.abs(arr[i]);
            int index = num - 1; //because number starts with 1 [1,n] but index starts with 0 [0,n-1]
            if(arr[index] < 0)
                res.add(num);
            else 
                arr[index] = -arr[index];
                
        }

        return res;
    }
}
