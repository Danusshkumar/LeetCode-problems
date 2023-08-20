/*
169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Explanation : 
The solution is based on Moore's voting algorithm.
Iterate the array and if the current element is equal to majority then increase the frequency of the majority 
and it's not then decrease the frequency of the majority.
If the frequency is zero, then make current element as majority element. 

*/

class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length;
        int majority = arr[0];
        int frequency = 1;

        for(int i = 1;i<n;i++){
            if(arr[i] == majority)
                frequency++;
            else
                frequency--;
            
            if(frequency == 0){
                majority = arr[i];
                frequency++;
            }
        }

        return majority;
    }
}
