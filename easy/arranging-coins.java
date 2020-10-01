class Solution {
    public int arrangeCoins(int val) {
  // n(n+1)/2 =val
    //   n^2 + n - 2* val =0 ;
    // -1 +- sqrt( 1^2 + 8)
    //     /2
        return (int) Math.floor(new Double(-1 + Math.sqrt(1+8 * (long) val)) /2);
    }
}
