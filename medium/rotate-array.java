class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k ==0) return;
        
        for (int i =0; i<k; i++){
            int prev = nums[nums.length -1];
            for (int j =0; j<nums.length; j++){
                int c = nums[j]; 
                nums[j] = prev; 
                prev = c; 
            }
        }
    }
}
