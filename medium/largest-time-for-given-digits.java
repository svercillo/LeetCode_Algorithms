import static java.lang.System.out;
class Solution {
    
    public List<List<Integer>> list = new ArrayList<>();
    public String largestTimeFromDigits(int[] arr) {
        
        permute(arr);
        
        
        
        Pair m = new Pair(-1, -1);
        
        for(List<Integer> l : list){
        System.out.println((l));    
            Pair p = valid(l);
            if ((int)p.getKey() > (int)m.getKey()){
                m = p; 
            } else if((int)p.getKey() == (int)m.getKey() && (int)p.getValue() > (int)m.getValue()){
                m =p;
            }
        }
        
        
        if ((int)m.getKey() ==-1){
            return "";    
        }
        String s = "";
        if ((int)m.getKey() < 10){
            s += "0";
        }
        s += Integer.toString((int)m.getKey());
        s += ":";
        
        if ((int)m.getValue() <10){
            s += "0"; 
        }
        s += Integer.toString((int)m.getValue());
        
        return s;
        
    }
    
    public Pair valid(List<Integer> l){
        String s1 = "";
        s1 +=  (char)('0' + l.get(0));
        s1 +=  (char)('0' + l.get(1));
        
        String s2 = "";
        s2 += (char)('0' + l.get(2));
        s2 += (char)('0' + l.get(3));
        
        if (Integer.parseInt(s1) < 24 && Integer.parseInt(s2) < 60){
            return new Pair(Integer.parseInt(s1), Integer.parseInt(s2));
            
        } else {
            return new Pair(-2,-2);
        }
    }
    
    public int s = 0;
    
    public void permute(int[] nums) {
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

    }
    
    public void permutation(List<Integer> prev, List<Integer> remaining){
        if (prev.size() == this.s) return;
        // System.out.println(prev);
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
