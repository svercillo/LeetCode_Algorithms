class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for (char c : s.toCharArray()){
            if (map.get(c) == null){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) +1);
            }
        }
        for( char c : t.toCharArray()){
            if (map2.get(c) == null){
                map2.put(c, 1);
            } else {
                map2.put(c, map2.get(c) +1);
            }
        }
        for (char c : t.toCharArray()){
            if (map.get(c) != map2.get(c)) return c;
        }
        
        return '-';
    }
}
