class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        for (int n:nums){
            pq.add(n);
        }
        while (k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
