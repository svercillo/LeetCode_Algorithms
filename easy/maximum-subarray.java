class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length ==1) return nums[0];
        int max = -9999999;
        for (int i =0; i<nums.length; i++){
            int rowMax = -99999999;
            int prev = 0;
            for(int j =i; j<nums.length; j++){
                prev += nums[j];
                if (prev > rowMax) rowMax = prev; 
            }
            if (rowMax > max) max = rowMax; 
        }
        return max;
    }
}
