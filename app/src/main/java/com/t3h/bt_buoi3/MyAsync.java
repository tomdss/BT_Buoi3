package com.t3h.bt_buoi3;

import android.os.AsyncTask;
import android.widget.Toast;

public class MyAsync extends AsyncTask<Void,Integer,Void> {

    private int count;

    private Callback callback;


    public MyAsync(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        count=100;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        while (count>0){
            count--;
            if (isCancelled()){
//                return null;
                break;
            }
            publishProgress(count);
//            count--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values); //neu de super se run loop do in background+update
//        if(values[0].toString()==null)return;


        callback.Update(String.valueOf(values[0]));


    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        callback.Finish();
    }



    public interface Callback{
        void Finish();
        void Update(String number);
    }



}


