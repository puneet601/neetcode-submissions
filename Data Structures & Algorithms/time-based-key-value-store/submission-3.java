class Pair{

    int time;
    String val;

    Pair(int t, String v){
        this.time=t;
        this.val=v;
    }

}
class TimeMap {

    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> list;
        if(map.containsKey(key)){
            list = map.get(key);
        }else{
            list = new ArrayList<>();
        }
        list.add(new Pair(timestamp,value));
        map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        if(map.isEmpty() || !map.containsKey(key))
        return "";

        ArrayList<Pair> list = map.get(key);

        int n = list.size();
        int l = 0;
        int r = n-1;

        Pair min = new Pair(Integer.MIN_VALUE,"");

        while(l<=r){
            int m = l+(r-l)/2;
            Pair p = list.get(m);
            if(p.time==timestamp)
            return p.val;
            if(p.time<=timestamp){
                min = p;
                l=m+1;
            }else
            r=m-1;
        }

        return min.val;

    }
}
