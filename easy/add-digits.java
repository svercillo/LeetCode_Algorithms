class Solution {
    public int addDigits(int num) {        
        if (num <10)
            return num;
        String str = Integer.toString(num);
        int sum =0;
        for(char c : str.toCharArray()){
            int cc =  Character.getNumericValue(c);
            sum = sum + cc; 
        }
        while (sum>9)
            sum = addDigits(sum);
        return sum;
    }
}
