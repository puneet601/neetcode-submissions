class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> topK =
            new PriorityQueue<>(Comparator.comparingInt((Pair d) -> d.distance).reversed());
        
        for (int i = 0; i < points.length; i++) {
            int distance = getDistance(points[i][0], points[i][1]);

            if (topK.size() < k) {
                topK.add(new Pair(points[i][0], points[i][1], distance));
            } else if (topK.peek()!=null && topK.peek().distance > distance) {
                topK.poll();
                topK.add(new Pair(points[i][0], points[i][1], distance));
               
            }
        }

        int res[][] = new int[topK.size()][2];
        int i = 0;
        while (!topK.isEmpty()) {
            Pair p = topK.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
            i++;
        }

        return res;
    }

    int getDistance(int x, int y) {
        return (x * x) + (y * y);
    }
}
class Pair {
    int x;
    int y;
    int distance;

    Pair(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}