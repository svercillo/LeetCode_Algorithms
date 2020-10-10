struct myclass {
    bool operator() (int i,int j) { return (i<j);}
} myobject;
class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort (arr.begin(), arr.end(), myobject);
        vector<vector<int>> vv;
        
        int min_diff = 99999;
        for (int i =0; i< arr.size()-1; i++){
            if (arr[i+1] - arr[i] < min_diff){
                min_diff = arr[i+1] - arr[i];
                vv.clear();
                vector<int> v;
                v.push_back(arr[i]);
                v.push_back(arr[i+1]);
                vv.push_back(v);
            } else if (arr[i+1] - arr[i] == min_diff){
                vector<int> v;
                v.push_back(arr[i]);
                v.push_back(arr[i+1]);
                
                vv.push_back(v);
            }
        }
        return vv;
        
    }
};
