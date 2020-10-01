class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        boolean increasing = true;
        boolean reachedPeak = false;
        boolean first = false;
        for (int i=0; i<A.length-1; i++){
            if (A[i] == A[i+1]){
                return false;
            } else if (A[i] < A[i+1]){
                first = true;
                if (!increasing){
                    return false; 
                }
            } else if (A[i] > A[i+1]) {
                if (!first) return false;
                if (increasing){
                    if (!reachedPeak){
                        increasing = false;
                        reachedPeak = true;
                    } else {
                        // means hit peak twice 
                        return false;
                    }
                    increasing = false;
                }
            }
        }
        return reachedPeak && !increasing;
    }
}
