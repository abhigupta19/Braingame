package com.example.user.brain;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class ac extends AppCompatActivity {
    private Button b1;
    int inc,z;
    int score, total;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private CountDownTimer c;
    private TextView t2;
    private TextView t3, t4, t1,t6;
    private Random r;
    public void newlist()
    {    arr.clear();
        r = new Random();
        int a = r.nextInt(41);
        int b = r.nextInt(41);
        t2.setText("your score "+Integer.toString(a) + "+" + Integer.toString(b));
        inc = r.nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == inc) {
                z = inc;
                arr.add(a + b);
            } else {
                int in = r.nextInt(82);
                while (in == (a + b)) {
                    in = r.nextInt(82);
                }
                arr.add(in);
            }

        }

        b2.setText(Integer.toString(arr.get(0)));
        b4.setText(Integer.toString(arr.get(1)));
        b3.setText(Integer.toString(arr.get(2)));
        b5.setText(Integer.toString(arr.get(3)));
    }

    public void tryagain(View view) {
        b1.setVisibility(View.INVISIBLE);
        c.start();
        newlist();
        t6.setVisibility(View.INVISIBLE);


    }

    public void b2(View view) {
        if (view.getTag().toString().equals(Integer.toString(z))) {
            score++;
            total++;
            t4.setText("Right");
            t3.setText(Integer.toString(score)+"/"+Integer.toString(total));
        }
        else {
            total++;
            t4.setText("Wrong");
            t3.setText(Integer.toString(score)+"/"+Integer.toString(total));

        }
        newlist();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);
        t1 = (TextView) findViewById(R.id.textView);
        t3 = (TextView) findViewById(R.id.textView2);
        b1 = (Button) findViewById(R.id.button6);
        b1.setVisibility(View.INVISIBLE);

        t2 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView8);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        t6=(TextView)findViewById(R.id.textView9);
         newlist();
        c = new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long l) {
                t1.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                t1.setText("0");
                b1.setVisibility(View.VISIBLE);
                t6.setText(Integer.toString(score)+"/"+Integer.toString(total));
                

            }
        }.start();
    }
}

