package com.example.restaurant;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MarkerOptions marker;
    LatLng location;
    double lat;
    double lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent i =getIntent();
        String res_name = i.getExtras().getString("res_name_map");
        Restaurant(res_name);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        location = new LatLng(1.3649170000000002,103.82287200000002);

        marker = new MarkerOptions().title(res_name).position(new LatLng(lat, lon));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    public void Restaurant(String Name){
        switch(Name) {
            case "Ah Lin Restaurant":
                lat=1.35051;
                lon=103.848999;
                break;
            case "Wee Ban Hee":
                lat=1.43013;
                lon=103.83559;
                break;
            case "Tim Sum Here":
                lat=1.35982;
                lon=103.9892;
                break;
            case "Bah Ha Lim Restaurant":
                lat=1.30003;
                lon=103.84474;
                break;
            case "Gem Coffee and Tea":
                lat=1.43306021695327;
                lon=103.841649364872;
                break;
            case "Sushi Tori":
                lat=1.31762560629098;
                lon=103.893887524825;
                break;
            case "Ajisen":
                lat=1.3325523295069;
                lon=103.743262234833;
                break;
            case "Tako Japan":
                lat=1.30236932766648;
                lon=103.834980235031;
                break;
            case "Bigmama Korean Restaurant":
                lat=1.285250390473;
                lon=103.829252148941;
                break;
            case "Kim Dae Mun Korean Food":
                lat=1.30061437384276;
                lon=103.842228045431;
                break;
            case "Hanwoori Korean Restaurant":
                lat=1.36425807745069;
                lon=103.865178613801;
                break;
            case "Todamgol Restaurant":
                lat=1.27923534207055;
                lon=103.844082278761;
                break;
            case "Komala Vilas Restaurant":
                lat=1.30642411172001;
                lon=103.851950436372;
                break;
            case "Kailash Parbat Restaurant":
                lat=1.3084027270561;
                lon=103.851968750878;
                break;
            case "Greenleaf":
                lat=1.30708428628534;
                lon=103.853510891265;
                break;
            case "Annalakshmi Restaurant":
                lat=1.28815884200707;
                lon=103.843285807527;
                break;
            default:
                break;
        }
    }
}