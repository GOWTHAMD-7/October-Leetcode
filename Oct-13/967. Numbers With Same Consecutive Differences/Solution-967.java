class Solution {

    public void backTrack(int n,int k,HashSet<String> set,StringBuilder sb){
        int len=sb.length();
        if(len==n){
            set.add(sb.toString());
            return;
        }
        int i=sb.charAt(len-1)-48;
        if(i+k<10){
            sb.append((char)(i+k+48));
            backTrack(n,k,set,sb);
            sb.deleteCharAt(len);
        }
        if(i-k>=0){
            sb.append((char)(i-k+48));
            backTrack(n,k,set,sb);
            sb.deleteCharAt(len);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<10;i++){
            sb.append((char)(i+48));
            backTrack(n,k,set,sb);
            sb.deleteCharAt(0);
        }
        int len=set.size();
        int[] ret=new int[len];
        int i=0;
        for(String s:set){
            ret[i]=Integer.valueOf(s);
            i++;
        }
        return ret;
    }
}
