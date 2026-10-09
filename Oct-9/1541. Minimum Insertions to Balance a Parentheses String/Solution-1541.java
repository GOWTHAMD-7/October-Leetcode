class Solution {
    public int minInsertions(String s) {
        int len=s.length();
        int ret=0;
        int cnt=0;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c=='('){
                cnt++;
            }
            else{
                if(cnt==0){
                    if(i+1<len && s.charAt(i+1)==')'){
                        ret++;
                        i++;
                    }
                    else{
                        ret+=2;
                    }
                }
                else{
                    if(i+1<len && s.charAt(i+1)==')'){
                        cnt--;
                        i++;
                    }
                    else{
                        ret++;
                        cnt--;
                    }
                }
            }
        }
        ret=ret+(cnt*2);
        return ret;
    }
}
