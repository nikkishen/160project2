package com.example.nikkishen.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MemberAdapter extends BaseAdapter {

    private Context mContext;
    private List<CurrentLegislatorsBean> datas;

    public MemberAdapter(Context context, List<CurrentLegislatorsBean> datas) {
        mContext = context;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            convertView = View.inflate(mContext, R.layout.item_member, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }

        CurrentLegislatorsBean item = datas.get(position);

        holder.tv_name.setText(item.getBio().getFirst_name() + " " + item.getBio().getLast_name());

        holder.tv_party.setText(item.getBio().getParty());

        String id = item.getReferences().getBioguide_id();

        Glide.with(mContext).load("http://bioguide.congress.gov/bioguide/photo/"
                + id.substring(0, 1) + "/" + id + ".jpg").into(holder.profile_image);


        holder.tv_website.setText(item.getContact().getUrl());
        holder.tv_email.setText(item.getType());

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public CircleImageView profile_image;
        public TextView tv_name;
        public TextView tv_party;
        public TextView tv_website;
        public TextView tv_email;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.profile_image = (CircleImageView) rootView.findViewById(R.id.profile_image);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_party = (TextView) rootView.findViewById(R.id.tv_party);
            this.tv_website = (TextView) rootView.findViewById(R.id.tv_website);
            this.tv_email = (TextView) rootView.findViewById(R.id.tv_email);
        }

    }
}
