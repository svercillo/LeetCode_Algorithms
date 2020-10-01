class Solution {
    public Solution(){}
    public boolean parseBoolExpr(String expression) {
 
        ArrayList<Character> string = new ArrayList<>();
        for (int i =0; i<expression.length(); i++){
            string.add(expression.charAt(i));
        }
        
        Stack<Integer> s = new Stack<>();
        List<Integer> prior = new ArrayList<>();
        for (int i=0; i< expression.length(); i++){
            if (expression.charAt(i) == '(')
                s.push(i);
            else if (expression.charAt(i) ==')')
                prior.add(s.pop());
        }
        
        System.out.println(prior);
        for (int n : prior){
            int start = n;
            boolean hasTrue  =false;
            boolean hasFalse = false;
            while(string.get(n) != ')'){
                System.out.println(string.get(n));
                if(string.get(n) == 't') hasTrue = true;
                else if (string.get(n) =='f') hasFalse = true;
                n++;
            }
            boolean truth = false;
            switch(string.get(start-1)){
                case '|':
                    truth = hasTrue ? true : false;
                    break;
                case '!':
                    truth = hasFalse ? true :false;
                    break;
                case '&': 
                    truth = hasFalse ? false : true;
                    break;
            }
            if (truth){
                string.set(start, 't');
            } else {
                string.set(start,'f');
            }
            for (int i =start+1; i<n+1; i++){
                string.set(i, ',');
            }
        }
        System.out.println(string);
        return string.get(1) == 't' ? true: false;   
    }
}
