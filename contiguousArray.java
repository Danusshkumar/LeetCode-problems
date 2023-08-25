/*

525. Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Explanation:
The problem is to find the longest contiguous subarray with equal number of 0 and 1. 
For this we have to construct a diff array which contains difference between no.of zeros and ones on a subarray from 0th index to current index
Refer ==> https://github.com/Danusshkumar/geeks-for-geeks-problems/blob/main/subarraysWithEqual1sAnd0s.java
We have to tackle a sub problem in this problem.

sub problem : from the array find the
largest distance between two elements
where the value of those two elements are equal.
i.e ==> finding distance between -1 and -1 and also have to find the maximum of them 

_ _ _ -1 _ _ _ -1 _ _ _ -1 _ _ _ -1 _ _ _  Then subarrays will be
        ________ => 1st -1
                  _______
        _________________ ==> 2nd -1
                           ________
                  _________________
        ___________________________ ==> 3rd -1
  
Here the largest distance between -1 is 6 (last subarrray)

Solution for sub problem:
We are building two hashmaps:
One will have diff_values as keys and lowest index of that diff_value as a value
Another will have diff_values as keys and highest possible index of the diff_value as a value
Then find the differnce betweeen them
The one which has higher difference is the longest subarray

This is one of the most interesting problem I ever solved till now (on writing explanation for the solution of this problem )
*/


class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer,Integer> low = new HashMap<>();
        HashMap<Integer,Integer> high = new HashMap<>();

        int n = arr.length;
        int diff[] = new int[n];

        diff[0] = (arr[0] == 0) ? -1 : 1;

        for(int i = 1;i<n;i++){
            diff[i] = diff[i - 1] + ( (arr[i] == 0) ? -1 : 1 );
        }
        //differnce or cumulative sum array constructed

        //now we have to use two maps
        //low
        for(int i = 0;i<n;i++){
            if(low.containsKey(diff[i])){
                //updates its position - low
                int prevPosition = low.get(diff[i]);
                low.put(diff[i],Math.min(prevPosition,i));
            }
            else {
                // create the entry - low
                low.put(diff[i],i);
            }
        }

        //high
        for(int i = 0;i<n;i++){
            if(high.containsKey(diff[i])){
                int prevPosition = high.get(diff[i]);
                high.put(diff[i],Math.max(prevPosition,i));
            }
            else{
                high.put(diff[i],i);
            }
        }

        //now iterate every keys (values of diff) and find its minimum position
        // find its maximum postion and calculate the difference
        //update the difference if current difference is high
      
        int res = 0;

        for(Map.Entry<Integer,Integer> e : low.entrySet()){
            int currentDiff = 0;
            int key = e.getKey();
            int minValue = e.getValue();
            int maxValue = high.get(key);
            currentDiff = maxValue - minValue;

            res = (currentDiff > res) ? currentDiff : res;

        }

        // here we are handling an explicit case where the subarray starts with first element

        for(int i  = 0;i<n;i++)
            if(diff[i] == 0)
                res = ((i + 1) > res) ? (i+1) : res;
        

        return res;

    }
}
