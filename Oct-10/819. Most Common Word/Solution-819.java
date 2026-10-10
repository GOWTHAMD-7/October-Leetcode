class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr=paragraph.split("[,. ]+");
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:banned){
            set.add(s.toLowerCase());
        }
        for(String s:arr){
            if(s.length()==0){
                continue;
            }
            char c=s.charAt(s.length()-1);
            if((c>=65 && c<=92) || (c>=97 && c<=122)){
                String ss=s.toLowerCase();
                map.put(ss,map.getOrDefault(ss,0)+1);
            }
            else{
                String ss=s.substring(0,s.length()-1).toLowerCase();
                map.put(ss,map.getOrDefault(ss,0)+1);
            }
        }
        int max=-1;
        String ret="e";
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String s=e.getKey();
            int val=e.getValue();
            if(!set.contains(s)){
                if(val>max){
                    max=val;
                    ret=s;
                }
            }
        }
        return ret;
    }
}
