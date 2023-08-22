/*

27. Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed.
Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are 
not important as well as the size of nums. Return k.

Explanation:

As we did in the removeDuplicates, if the value is not equal to the specified value, then we can take it into the account and
we do assign that value to res and increment the result. In this way, we are ignoring and overriding the value 'val'.
Finally return the result which is the number of element in array without taking  val's count into account

*/


class Solution {
    public int removeElement(int[] arr, int val) {
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != val){
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }
}
