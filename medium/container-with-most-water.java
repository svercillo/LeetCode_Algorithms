class Solution {
    public int maxArea(int[] height) {
        int maxsize = 0;
        int size =0; 
        for (int j=0; j<height.length-1;j++ ){
            for (int i=j+1; i<height.length; i++){
                int min = height[i];
                if (height[j] < height[i])
                    min = height[j];
                size = (i-j)*min;
                if (size>maxsize)
                    maxsize = size;
                
            }
        }   
        return maxsize;
    }
}
