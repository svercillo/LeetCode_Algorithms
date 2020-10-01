class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i =0; i<(1<<nums.length); i++ ){
            List<Integer> list = new ArrayList<>();
            boolean invalid = false;
            for (int  j=0; j<nums.length; j++){
                if((i& (1<<j)) > 0){
                    if (list.size() >0){
                        if (nums[j] >= list.get(list.size()-1)){
                            list.add(nums[j]);
                        } else {
                            invalid = true;
                            break;
                        }
                    } else {
                        list.add(nums[j]);
                    }
                    
                }
            }
            if (invalid) continue;
            if (list.size() >1)
                set.add(list);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : set )
            list.add(l);
        return list;
    }
}
