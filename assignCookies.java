/*

455. Assign Cookies : https://leetcode.com/problems/assign-cookies/description/
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; 
and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. 
Your goal is to maximize the number of your content children and output the maximum number.

Explanation : 
We have to satisfy the children with less no of greed factor first. And we try to make them satisfied with \
less size cookies and if they are not satisified with it, then go to next big piece (children with less greed factor not satisfied with 
less size biscuit, then this biscuit can't be given to anyone and it's okkey to skip). That's why we are sorting both the 
arrays and comparing each children with biscuits and if the condition satisfied, increment children and without considering 
whether the child is satisfied or not satisfied, increment the cookies.
Now return the no.of child satisfied.
i ==> children pointer
j ==> cookie pointer

*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        /* 
        We have to satisfy the children with less no of greed factor
        first and that's why we sort both the arrays
        i will be children's pointer and j will be biscuit's pointer
        */
        int i = 0;
        for(int j = 0;i<g.length && j<s.length;j++)
            if(g[i] <= s[j])
                i++;

        return i;
    }
}
