//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 22427 👎 301


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {

        // solution
        // approach
        /*
        * Amount of water can be present at a plce
        * can be as follows
        * both ends -0 since no booundary
        * for every position i
        * minimum of local maximum in left and local maximum in
        * right - height of the block
        * */
        int sumTotalWater = 0;
        // make two pointers to traverse array only once
        int left = 0;
        int right = height.length -1;
        //local maximumleft
        int maxLeft = height[left];
        int maxRight = height[right];

        while( left < right){
            if(maxLeft < maxRight){
                left += 1;
                maxLeft = Math.max(maxLeft,height[left]);
                sumTotalWater += (maxLeft - height[left]);
            }else {
                right -= 1;
                maxRight = Math.max(maxRight,height[right]);
                sumTotalWater += (maxRight - height[right]);
            }
        }
        return sumTotalWater;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
