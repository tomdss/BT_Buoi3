package com.t3h.bt_buoi3;

import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MyAsync.Callback {
//    Handler nguoiduathu;

    private int a;
    private int b;
    private int c;
    private int result = 0;
//    private int timeC = 10;
    private int score;
    private int hs;
    private int checker;
    private Timer timer;
    private TextView tvScore;
    private TextView tvTime;
    private TextView tvHs;
    private TextView tvQuest;
    private ImageView imgTrue;
    private ImageView imgFalse;
    private MyAsync myAsync;

    private ProgressBar pbTime;




//    private ImageView imgPlay;
    private final String TAG = getClass().getSimpleName();
//    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().hide();
        setContentView(R.layout.activity_main);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        inits();
        load();

        imgTrue.setOnClickListener(this);
        imgFalse.setOnClickListener(this);
//        imgPlay.setOnClickListener(this);

//        nguoiduathu = new Handler(callback);
//
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                result++;
//                Log.d(TAG, "run: "+result);
//
//
//            }
//        },1000,3000);




    }

    public void inits() {
        tvScore = findViewById(R.id.tv_score);
        tvTime = findViewById(R.id.tv_time);
        tvHs = findViewById(R.id.tv_hs);
        tvQuest = findViewById(R.id.tv_quest);
        imgTrue = findViewById(R.id.img_true);
        imgFalse = findViewById(R.id.img_false);
        pbTime = findViewById(R.id.pb_time);
//        imgPlay = findViewById(R.id.img_play);


    }

    public void gameOver() {
//        countDownTimer.cancel();
        score=0;
        tvQuest.setText("Game Over");
        tvScore.setText("0");
//        Toast.makeText(this, ""+myAsync.isCancelled(), Toast.LENGTH_SHORT).show();
//        myAsync.cancel(true);
//        Toast.makeText(this, ""+myAsync.isCancelled(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, ""+myAsync.isCancelled(), Toast.LENGTH_SHORT).show();


    }

    public void load() {

        score++;
        tvScore.setText("" + score);

        if (score >= hs) {
            hs = score;
        }
        tvHs.setText("" + hs);
        Random rd = new Random();
        a = rd.nextInt(10) + 1;
        b = rd.nextInt(10) + 1;
//        c = rd.nextInt(21);
//        lbQuestion.setText(a +" + "+ b +" = "+ c);
        checker = rd.nextInt(6);
        if (checker % 2 == 0) {
            c = a + b;
        } else {
            c = rd.nextInt(23);
        }
        tvQuest.setText(a + "+" + b + "=" + c);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.img_true:

                //to do code
                if (a + b == c) {
//                    loadtime();
                    doTime();
                    load();

                } else {

                    gameOver();
                }

                break;

            case R.id.img_false:

                //to do code

                if (a + b != c) {
//                    loadtime();
                    doTime();
                    load();
                } else {

                    gameOver();
                }

                break;


            default:
                break;

        }
    }


    private void doTime(){
        myAsync = new MyAsync(this);
        myAsync.execute();
        pbTime.setProgress(100);
//        myAsync.cancel(false);
    }

    @Override
    public void Finish() {
        myAsync.cancel(false);

        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
        gameOver();


    }

    @Override
    public void Update(String number) {
        tvTime.setText(number);
        pbTime.setProgress(Integer.parseInt(number));

    }


//    Handler.Callback callback = new Handler.Callback(){
//        @Override
//        public boolean handleMessage(Message msg) {
//            Bundle nhannoidung = msg.getData();
//            String noidung = nhannoidung.getString("noidung");
//
//            return false;
//        }
//    };

//    public void loadtime() {
////        timeC = 10;
////
////         countDownTimer=new CountDownTimer(10000, 1000) {
////            @Override
////            public void onTick(long millisUntilFinished) {
////                    tvTime.setText(timeC+"");
////                    timeC--;
////
////            }
//
//            @Override
//            public void onFinish() {
//                gameOver();
//
//            }
//        }.start();
//
//
//    }




}

