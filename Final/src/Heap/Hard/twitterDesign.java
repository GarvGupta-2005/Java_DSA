package Heap.Hard;

import java.util.*;

class Tweet implements Comparable<Tweet> {
    int time;    // Stores the timestamp of the tweet
    int tweetId; // Stores the tweet ID

    Tweet(int t, int id) {
        this.time = t;
        this.tweetId = id;
    }

    // Comparator to sort tweets in decreasing order of time (latest tweets first)
    public int compareTo(Tweet that) {
        return that.time - this.time; 
    }
}

class User {
    int userId;                      // Unique ID of the user
    HashSet<Integer> followers;       // Set of users this user follows
    List<Tweet> tweets;               // List of tweets posted by the user

    User(int id) {
        this.userId = id;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
        followers.add(id); // Ensure the user follows themselves to see their own tweets
    }

    // Add a tweet to the user's list of tweets (insert at the beginning for quick access)
    public void addTweet(Tweet t) {
        tweets.add(0, t);
    }

    // Add a followee to the user's followers list
    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    // Remove a followee from the user's followers list
    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {
    HashMap<Integer, User> userMap; // Maps userId to User object
    int timeCounter; // Counter to track the time of tweets (used for sorting)

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    // Function to post a tweet
    public void postTweet(int userId, int tweetId) {
        timeCounter++; // Increment the global timestamp for each new tweet

        // If the user does not exist, create a new User object
        userMap.putIfAbsent(userId, new User(userId));

        // Get the user and add the new tweet
        userMap.get(userId).addTweet(new Tweet(timeCounter, tweetId));
    }

    // Function to get the 10 most recent tweets for a user
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>(); // Return empty list if user does not exist
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        // A max-heap (reverse order) to store the top 10 most recent tweets

        User user = userMap.get(userId);

        // Fetch tweets from the user and their followees
        for (int followeeId : user.followers) {
            if (!userMap.containsKey(followeeId)) continue; // Skip if followee doesn't exist
            
            // Add tweets of the followee to the priority queue
            for (Tweet tweet : userMap.get(followeeId).tweets) {
                pq.offer(tweet);
                if (pq.size() > 10) pq.poll(); // Maintain only top 10 tweets
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().tweetId); // Reverse order to get latest tweets first
        }

        return res;
    }

    // Function to follow a user
    public void follow(int followerId, int followeeId) {
        // If the user does not exist, create a new User object
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        // Add followee to the follower's list
        userMap.get(followerId).addFollower(followeeId);
    }

    // Function to unfollow a user
    public void unfollow(int followerId, int followeeId) {
        // Ensure both users exist and the follower isn't trying to unfollow themselves
        if (userMap.containsKey(followerId) && userMap.containsKey(followeeId) && followerId != followeeId) {
            userMap.get(followerId).removeFollower(followeeId);
        }
    }
}


public class twitterDesign {
    public static void main(String[] args) {
        Twitter t = new Twitter();
    }
}
