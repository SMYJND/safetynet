//////package com.SmyJnd.safetynet;
//////
//////import androidx.appcompat.app.AppCompatActivity;
//////
//////import android.content.Intent;
//////import android.os.Bundle;
//////import android.view.View;
//////import android.widget.Button;
//////
//////public class MapActivity extends AppCompatActivity {
//////
//////    private Button locationButton;
//////
//////    @Override
//////    protected void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////        setContentView(R.layout.activity_map);
//////
//////        locationButton = findViewById(R.id.location_button);
//////        locationButton.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                Intent intent = new Intent(MapActivity.this, MapFragment.class);
//////                startActivity(intent);
//////            }
//////        });
//////    }
//////}
////
////
////package com.SmyJnd.safetynet;
////
////import android.Manifest;
////import android.content.pm.PackageManager;
////import android.location.Location;
////import android.location.LocationListener;
////import android.location.LocationManager;
////import android.os.Bundle;
////
////
////
////import androidx.core.app.ActivityCompat;
////import androidx.fragment.app.FragmentActivity;
////
////import com.google.android.gms.maps.CameraUpdateFactory;
////import com.google.android.gms.maps.GoogleMap;
////import com.google.android.gms.maps.OnMapReadyCallback;
////import com.google.android.gms.maps.SupportMapFragment;
////import com.google.android.gms.maps.model.LatLng;
////import com.google.android.gms.maps.model.MarkerOptions;
////
////public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
////
////    private GoogleMap mMap;
////    private LocationListener locationListener;
////    private LocationManager locationManager;
////
////    private final long MIN_TIME = 1000; // 1 sec
////    private final long MIN_DIST = 5; // 5 meters
////
////    private LatLng latLng;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_map);
////        // Obtain the SupportMapFragment and get notified when the map is ready to be used
////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
////        mapFragment.getMapAsync(this);
////
////        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
////        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
////
////
////    }
////
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////        mMap = googleMap;
////
////       LatLng sydney = new LatLng(-34, 151);
////       mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydeny"));
////       mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
////
////       locationListener = new LocationListener() {
////           @Override
////           public void onLocationChanged(Location location) {
////
////               try {
////                   latLng  = new LatLng (location.getLatitude(), location.getLongitude());
////                   mMap.addMarker(new MarkerOptions().position(latLng).title("My Position"));
////                   mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
////               }
////               catch (SecurityException e){
////                   e.printStackTrace();
////               }
////           }
////           @Override
////           public void onStatusChanged(String s, int i, Bundle bundle){
////
////           }
////           @Override
////           public void onProviderEnabled(String s){
////
////           }
////           @Override
////           public void onProviderDisabled(String s){
////
////           }
////       };
////
////       locationManager = (LocationManager) getSystemService(LOCALE_SERVICE);
////       try {
////           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME,MIN_DIST, locationListener);
////       }
////       catch (SecurityException e){
////           e.printStackTrace();
////       }
////    }
////}
//package com.SmyJnd.safetynet;
//
//import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
//import static android.Manifest.permission.ACCESS_FINE_LOCATION;
//
//import android.annotation.TargetApi;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import java.util.ArrayList;
//
//public class MapActivity extends AppCompatActivity {
//
//
//    private ArrayList permissionsToRequest;
//    private ArrayList permissionsRejected = new ArrayList();
//    private ArrayList permissions = new ArrayList();
//
//    private final static int ALL_PERMISSIONS_RESULT = 101;
//    LocationTrack locationTrack;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map);
//
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
//
//        permissionsToRequest = findUnAskedPermissions(permissions);
//        //get the permissions we have asked for before but are not granted..
//        //we will store this in a global list to access later.
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//
//            if (permissionsToRequest.size() > 0)
//                requestPermissions((String[]) permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
//        }
//
//
//        Button btn = (Button) findViewById(R.id.btn);
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                locationTrack = new LocationTrack(MapActivity.this);
//
//
//                if (locationTrack.canGetLocation()) {
//
//
//                    double longitude = locationTrack.getLongitude();
//                    double latitude = locationTrack.getLatitude();
//
//                    Toast.makeText(getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();
//                } else {
//
//                    locationTrack.showSettingsAlert();
//                }
//
//            }
//        });
//
//    }
//
//
//    private ArrayList findUnAskedPermissions(ArrayList wanted) {
//        ArrayList result = new ArrayList();
//
//        for (Object perm : wanted) {
//            if (!hasPermission(perm)) {
//                result.add(perm);
//            }
//        }
//
//        return result;
//    }
//
//    private boolean hasPermission(Object permission) {
//        if (canMakeSmores()) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                return (checkSelfPermission((String) permission) == PackageManager.PERMISSION_GRANTED);
//            }
//        }
//        return true;
//    }
//
//    private boolean canMakeSmores() {
//        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
//    }
//
//
//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//
//            case ALL_PERMISSIONS_RESULT:
//                for (Object perms : permissionsToRequest) {
//                    if (!hasPermission(perms)) {
//                        permissionsRejected.add(perms);
//                    }
//                }
//
//                if (permissionsRejected.size() > 0) {
//
//
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        if (shouldShowRequestPermissionRationale((String) permissionsRejected.get(0))) {
//                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
//                                    new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                requestPermissions((String[]) permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
//                                            }
//                                        }
//                                    });
//                            return;
//                        }
//                    }
//
//                }
//
//                break;
//        }
//
//    }
//
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(MapActivity.this)
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        locationTrack.stopListener();
//    }
//}