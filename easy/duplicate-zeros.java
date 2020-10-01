class Solution {
    public void duplicateZeros(int[] arr) {
        List <Integer> list = new ArrayList<>();
        for (int n: arr){
            if (n==0){
                list.add(0);
            }
            list.add(n);
        }
        for (int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return;
    }
}
