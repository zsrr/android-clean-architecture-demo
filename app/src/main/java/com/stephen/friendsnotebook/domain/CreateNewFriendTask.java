package com.stephen.friendsnotebook.domain;

import com.stephen.friendsnotebook.data.Friend;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class CreateNewFriendTask extends BaseTask<Friend, Void> {
    public CreateNewFriendTask(CallBack<Void> callBack) {
        super(callBack);
    }

    @Override
    protected void executeWithInput() {
        try {
            Friend friend = input;
            boolean success = repository.createNewFriend(friend);
            if (success) {
                notifyWithResponse(null);
            } else {
                notifyWithFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
            notifyWithFailure();
        }
    }
}
