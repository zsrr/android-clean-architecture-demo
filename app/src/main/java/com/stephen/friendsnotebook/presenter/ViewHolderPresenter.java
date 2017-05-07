package com.stephen.friendsnotebook.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class ViewHolderPresenter<V> implements Presenter {

    Reference<V> reference;

    public ViewHolderPresenter(V view) {
        reference = new WeakReference<>(view);
    }

    boolean isViewAttached() {
        return reference != null && reference.get() != null;
    }

    @Override
    public void detach() {
        if (isViewAttached()) {
            reference.clear();
            reference = null;
        }
    }
}
