class Solution {
public:
    vector<int> addToArrayForm(vector<int>& A, int K) {
        string k = to_string(K);
        if (k.length() > A.size()){
            string s = "";
            vector<int> v;
            for (int i =0; i< k.length(); i++){
                v.push_back(k[i] - '0');    
            }
            for (int i =0; i<A.size(); i++){
                s += A[i] +'0';
            }
            
            A = v; 
            k = s;
        }
        for (int i =k.length()-1; i>=0; i--){
            int a_ind = A.size()-1 - (k.length() - 1 - i);    
            A[a_ind] += k[i] - '0';
            while (A[a_ind] > 9 && a_ind > 0){
                cout << "SDFDSF" << endl;
                string s = to_string(A[a_ind]);
                A[a_ind-1] += s[0] - '0';
                A[a_ind] = s[1] - '0';
                cout << A[a_ind-1] << endl;
                a_ind -= 1;
            }            
        }
        if (A[0] > 9){
            string s = to_string(A[0]);
            A[0] = s[1] - '0';
            int last = A[A.size()-1];
            A.push_back(-1);
            for (int i = A.size()-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = 1;
        }
    
        return A;
    }
};
