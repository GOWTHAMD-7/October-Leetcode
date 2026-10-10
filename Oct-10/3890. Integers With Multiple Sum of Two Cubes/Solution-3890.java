class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Long,Integer> map=new HashMap<>();
        int i=1;
        while(true){
            long t=i*i*i;
            if(t>n){
                break;
            }
            int j=i+1;
            while(true){
                long tt=j*j*j;
                long temp=t+tt;
                if(temp<=n){
                    map.put(temp,map.getOrDefault(temp,0)+1);
                }
                else{
                    break;
                }
                j++;
            }
            i++;
        }
        List<Integer> ret=new ArrayList<>();
        for(Map.Entry<Long,Integer> e:map.entrySet()){
            if(e.getValue()>1){
                long v=e.getKey();
                int t=(int)v;
                ret.add(t);
            }
        }
        Collections.sort(ret);
        return ret;
    } 
}
