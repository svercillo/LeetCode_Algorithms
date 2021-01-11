class Solution {
    
    Set<TreeSet<Integer>> set = new HashSet<>();
    List<List<Integer>> list = new ArrayList<>();
    
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        
        this.n = n;
        this.k = k;
        TreeSet<Integer> tset = new TreeSet<>();
        
        List<Integer> l = new ArrayList<>();
        
        for (int i =1; i <=k; i++){
            l.add(i);
            tset.add(i);
        }
        
        
        set.add(tset);

        
        recurse(tset);
    
        return list;
    }
    
    public void recurse(TreeSet<Integer> tset) {
        
        
        System.out.println(tset);
        
        TreeSet<Integer> ts = new TreeSet<>(tset);
        List<Integer> l = new ArrayList<>();
        for (int ele : tset){            
            
            
            if (!tset.contains(ele+1) && ele +1 <= n){
                
                ts.remove(ele); 
                ts.add(ele+1);
                if (!set.contains(ts)){
                    set.add(new TreeSet(ts));
                    recurse(new TreeSet(ts));
                }                
                ts.remove(ele +1);
                ts.add(ele);
            }
            
            if (!ts.contains(ele-1) && ele -1 > 0){
                ts.remove(ele);
                ts.add(ele-1);
                if (!set.contains(ts)){
                    set.add(new TreeSet(ts));
                    recurse(new TreeSet(ts));    
                }
                ts.remove(ele-1);
                ts.add(ele);

            }
            
            l.add(ele);                

        }
        
        list.add(l);
    }
}





    
//     List<List<Integer>> list = new ArrayList<>();
//     Set<String> set = new HashSet<>();
    
    
//     public List<List<Integer>> combine(int n, int k) {
        
//         Set<TreeSet<Integer>> set = new HashSet<>();
        
        
        
        
//         TreeSet<Integer>tset = new TreeSet<>();
//         tset.add(1);
        
//         tset.add(2);
//         tset.add(3);
        
//         TreeSet<Integer>tset2 = new TreeSet<>();
//         tset2.add(1);
//         tset2.add(2);
//         tset2.add(3);
        
//         set.add(tset);
//         set.add(tset2);
        
        
//         System.out.println(set);
        
        
//         return list;
//     }
    
//     public void recurse(List<Integer> list) {
        
//     }
    
    
// //     public String convert(List<Integer> list){
        
// //         Collections.sort(list);
        
// //         String s = "";
// //         for ( i : list){
            
// //             s += Integer.toString(i);
// //             s += "-";
// //         }
// //         return s;
        
// //     }
