class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i=digits.size()-1; i >=0; i--){
            if (i == 0){
                if (digits[0] == 9){
                    int size = digits.size();
                    cout << size  << endl;
                    for (int i =0; i< size; i++){
                        digits[i] =0;
                    }
                    digits.push_back(0);
                    digits[0] = 1;
                } else {
                    digits[0] ++;
                }
                break;
            }
            if (digits[i] == 9){
                digits[i] =0;
            } else {
                digits[i] ++;
                break;
            }
        }
        return digits;
        
    }
};
