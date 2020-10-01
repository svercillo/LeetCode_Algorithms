class Solution {
    public int missingNumber(int[] nums) {
        
        if (nums.length ==1) return nums[0] == 0 ? 1 : 0;
        int sum =0; 
        for (int n:nums){
            sum += n;
        }
        int index = nums.length * (nums.length+1)/2;
        
        return index - sum;
    }
}
