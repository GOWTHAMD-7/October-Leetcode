class Solution {
    public String shiftingLetters(String s, int[] shift) {
        int len=shift.length;
        int sum=0;
        for(int i=len-1;i>=0;i--){
            sum+=shift[i];
            sum=sum%26;
            shift[i]=sum;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            int c=s.charAt(i)-97;
            int t=(c+shift[i])%26;
            sb.append((char)(t+97));
        }
        return sb.toString();
    }
}
