class Point {
    
    public int dSquared;
    public int x1;
    public int x2;
    
    Point(int y, int z){
        x1 = y;
        x2 = z; 
        dSquared =  powerOf(x1, 2) + powerOf(x2,2); 

    }
    
    public void updateDouble(double d){
        dSquared =  powerOf(x1, 2) + powerOf(x2,2); 
    }
    
    public int powerOf(int x, int i){
        int n =1;
        for (int j=0; j< i; j++){
            n *= x;
        }
        return n;
    }
    

};
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (K == points.length) return points;
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(points.length, new Comparator<Point>() {
            public int compare(Point n1, Point n2) {
                return n1.dSquared - n2.dSquared;
            }
        });
        
        for (int i =0; i< points.length; i++){
            Point p = new Point(points[i][0], points[i][1]);
            pq.add(p);
        }
        
        int [][] result = new int[K][2];
        for (int i=0; i <K; i++){
            Point p = pq.poll();
            int [] arr = new int[2];
            arr[0] = p.x1;
            arr[1] = p.x2;
            result[i] = arr;
        }
        return result;
    }
}
