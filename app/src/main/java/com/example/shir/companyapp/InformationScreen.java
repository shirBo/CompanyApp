package com.example.shir.companyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_screen);

        Button openUrlBTN = (Button) findViewById(R.id.urlBtn);
        openUrlBTN.setOnClickListener(this);
        Button sendEmailBTN = (Button) findViewById(R.id.mailBtn);
        sendEmailBTN.setOnClickListener(this);
        Button showAdressBTN = (Button) findViewById(R.id.gpsBtn);
        showAdressBTN.setOnClickListener(this);
        Button callNumBTN = (Button) findViewById(R.id.phoneBtn);
        callNumBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.urlBtn) {
            String myLink = "http://www.moranrubin.net/";

            Intent openUrlIntent = new Intent();

            openUrlIntent.setAction(Intent.ACTION_VIEW);
            openUrlIntent.setData(Uri.parse(myLink));

            startActivity(openUrlIntent);
        } else if (v.getId() == R.id.mailBtn) {
            Intent sendMailIntent = new Intent(Intent.ACTION_SEND);
            sendMailIntent.setType("text/html");
            sendMailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rubinmoran1@gmail.com"});
            startActivity(Intent.createChooser(sendMailIntent, "Send Email"));
        } else if (v.getId() == R.id.gpsBtn) {
            String adress = "geo: 32.300299,34.8560983 (Natania)";
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(adress));
            startActivity(intent);
        } else {
            Intent callConpany = new Intent(Intent.ACTION_DIAL);
            callConpany.setData(Uri.parse("tel:052-4677290"));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callConpany);
        }


    }
}
