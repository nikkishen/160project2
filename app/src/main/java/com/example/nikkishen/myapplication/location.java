package com.example.nikkishen.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.configuration.DefaultProviderConfiguration;
import com.yayandroid.locationmanager.configuration.GooglePlayServicesConfiguration;
import com.yayandroid.locationmanager.configuration.LocationConfiguration;
import com.yayandroid.locationmanager.constants.ProviderType;
import com.yayandroid.locationmanager.listener.LocationListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class location extends AppCompatActivity implements View.OnClickListener {


    private ImageButton btn_back;
    private ListView lv;
    private MemberAdapter mAdapter;
    private List<CurrentLegislatorsBean> datas = new ArrayList<>();

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initView();

        LocationConfiguration awesomeConfiguration = new LocationConfiguration.Builder()
                .keepTracking(false)
//                .askForPermission(new PermissionConfiguration.Builder()
//                        .permissionProvider(new YourCustomPermissionProvider())
//                        .rationalMessage("Gimme the permission!")
//                        .rationaleDialogProvider(new YourCustomDialogProvider())
//                        .requiredPermissions(new String[] { permission.ACCESS_FINE_LOCATION })
//                        .build())
                .useGooglePlayServices(new GooglePlayServicesConfiguration.Builder()
//                        .locationRequest(YOUR_CUSTOM_LOCATION_REQUEST_OBJECT)
                        .fallbackToDefault(true)
                        .askForGooglePlayServices(false)
                        .askForSettingsApi(true)
                        .failOnConnectionSuspended(true)
                        .failOnSettingsApiSuspended(false)
                        .ignoreLastKnowLocation(false)
                        .setWaitPeriod(20 * 1000)
                        .build())
                .useDefaultProviders(new DefaultProviderConfiguration.Builder()
                        .requiredTimeInterval(5 * 60 * 1000)
                        .requiredDistanceInterval(0)
                        .acceptableAccuracy(5.0f)
                        .acceptableTimePeriod(5 * 60 * 1000)
                        .gpsMessage("Turn on GPS?")
//                        .gpsDialogProvider(new YourCustomDialogProvider())
                        .setWaitPeriod(ProviderType.GPS, 20 * 1000)
                        .setWaitPeriod(ProviderType.NETWORK, 20 * 1000)
                        .build())
                .build();

        // LocationManager MUST be initialized with Application context in order to prevent MemoryLeaks
        LocationManager awesomeLocationManager = new LocationManager.Builder(getApplicationContext())
                .activity(this) // Only required to ask permission and/or GoogleApi - SettingsApi
                .configuration(awesomeConfiguration)
//                .locationProvider(new YourCustomLocationProvider())
                .notify(new LocationListener() {
                    @Override
                    public void onProcessTypeChanged(int processType) {

                    }

                    @Override
                    public void onLocationChanged(Location location) {

                        System.out.println(location.getLatitude() + "," + location.getLongitude());
                        getData(location);
                    }

                    @Override
                    public void onLocationFailed(int type) {

                    }

                    @Override
                    public void onPermissionGranted(boolean alreadyHadPermission) {

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                })
                .build();

        awesomeLocationManager.get();

    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
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
                Intent intent = new Intent(location.this, detail.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:

                finish();

                break;
        }
    }

    private void getData(Location location) {

        String url = "https://api.geocod.io/v1.3/reverse?q=" + location.getLatitude() + "," + location.getLongitude() + "&fields=cd&api_key=b42a43b3a015337838939734b1c5bf5d313abb7";

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        pd.dismiss();
                        Toast.makeText(location.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        pd.dismiss();

                        GeocodLocation geocodLocation = new Gson().fromJson(response, GeocodLocation.class);

                        if (geocodLocation != null) {

                            for (GeocodLocation.ResultsBean rb : geocodLocation.getResults()) {

                                for (GeocodLocation.ResultsBean.FieldsBean.CongressionalDistrictsBean cdb : rb.getFields().getCongressional_districts()) {

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
}
