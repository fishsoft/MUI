package com.morse.mui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.morse.mlibrary.ui.ControllerView;

public class MainActivity extends AppCompatActivity {

    private ControllerView mRegionView;
    private ControllerView mRegionView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRegionView = findViewById(R.id.regionView);
        mRegionView1 = findViewById(R.id.regionView1);

        mRegionView.setListener(new ControllerView.RegionViewClickListener() {

            @Override
            public void clickTop() {
                Toast.makeText(MainActivity.this, "view clickTop", Toast.LENGTH_LONG).show();
            }

            @Override
            public void clickRight() {
                Toast.makeText(MainActivity.this, "view clickRight", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickLeft() {
                Toast.makeText(MainActivity.this, "view clickLeft", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickCenter() {
                Toast.makeText(MainActivity.this, "view clickCenter", 0).show();
            }

            @Override
            public void clickBottom() {
                Toast.makeText(MainActivity.this, "view clickBottom", 0).show();
            }
        });

        mRegionView1.setListener(new ControllerView.RegionViewClickListener() {

            @Override
            public void clickTop() {
                Toast.makeText(MainActivity.this, "view1 clickTop", 0).show();
            }

            @Override
            public void clickRight() {
                Toast.makeText(MainActivity.this, "view1 clickRight", 0).show();
            }

            @Override
            public void clickLeft() {
                Toast.makeText(MainActivity.this, "view1 clickLeft", 0).show();
            }

            @Override
            public void clickCenter() {
                Toast.makeText(MainActivity.this, "view1 clickCenter", 0).show();
            }

            @Override
            public void clickBottom() {
                Toast.makeText(MainActivity.this, "view1 clickBottom", 0).show();
            }
        });

    }
}
