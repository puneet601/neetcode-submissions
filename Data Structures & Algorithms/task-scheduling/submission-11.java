class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cycles[] = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.freq).reversed());
        Queue<Pair> cool = new LinkedList<>();
        int currcycle = 1;


        for (char c : tasks) {
            cycles[c - 'A']++;
        }

        for (int i=0;i<26;i++) {
            if (cycles[i] > 0) {
                pq.add(new Pair((char) (i + 'A'), cycles[i], 0));
               
            }
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            
            if (p.next <= currcycle || p.next == 0) {
                p.freq = p.freq - 1;
                if (p.freq > 0) {
                    p.next = currcycle + n+1;
                    cool.add(p);
                }
            } 
            if(pq.isEmpty() && cool.isEmpty())
            return currcycle;
            
            currcycle++;
            if(!cool.isEmpty() && cool.peek().next==currcycle){
                pq.add(cool.poll());
            }
            if (pq.isEmpty()) {
                if(!cool.isEmpty()){
                    if(currcycle<cool.peek().next)
                     currcycle = cool.peek().next;
                     Pair top = cool.poll();
                pq.add(top);
                }
            }
        }
        return currcycle;
    }
}
class Pair {
    int freq;
    char task;
    int next;

    Pair(char task, int freq, int next) {
        this.task = task;
        this.freq = freq;
        this.next = next;
    }
}