class Solution {
    public int searchInsert(int[] nums, int target) {
        
        for (int i =0; i<nums.length-1; i++){
            if (nums[i] == target){
                return i;
            }
            if (nums[i] < target && nums[i+1] > target)
                return i+1;
        }
        if (nums[nums.length-1] == target)
            return nums.length-1;
        
        
        if (target < nums[0]){
            return 0;
        }
//         if target is greater than all elements 
        if (target > nums[nums.length-1]){
            return nums.length; 
        }
        return -999;
    }
}
