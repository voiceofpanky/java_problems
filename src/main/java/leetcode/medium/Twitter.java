package leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/design-twitter/description/
// 355. Design Twitter
class Twitter {
    private static int timeStamp = 0;

    private Map<Integer, Tweet> tweets;
    private Map<Integer, Set<Integer>> follows;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId, timeStamp++);
        t.next = tweets.get(userId);
        tweets.put(userId, t);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // Ensure user follows themselves
        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId);

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (a, b) -> b.time - a.time
        );

        for (int followee : follows.get(userId)) {
            Tweet t = tweets.get(followee);
            if (t != null) maxHeap.add(t);
        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet t = maxHeap.poll();
            feed.add(t.id);
            if (t.next != null) maxHeap.add(t.next);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot unfollow self
        if (follows.containsKey(followerId))
            follows.get(followerId).remove(followeeId);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */