class Solution {
    int [] array; 
    int sol = -1;
    public int search(int[] nums, int target) {
        if (nums.length == 1){
            return nums[0] == target? 0: -1;
        }
        this.array = nums;

        bs(0, nums.length-1, target);
        return this.sol;
    }
    
    public void bs(int start, int end, int target){
        if (end-start <2){     
            if (this.array[start] == target){
                this.sol = start;
            } else if (this.array[end]==target){
                this.sol = end; 
            }
            return;
        }
        int mid = start + (end -start)/2;
        
        if (this.array[mid] == target){
            this.sol = mid;
            return;
        } else if (this.array[mid] < target){
            bs(mid, end, target);
        } else {
            bs(start, mid, target);
        }
    }
}
