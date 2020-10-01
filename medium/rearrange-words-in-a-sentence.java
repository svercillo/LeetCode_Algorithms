class Obj implements Comparable<Obj>{
    public String str;
    public int ind;
    
    public Obj(String s, int i){
        str = s;
        ind = i;
    }
    
    public int compareTo(Obj b){ 
        if(this.str.length() > b.str.length()) return 1; 
        else if(this.str.length() < b.str.length()) return -1;
        else {
            if (this.ind > b.ind){
                return 1;
            }
            return -1;
        }
    }
}
class Solution {
    public String arrangeWords(String text) {
        PriorityQueue<Obj> pq = new PriorityQueue<>();
        String temp = "";
        int index =0; 
        for (int i =0; i<text.length(); i++){
            if (text.charAt(i) != ' '){
                if (temp=="__" || i ==0){
                    temp = Character.toString(Character.toLowerCase(text.charAt(i)));
                } else {
                    temp += text.charAt(i);
                }
            } else {
                pq.add(new Obj(temp, index));
                temp= "__";
                index ++;
            }
        }
        if (temp!= "__") pq.add(new Obj(temp, index));
        
        String str = "";
        str += pq.poll().str;
        char[] arr = str.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        str = new String(arr);
        while (pq.peek() != null){
            str += " ";
            str += pq.poll().str;
        }
        return str;
    }
}
