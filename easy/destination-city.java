class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        Set<String> possible = new HashSet<>();
        String res = "";
        for (List<String> l : paths ){
            for (int i =0; i<l.size(); i++){
                if (i== l.size()-1){
                    possible.add(l.get(i));
                } else {
                    set.add(l.get(i));    
                }                
            }
        }   
        
        for (String s : possible){
            if (!set.contains(s)){
                return s;
            }
        }
        return res;
    }
}
