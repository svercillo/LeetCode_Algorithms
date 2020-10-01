class Solution {

    public List<List<Integer>> list = new ArrayList<>();
    public int s = 0;
    
    public List<List<Integer>> permute(int[] nums) {
        this.s = nums.length;
        
        List<Integer> nms = new ArrayList<>();
        for (int n: nums){
            nms.add(n);
        }
        for (int i=0; i<nums.length; i++){
            int n = nums[i];
            nms.remove(i);
            List<Integer> l = new ArrayList<>();
            l.add(n);
            this.list.add(l);
            permutation(l, nms);
            nms.add(i,n);
        }
        System.out.println(list);
        return this.list;
        
    }
    
    public void permutation(List<Integer> prev, List<Integer> remaining){
        if (prev.size() == this.s) return;
        
        list.remove(prev);
        
        for (int i =0; i<remaining.size(); i++){
            int val = remaining.get(i);
            prev.add(val);
            remaining.remove(i);
              
            if (prev.size() == this.s){
                list.add(new ArrayList<>(prev));
            } else {
                list.add(prev);
            }
            
            permutation(prev, remaining);
            remaining.add(i, val);
            prev.remove(prev.size()-1);
        }
    }
}
