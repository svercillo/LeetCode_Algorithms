// class struct{

//     public Set<String> set = new HashSet<>();

//     public Map<Character, Integer> map = new HashMap<>();

// }

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

       

        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        Map<Character, Integer> singleChars = new HashMap<>();
        
        int emptyCount =0;

        for (String string :strs){
            if (string.length() ==1){

                singleChars.computeIfPresent(string.charAt(0), 
                                             (key, val) -> singleChars.get(string.charAt(0))+1);

                singleChars.computeIfAbsent(string.charAt(0),
                                            k->1); 
                continue;
            } else if (string.equals("")){
                emptyCount++;
                continue;
                
            } 
            Map<Character, Integer> m = new HashMap<>();

            for (int i =0; i<string.length(); i++){

                char c = string.charAt(i);

                m.computeIfPresent(c,

                                  (key, val) -> m.get(c)+1);

                m.computeIfAbsent(c,

                                  k->1);

            }

           

            if (map.get(m) == null){

                List<String> set = new ArrayList<>();
                set.add(string);

                map.put(m, set);

            } else {
                map.get(m).add(string);
            }

        }

        for (Map<Character, Integer> m : map.keySet()){

            result.add(map.get(m));
            // List<String> list = new ArrayList<>();
//             boolean hasN = false;
//             for (String s : map.get(m)){
//                 if (s.equals("")){
//                     hasN = true;
//                 }
//                 list.add(s);

//             }
//             if (!hasN)
//                 result.add(list);
        }
        
        for(char c: singleChars.keySet()){
            List<String> list = new ArrayList<>();
            int len = singleChars.get(c);
            for(int i =0; i<len; i++){
                list.add(Character.toString(c));
            }
            result.add(list);
        }
        if (emptyCount > 0){
            List<String> list = new ArrayList<>();
            System.out.println("SDFSDFSDFD");
            System.out.println(emptyCount);
            for (int i=0; i<emptyCount; i++){
                System.out.println("SDFSDFSDFD");
                list.add("");
            }
            result.add(list);
        }
        return result;
    }
}
