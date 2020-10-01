class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length ==2){
            return nums[1]>nums[0] ? 1:0;
        }
        int d = recurse(nums, 0, nums.length);    
        return d == -1 ? nums.length-1: d;
    }
    public int recurse(int [] nums, int start, int end){
        int mid = start + (end - start)/2;
        boolean greaterThanL = false;
        boolean greaterThanR = false;
        try{
            if (nums[mid] > nums[mid-1]){
                greaterThanL = true;
            }
        } catch (Exception ex){
            return 0;
        }
        try {
            if (nums[mid] > nums[mid+1]){
                greaterThanR = true; 
            }
        } catch (Exception ex){
            return -1;
        }
        
        if (greaterThanL && greaterThanR){
            return mid;
        } else if (greaterThanL){
            return recurse(nums, mid, end);
        } else {
            return recurse(nums, start, mid);
        }
    }
}
