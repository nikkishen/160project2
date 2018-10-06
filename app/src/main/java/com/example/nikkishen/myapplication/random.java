package com.example.nikkishen.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Call;

public class random extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_back;
    private ImageView imageView5;
    private TextView tv_random;
    private ListView lv;
    private ProgressDialog pd;
    private MemberAdapter mAdapter;
    private List<CurrentLegislatorsBean> datas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        initView();


        getData(randomCode());


    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        tv_random = (TextView) findViewById(R.id.tv_random);
        lv = (ListView) findViewById(R.id.lv);

        btn_back.setOnClickListener(this);

        mAdapter = new MemberAdapter(this, datas);
        lv.setAdapter(mAdapter);

        pd = new ProgressDialog(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String member_id = datas.get(position).getReferences().getBioguide_id();

                String url = "https://api.propublica.org/congress/v1/members/" + member_id + ".json";
                Intent intent = new Intent(random.this, detail.class);
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

    private String randomCode() {

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {

            sb.append(random.nextInt(10));

        }
        return sb.toString();
    }

    private void getData(final String zipcode) {

        System.out.println(zipcode);

        pd.show();

        String url = "https://api.geocod.io/v1.3/geocode?q=" + zipcode + "&fields=cd&api_key=b42a43b3a015337838939734b1c5bf5d313abb7";

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        pd.dismiss();
                        Toast.makeText(random.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        pd.dismiss();

                        GeocodZipcode geocodZipcode = new Gson().fromJson(response, GeocodZipcode.class);
                        if (geocodZipcode != null) {

                            if (geocodZipcode.getResults().isEmpty()) {

                                getData(randomCode());

                            } else {

                                for (GeocodZipcode.ResultsBean rb : geocodZipcode.getResults()) {

                                    GeocodZipcode.ResultsBean.AddressComponentsBeanX ab = rb.getAddress_components();

                                    String scz = ab.getState() + " " + ab.getCity() + " " + zipcode;

                                    if (!tv_random.getText().toString().contains(scz)) {
                                        tv_random.append(scz + "\n");
                                    }

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


                        } else {

                            getData(randomCode());
                        }


                    }
                });
    }
}
