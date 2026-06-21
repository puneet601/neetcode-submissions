class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            required.put(t.charAt(i), required.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashSet<Character> curr = new HashSet<>();
        int need = required.keySet().size();
        int l = 0, r = 0;

        int res[] = {-1, 1};
        int n = s.length();
        int currs=0;

        int min = Integer.MAX_VALUE;

        while (r < n && currs < need) {
            char c = s.charAt(r);
            if (required.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == required.get(c)) {
                    curr.add(c);
                    currs++;
                }
            }

            while (l < n && need == currs) {
                c = s.charAt(l);
                if (r - l + 1 < min) {
                    res[0] = l;
                    res[1] = r;
                    min = r - l + 1;
                }
                if (required.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    int freq = window.get(c);
                     
                    if (freq < required.get(c)) {
                        curr.remove(c);
                        currs--;
                        System.out.println(c + " " + l + " //" + r+" "+currs+" "+need);
                    }
                } 
                    l++;
            }
            r++;
        }

        return res[0]==-1 ? "" : s.substring(res[0], res[1] + 1);
    }
}
