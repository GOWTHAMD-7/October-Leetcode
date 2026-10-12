class Solution {
    public String reverseStr(String s, int k) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        for(int i=0;i<len;i+=2*k){
            int temp=Math.min(i+k,len);
            StringBuilder t=new StringBuilder();
            t.append(s.substring(i,temp));
            sb.replace(i,temp,t.reverse().toString());
        }
        return sb.toString();
    }
}
