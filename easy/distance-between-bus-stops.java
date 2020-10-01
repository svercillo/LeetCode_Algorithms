class Solution {
    public int distanceBetweenBusStops(int[] distance, int s, int d) {
        int min = 0;
        if (s > d){
            int t = s;
            s =d;
            d =t;
        } 
        int i =s;
        for (; i<d; i++){
            min += distance[i];
        }
        int temp =0;
        // i == d
        while (i != s){
            temp +=distance[i];            
            if (i == distance.length-1){
                i =0;
            } else {
                i++;    
            }
        }
        return temp < min? temp : min;
    }
}
