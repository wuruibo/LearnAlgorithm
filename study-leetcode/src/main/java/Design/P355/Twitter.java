package Design.P355;

import java.util.*;

/**
 * @author yqz
 * @date 2021-02-23
 */
class Twitter {
    /**
     * 定义发送的文章实体类
     */
    private static class Tweet{
        private Integer tweetId;
        private long timeStamp;
        private Tweet next;

        public Tweet(Integer tweetId,long timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp=timeStamp;
        }

        public long getTimeStamp() {
            return timeStamp;
        }
    }

    /**
     * 维护每个用户的文章列表 通过链表的方式往后叠加
     */
    Map<Integer,Tweet> tweetMap;
    /**
     * 维护每个用户关注的用户列表
     */
    Map<Integer, Set<Integer>> followersMap;
    /**
     * 参与合并k个排序的链表 找出前k个最大
     */
    PriorityQueue<Tweet> minHeap;
    /** Initialize your data structure here. */
    public Twitter() {
        this.tweetMap=new HashMap<>(12);
        this.followersMap=new HashMap<>(12);
        this.minHeap=new PriorityQueue<>(Comparator.comparingLong(Tweet::getTimeStamp).reversed());
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet=new Tweet(tweetId, System.nanoTime());
        Tweet head=tweetMap.get(userId);
        if (head==null) {
            tweetMap.put(userId,tweet);
        }else {
            tweet.next=head;
            head=tweet;
            tweetMap.put(userId,head);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // 由于是全局使用的，使用之前需要清空
        minHeap.clear();
        Tweet selfTweet=tweetMap.get(userId);
        if (selfTweet!=null) {
            minHeap.offer(selfTweet);
        }
        Set<Integer> followers=followersMap.getOrDefault(userId,new HashSet<>());
        for (Integer follower : followers) {
            if (tweetMap.containsKey(follower)) {
                minHeap.offer(tweetMap.get(follower));
            }
        }
        //循环出十篇文章
        List<Integer> result=new ArrayList<>();
        while (!minHeap.isEmpty() && result.size()<10){
            Tweet head=minHeap.poll();
            result.add(head.tweetId);
            if (head.next!=null) {
                minHeap.offer(head.next);
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId==followerId) {
            return;
        }
        Set<Integer> followersIds=followersMap.getOrDefault(followerId,new HashSet<>());
        followersIds.add(followeeId);
        followersMap.put(followerId,followersIds);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followersIds=followersMap.getOrDefault(followerId,new HashSet<>());
        followersIds.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 7).
        twitter.postTweet(1, 7);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
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