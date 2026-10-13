class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]<0){
                nums[i]=nums[i]*-1;
            }
        }
        Arrays.sort(nums);
        long ret=0L;
        int i=0;
        int j=len-1;
        while(i<=j){
            ret+=nums[j]*nums[j];
            j--;
            if(i<=j){
                ret-=nums[i]*nums[i];
                i++;
            }
        }
        return ret;
    }
}
