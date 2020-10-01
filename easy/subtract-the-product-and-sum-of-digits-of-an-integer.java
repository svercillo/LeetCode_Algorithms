
class Solution {
    public int subtractProductAndSum(int n) {
        String str = Integer.toString(n);
        
        int product = 1;
        int sum =0;
        for (int i=0; i<str.length();i++){
            product *= Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return product - sum;
        
    }
}
