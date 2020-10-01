class Solution {
    public int[] dailyTemperatures(int[] T) {
        int [] arr = new int[T.length];
        arr[T.length-1] = 0;
        for (int i=0; i<T.length-1; i++){
            for (int j =i+1; j<T.length; j++){
                if (T[j] > T[i]){
                    arr[i] = j-i;
                    break;
                }
            }    
        }
        return arr;
        
    }
}
