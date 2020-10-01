class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> summary = new ArrayList<>();
        if (nums.length ==0) return summary;
        else if (nums.length ==1){
            summary.add(Integer.toString(nums[0]));
            return summary;
        }
        for (int i=0; i<nums.length-1; i++){
            int start = i;
            boolean entered = false;
            while(nums[i+1] == nums[i]+1){ 
                entered = true; 
                i++;
                if (i == nums.length-1) break;
            }
            if (entered){ // not continuous
                summary.add(Integer.toString(nums[start])+ "->" + Integer.toString(nums[i]));
            } else{
                summary.add(Integer.toString(nums[i]));
            }
        }
        String s = summary.get(summary.size()-1);
        boolean count = false; 
        String b = "";
        for( int i =0; i<s.length(); i++){
            if (count){
                System.out.println(s.charAt(i));

                b+= s.charAt(i);
            } else if (s.charAt(i) == '>'){
                count = true;
            } 

        }
        if (b == "" || Integer.parseInt(b) != nums[nums.length-1]){
            summary.add(Integer.toString(nums[nums.length-1]));
        }
        return summary;
    }
}
