package com.stephen.friendsnotebook.repository;

import android.support.annotation.NonNull;

import com.stephen.friendsnotebook.data.Friend;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FriendRepositoryImpl implements FriendRepository {
    @Override
    public Friend getFriend(long id) {
        return DataSupport.find(Friend.class, id);
    }

    @Override
    public List<Friend> findAllFriends() {
        return DataSupport.findAll(Friend.class);
    }

    @Override
    public int updateFriend(@NonNull Friend friend, long id) {
        return friend.update(id);
    }

    @Override
    public boolean createNewFriend(@NonNull Friend friend) {
        return friend.save();
    }
}
