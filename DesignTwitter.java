package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 17-1-2.
 */
public class DesignTwitter {

    /**
     * 355
     */

    HashMap<Integer, Set<Integer>> follows = new HashMap<>();
    // 记录事件的有序性
    List<Feed> feeds = new ArrayList<>();

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Feed f = new Feed(userId, tweetId);
        feeds.add(f);

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        Set<Integer> users = follows.get(userId);

        if (users == null)
            users = new HashSet<>();
        // 用户本身也需要要添加进去
        users.add(userId);

        //由于任务的创建 有序的是在feeds中
        for (int i = feeds.size()-1; i>=0; i--)
        {
            Feed f = feeds.get(i);
            if (res.size() <10 && users.contains(f.getUserid()))
                res.add(f.getTweetid());
            else if (res.size() == 10)
            {
                return res;
            }
        }
        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (follows.containsKey(followerId))
        {
            follows.get(followerId).add(followeeId);
        }
        else
        {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            follows.put(followerId, set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId))
        {
            return;
        }
        else {
            follows.get(followerId).remove(followeeId);
        }

    }
}

class Feed{
    int userid;
    int tweetid;

    public Feed(int userid, int tweetid) {
        this.userid = userid;
        this.tweetid = tweetid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTweetid() {
        return tweetid;
    }

    public void setTweetid(int tweetid) {
        this.tweetid = tweetid;
    }
}
