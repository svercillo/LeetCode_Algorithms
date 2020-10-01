class Solution {
public:
    bool isHappy(int n) {
        int count =0;
        while (n!= 1 ){
            if (count > 9999) return false;
            count ++;
            string s = to_string(n);
            n =0;
            for (int i =0; i<s.length(); i++){
                int t = (int) s.at(i)-48;
                n += t * t;
            }
        }
        
        return true;
    }
};
