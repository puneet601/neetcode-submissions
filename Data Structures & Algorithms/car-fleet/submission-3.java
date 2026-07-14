class Pair {
    int p;
    int s;
    Pair(int p, int s) {
        this.p = p;
        this.s = s;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> st = new Stack<>();
        List<Pair> list = new ArrayList<>();

        int n = speed.length;
        for (int i = 0; i < n; i++) {
            list.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(list, (a, b) -> Integer.compare(b.p, a.p));

        for (Pair pair : list) {
            float t = target - pair.p;
            t /= pair.s;

            if (!st.isEmpty()) {
                float top = st.peek();
                st.push(t);
                if (top >= t)
                st.pop();
                    
            }else st.push(t);
            
        }
        return st.size();
    }
}
