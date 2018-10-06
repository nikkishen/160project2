package com.example.nikkishen.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

public class detail extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog pd;
    private ImageButton btn_back;
    private CircleImageView profile_image;
    private TextView tv_name;
    private TextView tv_party;
    private TextView tv_ends;
    private TextView tv_election;
    private TextView tv_committees;
    private TextView tv_bills;
    private TextView tv_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();


        final String url = getIntent().getStringExtra("url");
        final Map<String, String> headers = new HashMap<>();
        headers.put("X-API-Key", "NeMb1UHUgnw0Qqy8r98TOjDP82NcmnW2ROMr9WmG");
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        pd.dismiss();
                        Toast.makeText(detail.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        MemberDetail memberDetail = new Gson().fromJson(response, MemberDetail.class);
                        if (memberDetail != null) {

                            if (!memberDetail.getResults().isEmpty()) {

                                MemberDetail.ResultsBean item = memberDetail.getResults().get(0);

                                String name = "";
                                if (!TextUtils.isEmpty(item.getFirst_name())) {
                                    name += item.getFirst_name();
                                }
                                if (!TextUtils.isEmpty(item.getMiddle_name())) {
                                    name += " ";
                                    name += item.getMiddle_name();
                                }
                                if (!TextUtils.isEmpty(item.getLast_name())) {
                                    name += " ";
                                    name += item.getLast_name();
                                }

                                tv_name.setText(name);

                                MemberDetail.ResultsBean.RolesBean roles = item.getRoles().get(0);

                                tv_party.setText(roles.getParty().equals("D") ? "Democrat" : "Republican");
                                tv_ends.setText("Current Term Ends:" + roles.getEnd_date());
                                tv_election.setText(item.getUrl());
                                tv_form.setText(roles.getContact_form());

                                String member_id = item.getMember_id();

                                Glide.with(detail.this).load("http://bioguide.congress.gov/bioguide/photo/"
                                        + member_id.substring(0, 1) + "/" + member_id + ".jpg").into(profile_image);


                                StringBuffer sb = new StringBuffer();
                                for (MemberDetail.ResultsBean.RolesBean.CommitteesBean cb : roles.getCommittees()) {
                                    sb.append(cb.getName());
                                    sb.append("\n");
                                }
                                tv_committees.setText(sb.toString());


                                OkHttpUtils
                                        .get()
                                        .url("https://api.propublica.org/congress/v1/members/" + member_id + "/bills/introduced.json")
                                        .headers(headers)
                                        .build()
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onError(Call call, Exception e, int id) {

                                                pd.dismiss();
                                                Toast.makeText(detail.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                            }

                                            @Override
                                            public void onResponse(String response, int id) {

                                                pd.dismiss();

                                                Bills bills = new Gson().fromJson(response, Bills.class);
                                                if (bills != null) {

                                                    if (!bills.getResults().isEmpty()) {

                                                        StringBuffer sb = new StringBuffer();
                                                        for (Bills.ResultsBean.BillsBean bb : bills.getResults().get(0).getBills()) {
                                                            sb.append(bb.getShort_title());
                                                            sb.append("\n");
                                                        }

                                                        tv_bills.setText(sb.toString());

                                                    }
                                                }

                                            }
                                        });


                            }
                        }

                    }
                });

    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_party = (TextView) findViewById(R.id.tv_party);
        tv_ends = (TextView) findViewById(R.id.tv_ends);
        tv_election = (TextView) findViewById(R.id.tv_election);
        tv_committees = (TextView) findViewById(R.id.tv_committees);
        tv_bills = (TextView) findViewById(R.id.tv_bills);

        btn_back.setOnClickListener(this);

        pd = new ProgressDialog(this);
        pd.show();
        tv_form = (TextView) findViewById(R.id.tv_form);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:

                finish();

                break;
        }
    }
}
