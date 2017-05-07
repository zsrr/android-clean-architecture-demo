package com.stephen.friendsnotebook.domain;

import com.stephen.friendsnotebook.data.Friend;
import com.stephen.friendsnotebook.data.FriendIdBundle;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class UpdateFriendTask extends BaseTask<FriendIdBundle, Void> {

    public UpdateFriendTask(CallBack<Void> callBack) {
        super(callBack);
    }

    @Override
    protected void executeWithInput() {
        try {
            Friend friend = input.friend;
            long id = input.id;
            int affectedRowNumber = repository.updateFriend(friend, id);
            if (affectedRowNumber > 0) {
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
