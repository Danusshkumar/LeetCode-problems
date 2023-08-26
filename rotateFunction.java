/*

Explanation : 
The core idea of this solution is to use the value sum.
Let me explain in detail.

First we are calculating the F as if
[a,b,c,d] ==> a*0 + b*1 + c*2 + d*3 and so on.

Now we are adding sum to it so all the elements will be
incremented like this
 ==> a*1 + b*2 * c*3 + d*4 and so on.

 In this, all the elements have their correct format except d*4

 we have to make that d*4 to 0 meaning that we have to subtract
 d*4 from our result.

 Here d*4 is the last element ==> arr[n-1](d) * n(4)
 But we do arr[(n-1)-i] as this won't be last place but'll
 moved to previous last place (one place left) for every iteration.
 That's why -i in that place

*/


class Solution {
    public int maxRotateFunction(int[] arr) {
        int f = 0;
        int sum = 0;
        int n = arr.length;

        for(int i = 0;i<n;i++){
            sum += arr[i];
            f += i * arr[i];
        }

        int max = f;

        for(int i = 0;i<n;i++){
            f += sum - (n * arr[(n-1)-i]);
            max = ( f > max) ? f : max;
        }
        
        return max;
    }
}
