class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        for (int i =0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        Set<Integer> set = new HashSet<>();
        int []  res = new int [2];
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                res[0] = nums[i];
            } else {
                set.add(nums[i]);
                sum += nums[i];
                System.out.println(nums [i]);
            }
        }
        res[1] = (int) ((double) nums.length /2 * (1 + nums.length) - sum);
        return res;
    }
}
