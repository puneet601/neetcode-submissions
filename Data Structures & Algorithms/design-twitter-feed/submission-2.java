class Twitter {
    HashMap<Integer, HashSet<Integer>> following;
    HashMap<Integer, ArrayList<Tweet>> tweets;
    private static int counter = 0;

    public Twitter() {
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (tweets.get(userId) == null || tweets.get(userId).isEmpty())
            this.tweets.put(userId, new ArrayList<>());
        this.tweets.get(userId).add(new Tweet(tweetId, ++Twitter.counter));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        HashSet<Integer> followees = this.following.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        if(followees==null)
        followees = new HashSet<>(); 
        followees.add(userId);
        for (Integer i : followees) {
            if (i != null) {
                ArrayList<Tweet> tws = tweets.get(i);
                if(tws==null)
                continue;
                int j = 0;
                for ( j = 0; j < tws.size(); j++) {
                    if (pq.size() < 10) {
                        pq.add(tws.get(j));
                    } else {
                        Tweet top = pq.peek();
                        if (top.time < tws.get(j).time) {
                            pq.poll();
                            pq.add(tws.get(j));
                        }
                    }
                }
            }
        }
        int i=9;
        int arr[] = new int[10];
        while(i>=0){
            if(!pq.isEmpty())
            arr[i]=pq.poll().id;
            else
            arr[i]=-1;
            i--;
        }


        int s = newsFeed.size();
       for(int v:arr){
        if(v>-1){
            newsFeed.add(v);
        }

       }
        
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follow = this.following.get(followerId);
        if (follow == null || follow.size() == 0) {
            follow = new HashSet<>();
        }
        follow.add(followeeId);
        this.following.put(followerId, follow);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follow = this.following.get(followerId);
        if (follow != null && follow.contains(followeeId)) {
            follow.remove(followeeId);
        }
        this.following.put(followerId, follow);
    }
}

class Tweet {
    int id;
    int time;
    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}
