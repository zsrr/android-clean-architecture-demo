package com.stephen.friendsnotebook.domain;


import android.os.Handler;
import android.os.Looper;

import com.stephen.friendsnotebook.repository.FriendRepository;
import com.stephen.friendsnotebook.repository.FriendRepositoryImpl;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public abstract class BaseTask<I, R> implements Runnable {

    public BaseTask(CallBack<R> callBack) {
        this.callBack = callBack;
    }

    //执行回调
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    FriendRepository repository = new FriendRepositoryImpl();
    private CallBack<R> callBack;
    I input;

    public void setInput(I input) {
        this.input = input;
    }

    protected abstract void executeWithInput();

    void notifyWithResponse(final R response) {
        mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onSuccess(response);
            }
        });
    }

    void notifyWithFailure() {
        mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onError();
            }
        });
    }

    @Override
    public void run() {
        executeWithInput();
    }

    public interface CallBack<R> {
        void onSuccess(R response);
        void onError();
    }
}
