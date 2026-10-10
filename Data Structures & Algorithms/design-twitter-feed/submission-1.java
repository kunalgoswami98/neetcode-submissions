class Twitter {
    private int time;
    private Map<Integer,Set<Integer>> followersMap;
    private Map<Integer,List<int[]>> tweetMap;
    public Twitter() {
        this.time = 0;
        this.followersMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[]{tweetId,time};
        List<int[]> tweetList = tweetMap.containsKey(userId) ?
            tweetMap.get(userId) : new ArrayList<>();
            tweetList.add(tweet);
        tweetMap.put(userId,tweetList);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //max heap that contains tweetId and timestamp of the particular tweet and orders it on the basis of time
        PriorityQueue<int[]> newsFeedHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        //push the tweet into newsFeed heap for that user
        List<int[]> tweetList = tweetMap.getOrDefault(userId, new ArrayList<>());
        for(int[] tweet : tweetList) {
            newsFeedHeap.add(tweet);
        }

        //get the followers and fetch there tweets
        Set<Integer> following = followersMap.containsKey(userId) ? 
            followersMap.get(userId) : new HashSet<>();
        for(int followee: following) {
            List<int[]> followeeTweetList = tweetMap.getOrDefault(followee, new ArrayList<>());
            for(int[] tweet : followeeTweetList) {
                newsFeedHeap.add(tweet);
            }
        }
        List<Integer> newsFeedList = new ArrayList<>();
        int maxTweet = 10;
        while(maxTweet > 0 && !newsFeedHeap.isEmpty()){
            newsFeedList.add(newsFeedHeap.poll()[0]);
            maxTweet--;
        }
        return newsFeedList;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> followers = followersMap.containsKey(followerId) ?
            followersMap.get(followerId) : new HashSet<>();
        followers.add(followeeId);
        followersMap.put(followerId,followers);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.containsKey(followerId) && followersMap.get(followerId).contains(followeeId)){
            followersMap.get(followerId).remove(followeeId);
        }
    }
}
