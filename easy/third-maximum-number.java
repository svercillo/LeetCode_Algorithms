class Solution {
    public int thirdMax(int[] nums) {
        TreeMap<Integer, Boolean> map = new TreeMap<>(Collections.reverseOrder());
        for (int i =0; i<nums.length; i++)
            map.put(nums[i], true);
        if (map.size() < 3){
            return map.firstKey();
        } else{
            map.remove(map.firstKey());
            map.remove(map.firstKey());
            return map.firstKey();
        }
    }
}
