class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Stack<Boolean>> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == null){
                Stack<Boolean> stack = new Stack<>();
                stack.push(true);
                map.put(s.charAt(i), stack);
            } else {
                Stack<Boolean> stack = map.get(s.charAt(i));
                try{

                    if (stack.peek() == true){
                        stack.push(true);
                    } else {
                        stack.pop();

                    }
                } catch (Exception x) {
                    stack.push(true);
                }
            }
            if (map.get(t.charAt(i)) == null){
                Stack<Boolean> stack = new Stack<>();
                stack.push(false);
                map.put(t.charAt(i), stack);
            } else {
                Stack<Boolean> stack = map.get(t.charAt(i));
                try{
                    if (stack.peek() == false){
                        stack.push(false);
                    } else {
                        stack.pop();
                    }
                } catch (Exception ex ){
                    stack.push(false);
                }

            }
        }
        for (Character c : map.keySet()){
            if (map.get(c).size() != 0) return false;    
        }
        return true;
        
    }
}
