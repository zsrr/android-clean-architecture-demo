package com.stephen.friendsnotebook.domain;

import com.stephen.friendsnotebook.data.Friend;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FindFriendTask extends BaseTask<Long, Friend> {

    public FindFriendTask(CallBack<Friend> callBack) {
        super(callBack);
    }

    @Override
    protected void executeWithInput() {
        try {
            Friend friend = repository.getFriend(input);
            if (friend != null) {
                notifyWithResponse(friend);
            } else {
                notifyWithFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
            notifyWithFailure();
        }
    }
}
