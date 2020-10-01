class Solution {
    public List<Integer> getRow(int d) {
        List <Integer> r = new ArrayList<>();
        List <Integer> one = new ArrayList<>();
        r.add(1);
        r.add(1);
        if (d == 0){
            one.add(1);
            return one;
        } else if (d==1){
            return r;
        }  
        
        for (int i=1; i<d; i++){
            r = pascals(r);
        }
        return r;
    }
    public List<Integer> pascals(List<Integer> list) {
        List <Integer> r = new ArrayList<>();
        r.add(1);
        for (int i=0; i< list.size()-1; i++){
            r.add(list.get(i) + list.get(i+1));
        }
        r.add(1);
        return r;    
    }
}
