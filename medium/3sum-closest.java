class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum =0;
        int closestP =999999;
        int closestN = -999999;
        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];
        for (int k=0; k<nums.length-2; k++){
            for (int j =k+1; j< nums.length-1; j++){
                for (int i=j+1; i<nums.length; i++){
                    sum = nums[k] + nums[j] + nums[i];
                    if (sum == target)
                        return target;
                    if (sum > target){
                        if (sum - target < closestP)
                            closestP = sum - target;
                    } else {
                        if (sum -target > closestN)
                            closestN = sum - target;
                    }
                }
            }
        }
        if (closestP < Math.abs(closestN)){
            return target + closestP;
        } else {
            return target +closestN;
        }
    }
}
