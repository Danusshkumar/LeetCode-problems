/*

287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Explanation :
Below code is the implementation of Floy'd Tortoise and Hare algorithm. It's used to find the 
duplicated element in an arryay. But the array must have n+1 element and each element must be in the range [1,n].

Note that if there is no duplicate means there is no way to terminate the loop but it's not possible due to pigeon's principle.
Pigeon's principle : n+1 element and each element will be in range of [1,n] then we will get definitely one duplicate

Here, we are traversing the slow and fast pointer until they meet each other and once it meets, then we initialise the slow pointer to start.
We traverse the array by one step in both the pointer and we eventually get the intersection point and this is the place where we find our duplicate.
This is called Floyd's Tortoise and Hare algorithm. 
Floyd's Tortoise and Hare algorithm : https://youtu.be/PvrxZaH_eZ4?si=Q9RIe5zVB1BCqweA

*/


public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];
        
        // Find the intersection point of the two pointers
        do {
            slow = nums[slow]; // Move slow pointer one step
            fast = nums[nums[fast]]; // Move fast pointer two steps
        } while (slow != fast);
        
        // Reset one pointer to the beginning
        slow = nums[0];
        
        // Find the entrance to the cycle
        while (slow != fast) {
            slow = nums[slow]; // Move both pointers one step
            fast = nums[fast];
        }
        
        // Return the duplicate number
        return slow;
    }
}
