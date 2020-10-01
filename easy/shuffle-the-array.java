class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i =n; i < n*2-1; i++){
            for (int j=i; j> i-n +i-n+1; j--){                
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
