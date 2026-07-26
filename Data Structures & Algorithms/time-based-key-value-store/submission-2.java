class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> valueMap;
        if (this.map.containsKey(key)) {
            valueMap = map.get(key);
        } else {
            valueMap = new LinkedHashMap<>();
        }
        valueMap.put(timestamp, value);
        map.put(key, valueMap);
    }

    public String get(String key, int timestamp) {
        if (map.isEmpty() || !map.containsKey(key))
            return "";
        List<Integer> time = new ArrayList<>(map.get(key).keySet());
        int n = time.size();
        int max = time.get(n - 1);
        if (timestamp >= max)
            return map.get(key).get(max);

        int l = 0;
        int r = n - 1;
        HashMap<Integer, String> valueMap = map.get(key);
        if (valueMap.containsKey(timestamp))
            return valueMap.get(timestamp);
        int min = Integer.MIN_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (time.get(m) == timestamp)
                return valueMap.get(time.get(m));
            if (time.get(m) > timestamp) {
                r = m - 1;
            } else {
                min = min > time.get(m) ? min : time.get(m);
                l = m + 1;
            }
            // System.out.println(m + " " + time.get(m) + " " + l + " " + r + " " + timestamp);
        }
        if (min>0 && min <= timestamp) {
            System.out.println(min);
            return valueMap.get(min);
        }
        return "";
    }
}
