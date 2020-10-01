import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

class Solution {
    
    public int [] array;
    public int [] shuf;
    
    public Solution(int[] nums) {
        array = new int[nums.length];
        shuf = new int[nums.length];
        
        for (int i =0; i <nums.length; i++){
            array[i] = nums[i];
        }        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i =0; i<array.length; i++){
            shuf[i] = array[i]; 
        }
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        
        for (int n : array){
            list.add(n);
        }
        
        for (int i=0; i<shuf.length; i++){   
            int r = ThreadLocalRandom.current().nextInt(0, list.size());
            shuf[i] = list.get(r);
            list.remove(r);
        }
        return shuf;      
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
