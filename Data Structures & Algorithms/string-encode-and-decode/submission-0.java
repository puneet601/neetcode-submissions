class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder lengths = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            lengths.append(s.length() + ",");
            str.append(s);
        }
        return lengths.append("#" + str).toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        if (str == "") {
            res.add("");
            return res;
        }
        String lengths = str.split("#")[0];
        String size[] = lengths.split(",");
        int i = 0;

        while (str.charAt(i) != '#') {
            i++;
        }
        i++;
        int j = 0;
        for (String si: size) {
            int length = Integer.valueOf(si);
            
            res.add(str.substring(i,i+length));
            i+=length;
        }
        return res;
    }
}
