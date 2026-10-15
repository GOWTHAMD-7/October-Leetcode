class Solution {
    public int sumCounts(List<Integer> nums) {
        int len=nums.size();
        int ret=0;
        for(int i=0;i<len;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<len;j++){
                set.add(nums.get(j));
                int ll=set.size();
                ret+=ll*ll;
            }
        }
        return ret;
    }
}
