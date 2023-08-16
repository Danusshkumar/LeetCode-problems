/*

Problem statement : 41
First Missing Positive:

Explanation:

We have to sort the array, inorder to apply some logics. Using Arrays.sort(), we sort 
the array with O(n * logn) time complexity.

Traversing each element until positive element is reached as we have to find the 
first missing positive.

If positive element is found, we have to set that to minimum.
NOTE: Note that, 0 is not the positive element.
If the positive element starts not at 1, then definitely 1 is missing, return 1;

If the minimum element is set and the element is 1 and no more elements in the
array means, we have to return 2; ==> if(min != Integer.MIN_VALUE)

Otherwise, we have to maintain the minimum element and the next occuring element should
be equal to minimum or next to minimum. If not then the number immediately after minimum
will be announced as first missing positive number


*/

class Solution {
    public int firstMissingPositive(int[] arr) {
        int size = arr.length;
        Arrays.sort(arr);
        int min = Integer.MIN_VALUE;
        Boolean posReached = false;
        for(int i = 0;i<size;i++){
            if(arr[i] >=0)
                posReached = true;
            
            if(posReached && min == Integer.MIN_VALUE){
                min = arr[i];
                if(min == 0)
                    continue;
                else if(min != 1)
                    return 1;
            }
            else if(posReached && min != Integer.MIN_VALUE){
                if(arr[i] == min)
                    continue;
                else if(arr[i] == min + 1)
                    min +=1;
                else if(arr[i] >= min + 2)
                    return min + 1;
            }
        }
        
        if(min != Integer.MIN_VALUE)
            return min+1;
        else
            return 1;
    }
}
