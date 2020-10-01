class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
        for (int i =0; i<A.length; i++ ){
            for (int j=0; j<A[i].length(); j++){
                if (map.get(A[i].charAt(j)) == null){
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(i, 1);
                    map.put(A[i].charAt(j), m);
                } else if (map.get(A[i].charAt(j)).get(i) == null){
                    map.get(A[i].charAt(j)).put(i, 1);
                } else {
                    map.get(A[i].charAt(j)).put(i, map.get(A[i].charAt(j)).get(i) +1);
                }
            }
        }
        List<String> list = new ArrayList<String>();
        for (char c : map.keySet()){
            if (map.get(c).size() == A.length){
                int min = 999;
                for (int n: map.get(c).keySet()){
                    if (map.get(c).get(n) < min) min =map.get(c).get(n);
                }
                for (int i=0; i<min; i++){
                    list.add(Character.toString(c)); 
                }
            }
        }
        System.out.println(map);
        return list; 
    }
}
