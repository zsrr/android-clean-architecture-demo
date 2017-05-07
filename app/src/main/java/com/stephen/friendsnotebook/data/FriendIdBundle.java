package com.stephen.friendsnotebook.data;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FriendIdBundle {
    public final Friend friend;
    public final long id;

    public FriendIdBundle(Friend friend, long id) {
        this.friend = friend;
        this.id = id;
    }
}
