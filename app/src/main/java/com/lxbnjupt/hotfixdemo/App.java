package com.lxbnjupt.hotfixdemo;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

/**
 * Created by liuqiang 2020/10/22.
 */
public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {

            new HotFixUtils().doHotFix(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("tag", "app attachBaseContext");
    }
}
