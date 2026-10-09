class Solution {
    public int myAtoi(String s) {
        int len=s.length();
        if(len==0){
            return 0;
        }
        long ret=0;
        int k=0;
        int check=0;
        while(k<len && s.charAt(k)==' '){
            k++;
        }
        if(k<len && s.charAt(k)=='-'){
            check=1;
            k++;
            while(k<len){
                char c=s.charAt(k);
                if(c>48 && c<=57){
                    int t=(int)(c-48);
                    ret=t*-1;
                    break;
                }
                else if(c==48){
                    k++;
                }
                else{
                    return 0;
                }
            }
            if(k==len){
                return 0;
            }
            else{
                k++;
            }
        }
        else if(k<len && s.charAt(k)=='+'){
            k++;
            while(k<len){
                char c=s.charAt(k);
                if(c>48 && c<=57){
                    int t=(int)(c-48);
                    ret=t;
                    break;
                }
                else if(c==48){
                    k++;
                }
                else{
                    return 0;
                }
            }
            if(k==len){
                return 0;
            }
            else{
                k++;
            }
        }
        for(int i=k;i<len;i++){
            char c=s.charAt(i);
            if(ret>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(ret<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else if(c>=48 && c<=57){
                int t=(int)(c-48);
                if(check==0){
                    ret=(ret*10)+t;
                }
                else if(check==1){
                    ret=(ret*10)-t;
                }
            }
            else{
                return (int)ret;
            }
        }
        if(ret>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(ret<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)ret;
    }
}
