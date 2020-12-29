class Solution {
    
    int [] nums;
    int [] used; 
    boolean arrived = false;
    public boolean canJump(int[] nums) {
        this.nums = nums;
        used = new int [nums.length];
        if(nums.length ==1) return true;
        
        for (int i =1; i<nums [0]+1; i++){
            if (i >nums.length)
                break; 
            recurse(i);
        }
        
        return arrived;
    }
    
    public void recurse(int ind){
        if (arrived) return;
        if (ind == nums.length -1){
            arrived = true;
        }  

        for (int i =1; i<=nums[ind]; i++){
            if (ind +i < nums.length && used[ind +i] ==0){
                used[ind+i] =1;
                recurse(ind + i);
            }
        }

    }
}



