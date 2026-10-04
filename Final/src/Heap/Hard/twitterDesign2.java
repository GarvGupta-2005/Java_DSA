import java.util.*;

/**
 * LeetCode 355 - Design Twitter
 *
 * Feed is built as a k-way merge over each user's tweet list
 * (same pattern as Merge K Sorted Arrays / Lists).
 */
class Twitter {

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    /** Points at one tweet inside one user's list (like EleInfo in Merge K Sorted Arrays). */
    private static class Cursor {
        List<Tweet> list;
        int idx;

        Cursor(List<Tweet> list, int idx) {
            this.list = list;
            this.idx = idx;
        }

        Tweet tweet() {
            return list.get(idx);
        }
    }

    private static final int FEED_SIZE = 10;

    private final Map<Integer, Set<Integer>> following = new HashMap<>(); // follower -> followees
    private final Map<Integer, List<Tweet>> tweets = new HashMap<>();     // user -> tweets, oldest first
    private int time = 0;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        // A List keeps posting order, so the newest tweet is always at the end.
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap on time: the most recent tweet comes out first.
        PriorityQueue<Cursor> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.tweet().time, a.tweet().time));

        // Seed the heap with the NEWEST tweet of the user and of each followee.
        // The stored follow set is only read, never modified.
        addNewest(pq, userId);
        for (int followee : following.getOrDefault(userId, Collections.emptySet())) {
            addNewest(pq, followee);
        }

        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < FEED_SIZE) {
            Cursor c = pq.poll();
            feed.add(c.tweet().tweetId);

            // Step back to that same user's next-older tweet, if there is one.
            if (c.idx > 0) {
                c.idx--;
                pq.add(c);
            }
        }
        return feed;
    }

    private void addNewest(PriorityQueue<Cursor> pq, int userId) {
        List<Tweet> list = tweets.get(userId);
        if (list != null && !list.isEmpty()) {   // user may never have tweeted
            pq.add(new Cursor(list, list.size() - 1));
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return; // own tweets are always included by getNewsFeed
        }
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = following.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }
}
