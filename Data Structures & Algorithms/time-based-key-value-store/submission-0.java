class TimeMap {
    class Data{
        String value;
        int time;

        Data(String value, int time){
            this.value = value;
            this.time = time;
        }
    }
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Data> list = map.get(key);
            list.add(new Data(value,timestamp));
            map.put(key,list);
        }
        else{
            List<Data> list = new ArrayList<>();
            list.add(new Data(value,timestamp));
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        return findByBinarySearch(map.get(key),timestamp);
    }

    private String findByBinarySearch(List<Data> list, int time){
        int start = 0;
        int end = list.size()-1;
        
        while(start < end){
            int mid = start + (end- start) /2;
            if(list.get(mid).time == time) return list.get(mid).value;
            else if(time > list.get(mid).time){
                if(list.get(mid+1).time > time) return list.get(mid).value;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return list.get(start).time <= time ? list.get(start).value : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */