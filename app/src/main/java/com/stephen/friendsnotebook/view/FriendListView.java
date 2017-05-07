package com.stephen.friendsnotebook.view;

import com.stephen.friendsnotebook.data.Friend;

import java.util.List;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public interface FriendListView extends ErrorView {
    void notifyData(List<Friend> friends);
}
