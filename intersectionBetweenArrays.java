/*

349. Intersection of Two Arrays
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Explanation:
create two sets and add all the integer values to that set. use .retainAll() method to have a intersection between set_1 and set_2.
copy all of the element (Integer) to the res(result) array using intValue() method. Note that intVallue() method will convert the Integer into int (primitive 
type).Also note that for-each loop is used there

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set_1 = new HashSet<>();
        for(int i : nums1)
            set_1.add(i);

        Set<Integer> set_2 = new HashSet<>();
        for(int i : nums2)
            set_2.add(i);

        set_1.retainAll(set_2);
        int[] res = new int[set_1.size()];

        int i = 0;
        for(Integer integer : set_1){
            res[i] = integer.intValue();
            i++;
        }
        return res;

    }
}


//optimised solution using merge sort

class Solution {
    public int[] intersection(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int m = a.length;
        int n = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i =0, j = 0;

        while(i < m && j < n){

            if(i > 0 && a[i] == a[i - 1]){
                i++;
                continue;
            }

            if(j > 0 && b[j] == b[j - 1]){
                j++;
                continue;
            }

            if(a[i] < b[j]){
                i++;
            }
            else if(a[i] > b[j]){
                j++;
            }
            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        int[] returnRes = new int[res.size()];
        int k = 0;
        for(Integer num : res){
            returnRes[k] = num.intValue();
            k++;
        }

        return returnRes;
    }
}
