class Solution {
    public long subArrayRanges(int[] nums) {
        int len=nums.length;
        long ret=0;
        for(int i=0;i<len;i++){
            long min=Long.MAX_VALUE;
            long max=Long.MIN_VALUE;
            for(int j=i;j<len;j++){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                ret+=(max-min);
            }
        }
        return ret;
    }
}
