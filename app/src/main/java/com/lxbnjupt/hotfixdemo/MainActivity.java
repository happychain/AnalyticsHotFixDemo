package com.lxbnjupt.hotfixdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by liuqiang 2020/10/22.
 */
public class MainActivity extends AppCompatActivity {

    private static final String DEX_DIR = "patch";
    private Button btnRun;
    private Button btnRun2;
    private Button btnRepair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRun = (Button) findViewById(R.id.btn_run);
        btnRun2 = (Button) findViewById(R.id.btn_run2);
        btnRepair = (Button) findViewById(R.id.btn_repair);

        init();
        setOnClickListener();
    }

    private void init() {
        // 补丁存放目录为 /storage/emulated/0/Android/data/com.lxbnjupt.hotfixdemo/files/patch
        File patchDir = new File(this.getExternalFilesDir(null), DEX_DIR);
        if (!patchDir.exists()) {
            patchDir.mkdirs();
        }
    }

    private void setOnClickListener() {
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BugTest().getBug();
            }
        });

        btnRun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Bug1Test().getBug();
            }
        });

    }

}
