class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            //change one number at a time
            int temp = nums[i];
            nums[i] = nums[i+1];
            boolean possible = true;
            for (int j=0; j<nums.length-1; j++){
                if (nums[j] > nums[j+1]){
                    
                    possible = false;
                }
            }

            if ( possible) return true;
            
            nums[i] = temp;
        }
        if (nums.length ==1) return true;

        boolean possible = true;
        nums[nums.length-1] = nums[nums.length-2];
        for (int j=0; j<nums.length-1; j++){
            if (nums[j] > nums[j+1]){

                possible = false;
            }
        }
        if (possible) return true;
        return false;
    }
}
