class MedianFinder {
    PriorityQueue<Double> max;
    PriorityQueue<Double> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (min.isEmpty() && max.isEmpty()) {
            min.add(Double.valueOf(num));
            return;
        }

        if (!min.isEmpty()) {
            if (num > min.peek())
                min.add(Double.valueOf(num));
            else
                max.add(Double.valueOf(num));
            return;
        }

        if (!max.isEmpty()) {
            if (num < max.peek())
                max.add(Double.valueOf(num));
            else
                min.add(Double.valueOf(num));
            return;
        }
    }

    public double findMedian() {
        
        PriorityQueue<Double> small = min.size() > max.size() ? max : min;
        PriorityQueue<Double> nsmall = min.size() <= max.size() ? max : min;
        
        while (small.size() - nsmall.size() < -1) {
            small.add(nsmall.poll());
        }
       
        if (small.size() - nsmall.size() == 0) {
            double v=(small.peek() + nsmall.peek()) / 2.0;
        
            return v;
        }

        if (small.size() - nsmall.size() == -1) {
            return nsmall.peek();
        }
        return nsmall.peek();
    }
}
