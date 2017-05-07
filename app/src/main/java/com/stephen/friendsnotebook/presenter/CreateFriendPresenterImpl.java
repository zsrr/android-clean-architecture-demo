package com.stephen.friendsnotebook.presenter;

import com.stephen.friendsnotebook.data.Friend;
import com.stephen.friendsnotebook.domain.BaseTask;
import com.stephen.friendsnotebook.domain.CreateNewFriendTask;
import com.stephen.friendsnotebook.domain.TaskScheduler;
import com.stephen.friendsnotebook.view.CreateFriendView;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class CreateFriendPresenterImpl extends ViewHolderPresenter<CreateFriendView> implements CreateFriendPresenter {
    public CreateFriendPresenterImpl(CreateFriendView view) {
        super(view);
    }

    @Override
    public void createFriend(Friend friend) {
        if (isViewAttached()) {
            final CreateFriendView view = reference.get();
            BaseTask<Friend, Void> task = new CreateNewFriendTask(new BaseTask.CallBack<Void>() {
                @Override
                public void onSuccess(Void response) {
                    view.onFriendCreated(true);
                }

                @Override
                public void onError() {
                    view.onFriendCreated(false);
                }
            });
            task.setInput(friend);
            TaskScheduler.getInstance().execute(task);
        }
    }
}
