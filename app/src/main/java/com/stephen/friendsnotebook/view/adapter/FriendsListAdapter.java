package com.stephen.friendsnotebook.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stephen.friendsnotebook.R;
import com.stephen.friendsnotebook.data.Friend;

import java.util.List;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class FriendsListAdapter extends BaseAdapter {

    private List<Friend> friends;

    public FriendsListAdapter(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_friends_list, parent, false);
        }

        TextView nameTv = (TextView) convertView.findViewById(R.id.name_tv);
        nameTv.setText(friends.get(position).getName());

        TextView phoneNumberTv = (TextView) convertView.findViewById(R.id.phone_number_tv);
        phoneNumberTv.setText(friends.get(position).getPhoneNumber());

        return convertView;
    }
}
