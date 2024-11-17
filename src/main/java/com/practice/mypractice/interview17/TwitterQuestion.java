package com.practice.mypractice.interview17;

import java.util.*;

public class TwitterQuestion {

    //Coupang - Round 2 Coding

    /*

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId, Post content) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.


User {
    int userId ;
    List<User> followees; // ppl whom I follow
    List<User> followers; // ppl following me

    List<Integer> tweetIds;
    PriorityQueue<Tweet> precomputedNewFeed;
}

Post{
    int userId;
    int tweetId;
    Long timestamp;
    String text;
}

Twitter {

    List<User> users;
    HashMap<Integer, Tweet> tweetMap;
    //      tweetId, tweet

    List<Post> getNewsFeed(userId) {



    }

    void follow(int followerId, int followeeId);

    void unfollow(int followerId, int followeeId);

    void postTweet(int userId, int tweetId, Tweet post) {
        post.setTweetId (tweetId);
        post.setUserId (userId);
        tweetMap(tweetId, Post);
        User user =
        user.tweetIds.add(tweetId);
    }
}

*/

}

class Solution {

    public static void main(String[] args) {

        User u1 = new User(1);

        Twitter twitter = new Twitter();
        twitter.userMap.put(1, u1);
        twitter.postTweet(u1.userId, 1);

        System.out.println(twitter.getNewsFeed(1));
    }
}

class User {

    User(int userId) {
        this.userId = userId;
        followees = new ArrayList<>();
        followers = new ArrayList<>();
        precomputedFeed = new TreeMap<>();
    }

    int userId;
    List<User> followees; // ppl whom I follow
    List<User> followers; // ppl following me

    // List<Integer> tweetIds;
    // PriorityQueue<Tweet> precomputedNewFeed;
    TreeMap<Long, Integer> precomputedFeed;
    //  timestamp, TweetId
}

class Twitter {
    Twitter() {
        userMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    private static final int NEWS_FEED_LIMIT = 10;
    Map<Integer, User> userMap;
    HashMap<Integer, Tweet> tweetMap;
    //      tweetId, tweet


    List<Tweet> getNewsFeed(int userId) {

        User user = userMap.get(userId);

        List<Tweet> newsFeed = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Long, Integer> entry : user.precomputedFeed.entrySet()) {
            Tweet tweet = tweetMap.get(entry.getValue());
            newsFeed.add(tweet);
            i++;
            if (i == NEWS_FEED_LIMIT)
                break;
        }
        return newsFeed;

    }

    // void follow(int followerId, int followeeId);

    // void unfollow(int followerId, int followeeId);

    void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet();
        tweet.setTweetId(tweetId);
        tweet.setUserId(userId);
        tweet.setTimeStamp(System.currentTimeMillis());
        tweetMap.put(tweetId, tweet);

        User user = userMap.get(userId);
        List<User> followers = user.followers;
        for (User u : followers) {
            //adding for my followers
            u.precomputedFeed.put(tweet.timestamp, tweet.tweetId);
        }
        // Adding for myself
        user.precomputedFeed.put(tweet.timestamp, tweet.tweetId);
        System.out.println("Tweet Created : " + tweetId);
    }
}


class Tweet {
    int userId;
    int tweetId;
    Long timestamp;
    String text;

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTimeStamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}
