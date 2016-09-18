package com.example.guillermo.popularmovies.backgroundtasks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by guillermo on 18/09/16.
 */
public class CheckConnectionTask implements Runnable {

    private Context context;

    private boolean flag;

    public CheckConnectionTask(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true){
            if (isNetworkConectivityOnline()){
                if (!flag){
                    flag = true;
                    //fetchtask
                }
            }else
                flag= false;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isNetworkConectivityOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
