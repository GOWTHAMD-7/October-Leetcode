class Pair{
    int cnt;
    long val;
    Pair(int cnt,long val){
        this.cnt=cnt;
        this.val=val;
    }
}

class Solution {
    public long minSumSquareDiff(int[] arr1, int[] arr2, int k1, int k2) {
        int len=arr1.length;
        long[] arr=new long[len];
        for(int i=0;i<len;i++){
            arr[i]=(long)Math.abs(arr1[i]-arr2[i]);
        }
        Arrays.sort(arr);
        List<Pair> lst=new ArrayList<>();
        int cnt=1;
        long m=arr[0];

        for(int i=1;i<len;i++){
            if(arr[i]==m){
                cnt++;
            }
            else{
                lst.add(new Pair(cnt,(long)m));
                m=arr[i];
                cnt=1;
            }
        }
        lst.add(new Pair(cnt,m));
        int total=k1+k2;
        int k=0;
        while(k<total){
            int size=lst.size();
            long min=lst.get(0).val;
            long max=lst.get(size-1).val;
            long max2=0;
            if(size-2>=0){
                max2=lst.get(size-2).val;
            }
            if(max==0){
                break;
            }
            int tlen=lst.get(size-1).cnt;
            long diff=max-max2;
            int kk=total-k;
            int mod=kk%tlen;
            long div=kk/tlen;
            div=Math.min(div,diff);
            if(size==1){
                if(div>=diff){
                    return 0L;
                }
                else{
                    if(div+1==diff){
                        lst.remove(size-1);
                        long temp=max-div;
                        lst.add(new Pair(tlen-mod,temp));
                        k+=div*tlen;
                        k+=mod;
                    }
                    else{
                        lst.remove(size-1);
                        long temp=(int)(max-div);
                        lst.add(new Pair(mod,temp-1));
                        lst.add(new Pair(tlen-mod,temp));
                        k+=div*tlen;
                        k+=mod;
                    }
                }
                break;
            }
            if(div>=diff){
                lst.remove(size-1);
                lst.get(size-2).cnt+=tlen;
                k+=(tlen*diff);
            }
            else{
                if(div+1==diff){

                    lst.get(size-2).cnt+=mod;
                    lst.get(size-1).val=max2+1;
                    lst.get(size-1).cnt-=mod;
                    k+=div*tlen;
                    k+=mod;
                }
                else{
                    lst.remove(size-1);
                    long temp=(int)(max-div);
                    lst.add(new Pair(mod,temp-1));
                    lst.add(new Pair(tlen-mod,temp));
                    k+=div*tlen;
                    k+=mod;
                }
            }
        }
        long ret=0L;
        int size=lst.size();
        for(int i=0;i<size;i++){
            Pair p=lst.get(i);
            ret+=p.cnt*(p.val*p.val);
        }
        return ret;
    }
}
