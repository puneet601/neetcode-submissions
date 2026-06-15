class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int w = s1.length();
        if (w > n)
            return false;
        int l = 0;
        int r = 0;
        int al1[] = new int[26];
        int al2[] = new int[26];
        for (char c : s1.toCharArray()) {
            al1[c - 'a']++;
        }

        while (l<n) {
            while (l < n && al1[s2.charAt(l) - 'a'] == 0) {
                l++;
                r = l;
            }
            
            while (r < n && l<n && al1[s2.charAt(r) - 'a'] < al2[s2.charAt(r) - 'a']) {
                al2[s2.charAt(l) - 'a']--;
                l++;
                if(s2.charAt(l) != s2.charAt(r)){
                    break;
                }
            }

            while (r < n && al1[s2.charAt(r) - 'a'] > al2[s2.charAt(r) - 'a']) {
                al2[s2.charAt(r) - 'a']++;
                r++;
                System.out.println(r + " " + l);
                if (r - l == w) {
                    String st1 = Arrays.toString(al1);
                    String st2 = Arrays.toString(al2);

                    if (st1.equals(st2)) {
                        return true;
                    }
                }
            }
            if(l<n)
            al2[s2.charAt(l) - 'a']--;
            l++;
            
        }
        return false;
    }
}
