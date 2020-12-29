class Solution {
    List<String> list = new ArrayList<>();
    int max_size=0;
    
    public List<String> generateParenthesis(int n) {
        this.max_size = n*2;
        recurse("(", 1);
        
        return list;
    }
    
    public void recurse(String s, int lefts){
        if (s.length() == max_size){
            if (lefts == 0){
                list.add(s);
            }
        } else {
            if (lefts >0){
                recurse(s + "(", lefts +1);    
                recurse(s + ")", lefts -1);
            } else if (lefts ==0){
                recurse(s + "(", lefts +1);
            }
            
            
        }
    }
}
