package com.example.nikkishen.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class zipcode extends AppCompatActivity implements View.OnClickListener {


    private ImageButton btn_back;
    private TextView tv_zipcode;
    private ListView lv;
    private ProgressDialog pd;
    private MemberAdapter mAdapter;
    private List<CurrentLegislatorsBean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipcode);
        initView();

        String code = getIntent().getStringExtra("code");
        tv_zipcode.setText("Under ZipCode " + code);

        String url = "https://api.geocod.io/v1.3/geocode?q=" + code + "&fields=cd&api_key=b42a43b3a015337838939734b1c5bf5d313abb7";

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        pd.dismiss();
                        Toast.makeText(zipcode.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        pd.dismiss();

                        GeocodZipcode geocodZipcode = new Gson().fromJson(response, GeocodZipcode.class);
                        if (geocodZipcode != null) {

                            for (GeocodZipcode.ResultsBean rb : geocodZipcode.getResults()) {

                                for (GeocodZipcode.ResultsBean.FieldsBean.CongressionalDistrictsBean cdb : rb.getFields().getCongressional_districts()) {

                                    for (CurrentLegislatorsBean cb : cdb.getCurrent_legislators()) {

                                        if (!datas.contains(cb)) {
                                            datas.add(cb);
                                        }
                                    }

                                }
                            }


                            mAdapter.notifyDataSetChanged();

                        }


                    }
                });
    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        tv_zipcode = (TextView) findViewById(R.id.tv_zipcode);
        lv = (ListView) findViewById(R.id.lv);

        btn_back.setOnClickListener(this);

        mAdapter = new MemberAdapter(this, datas);
        lv.setAdapter(mAdapter);

        pd = new ProgressDialog(this);
        pd.show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String member_id = datas.get(position).getReferences().getBioguide_id();

                String url = "https://api.propublica.org/congress/v1/members/" + member_id + ".json";
                Intent intent = new Intent(zipcode.this, detail.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
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
