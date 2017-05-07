package com.stephen.friendsnotebook.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.stephen.friendsnotebook.R;
import com.stephen.friendsnotebook.data.Friend;
import com.stephen.friendsnotebook.presenter.FriendsListPresenter;
import com.stephen.friendsnotebook.presenter.FriendsListPresenterImpl;
import com.stephen.friendsnotebook.view.adapter.FriendsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment implements FriendListView {

    FriendsListPresenter presenter;
    List<Friend> friends = new ArrayList<>();
    BaseAdapter adapter;

    public static final String TAG = "FRIEND";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FriendsListPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        adapter = new FriendsListAdapter(friends);
        ((ListView) view.findViewById(R.id.friends_list)).setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), R.string.fragment_friends_little_problem_occurred, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notifyData(List<Friend> friends) {
        this.friends.clear();
        this.friends.addAll(friends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detach();
        presenter = null;
    }

    public void refresh() {
        presenter.getAllFriends();
    }
}