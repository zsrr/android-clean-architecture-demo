package com.stephen.friendsnotebook.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.stephen.friendsnotebook.R;
import com.stephen.friendsnotebook.data.Friend;
import com.stephen.friendsnotebook.presenter.CreateFriendPresenter;
import com.stephen.friendsnotebook.presenter.CreateFriendPresenterImpl;

public class CreateFriendFragment extends Fragment implements CreateFriendView {

    private CreateFriendPresenter presenter;

    public static final String TAG = "CREATE";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CreateFriendPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View contentView = inflater.inflate(R.layout.fragment_create_friend, container, false);
        contentView.findViewById(R.id.create_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) contentView.findViewById(R.id.name_et)).getText().toString();
                String phoneNumber = ((EditText) contentView.findViewById(R.id.phone_number_et)).getText().toString();
                String expression = ((EditText) contentView.findViewById(R.id.expression_et)).getText().toString();
                String githubUrl = ((EditText) contentView.findViewById(R.id.github_url_et)).getText().toString();

                Friend friend = new Friend();
                friend.setName(name);
                friend.setPhoneNumber(phoneNumber);
                friend.setExpression(expression);
                friend.setGithubUrl(githubUrl);

                presenter.createFriend(friend);
            }
        });
        return contentView;
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), R.string.fragment_create_friend_create_failure, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFriendCreated(boolean success) {
        if (success) {
            ((FriendsFragment)getActivity().getSupportFragmentManager().findFragmentByTag(FriendsFragment.TAG)).refresh();
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        } else {
            onError();
        }
    }
}
