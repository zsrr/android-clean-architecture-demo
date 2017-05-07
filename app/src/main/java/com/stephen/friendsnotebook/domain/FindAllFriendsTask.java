package com.stephen.friendsnotebook.domain;

import com.stephen.friendsnotebook.data.Friend;

import java.util.List;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FindAllFriendsTask extends BaseTask<Void, List<Friend>> {
    public FindAllFriendsTask(CallBack<List<Friend>> callBack) {
        super(callBack);
    }

    @Override
    protected void executeWithInput() {
        try {
            List<Friend> friends = repository.findAllFriends();
            if (friends != null) {
                notifyWithResponse(friends);
            } else {
                notifyWithFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
            notifyWithFailure();
        }
    }
}
