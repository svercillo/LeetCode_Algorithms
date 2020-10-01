class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List <List<Integer>> res = new ArrayList<>();
        int length = 1;
        int start =-1;
        int end = -1;
        for (int i=1; i<S.length(); i++){
            if (S.charAt(i) == S.charAt(i-1)){
                length++;
                if (start == -1){
                    start = i-1;
                }
            } else{
                if (length >=3){
                    end = start + length-1;
                    List<Integer> r = new ArrayList<>();
                    r.add(start);
                    r.add(end);
                    res.add(r);
                }   
                start =-1;
                length = 1;
            }
        }
        if (length >=3 && start != -1){
            end = start + length-1;
            List<Integer> r = new ArrayList<>();
            r.add(start);
            r.add(end);
            res.add(r);
        } 
        return res;
    }
}
