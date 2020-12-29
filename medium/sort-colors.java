class Solution {
    public void sortColors(int[] nums) {
        int ones =0; 
        int twos =0; 
        
        for(int ele : nums){
            if (ele ==1){
                ones ++;
            } else if (ele ==2){
                twos ++;
            }
        }
        
        for (int i = nums.length-1; i>=0; i--){
            if (twos > 0){
                nums[i] =2;
                twos --;
            } else if (ones >0){
                nums[i]=1;
                ones--;
            } else {
                nums[i] =0;
            }
        }
    }
}
