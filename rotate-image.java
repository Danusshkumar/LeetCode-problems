// problem stmt : https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        //transpose the matrix
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse the cols
        int low = 0, high = n - 1;
        while(low < high){

            for(int i = 0;i<n;i++){
                int temp = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = temp;
            }

            low++;
            high--;
        }
    }
}
