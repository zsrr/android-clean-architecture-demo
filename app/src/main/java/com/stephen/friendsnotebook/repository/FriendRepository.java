package com.stephen.friendsnotebook.repository;


import android.support.annotation.NonNull;

import com.stephen.friendsnotebook.data.Friend;

import java.util.List;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public interface FriendRepository {
    Friend getFriend(long id);

    List<Friend> findAllFriends();

    int updateFriend(@NonNull Friend friend, long id);

    boolean createNewFriend(@NonNull Friend friend);
}
