/*

26. Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element 
appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present 
in nums initially. The remaining elements of nums are not important as well as the size of nums.

Explanation:

We have to remove duplicates on O(n) time complexity and also have to return how many unique elements there.
There are one way to get these solution. We are counting only the unique element.
Initially take your pointer at 1 or 0. Here it's 1. compare that pointer (res) (take it as res - 1 as we took res from 1)
with the current array. If these two are same means the element is duplicated and just move on. If they are not same means
assign the element (distinct element or first occurence of duplicated element) to arr[res] and increment the res to next point.
Now res - 1 will point to finally updated distinct element. Repeat the same process so that if again any other distinct element found
means this process happens and all the distinct element comes at first k position where k is the number of distinct element.
Now return the res where res is the number of distinct element (as res counted from 1).

*/

class Solution {
    public int removeDuplicates(int[] arr) {
        int res = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[res - 1] != arr[i]){
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }
}
