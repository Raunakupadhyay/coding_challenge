class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int len=1;
        int max=1;
        if(nums.length==0) return 0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
        
             if(nums[i]==nums[i-1]+1){
                len++;
            }else{
                len=1;
            }
            max=Math.max(max,len);
        }
        return max;
        
    }
}