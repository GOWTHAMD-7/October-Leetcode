class Solution {

    public long ways(int[][] lst,String tar,int pos,int start,long[][] dp){
        int slen=tar.length();
        int len=lst.length;
        int req=slen-pos;
        if(pos==slen){
            return 1;
        }
        if(start==len){
            return 0;
        }
        if(dp[pos][start]!=-1){
            return dp[pos][start];
        }
        req--;
        char c=tar.charAt(pos);
        long temp=0L;
        for(int i=start;i<len-req;i++){
            int t=lst[i][c-'a'];
            if(t!=0){
                temp+=t*ways(lst,tar,pos+1,i+1,dp);
                temp=temp%1000000007;
            }
        }
        dp[pos][start]=temp;
        return temp;
    }

    public int numWays(String[] words, String target) {
        int len=words.length;
        int slen=words[0].length();
        int[][] lst=new int[slen][26];
        for(int i=0;i<len;i++){
            String s=words[i];
            for(int j=0;j<slen;j++){
                lst[j][s.charAt(j)-'a']++;
            }
        }
        long[][] dp=new long[target.length()+1][slen+1];
        for(int i=0;i<target.length();i++){
            Arrays.fill(dp[i],-1);
        }
        int ret=(int)ways(lst,target,0,0,dp)%1000000007;
        return ret;
    }
}
