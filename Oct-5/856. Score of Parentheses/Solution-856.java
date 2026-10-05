class Solution {
    public int scoreOfParentheses(String s) {
        int len=s.length();
        Stack<String> st=new Stack<>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push("(");
            }
            else{
                int cnt=0;
                while(!st.peek().equals("(")){
                    int temp=Integer.valueOf(st.pop());
                    cnt+=temp;
                }
                st.pop();
                if(cnt==0){
                    st.push(String.valueOf(1));
                }
                else{
                    st.push(String.valueOf(cnt*2));
                }
            }
        }
        int ret=0;
        while(!st.isEmpty()){
            ret+=Integer.valueOf(st.pop());
        }
        return ret;
    }
}
