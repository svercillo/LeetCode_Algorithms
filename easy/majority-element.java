class Solution {
    public int majorityElement(int[] nums) {
        for (int c : nums)    {
            int count = 0;
            for (int k : nums){
                if (k ==c)
                    count++;
            }    
            if (count > nums.length/2)
                return c;
        }
        return -1; 
    }
}
