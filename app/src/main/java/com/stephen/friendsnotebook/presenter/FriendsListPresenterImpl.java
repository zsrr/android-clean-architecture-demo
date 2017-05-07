package com.stephen.friendsnotebook.presenter;

import com.stephen.friendsnotebook.data.Friend;
import com.stephen.friendsnotebook.domain.BaseTask;
import com.stephen.friendsnotebook.domain.FindAllFriendsTask;
import com.stephen.friendsnotebook.domain.TaskScheduler;
import com.stephen.friendsnotebook.view.FriendListView;

import java.util.List;


/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FriendsListPresenterImpl extends ViewHolderPresenter<FriendListView> implements FriendsListPresenter {
    public FriendsListPresenterImpl(FriendListView view) {
        super(view);
    }

    @Override
    public void getAllFriends() {
        if (isViewAttached()) {
            final FriendListView view = reference.get();
            TaskScheduler.getInstance().execute(new FindAllFriendsTask(new BaseTask.CallBack<List<Friend>>() {
                @Override
                public void onSuccess(List<Friend> response) {
                    view.notifyData(response);
                }

                @Override
                public void onError() {
                    view.onError();
                }
            }));
        }
    }
}