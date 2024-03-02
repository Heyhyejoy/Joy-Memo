package com.example.seniorcapstone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Canvas;
import android.content.Intent;
import android.graphics.Paint;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private TextView name;


    class Point{
        float x;
        float y;
        boolean check;
        int color;

        public Point(float x, float y, boolean check, int color)
        {
            this.x = x;
            this.y = y;
            this.check = check;
            this.color = color;
        }
    }

    class MyView extends View
    {
        public MyView(Context context) {super(context);}

        @Override
        protected void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setStrokeWidth(15);
            for(int i=1 ; i<points.size() ; i++)
            {
                p.setColor(points.get(i).color);
                if (!points.get(i).check)
                    continue;
                canvas.drawLine(points.get(i-1).x,points.get(i-1).y,points.get(i).x,points.get(i).y,p);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    points.add(new Activity2.Point(x,y,false, color));
                case MotionEvent.ACTION_MOVE:
                    points.add(new Activity2.Point(x,y,true, color));
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            invalidate();
            return true;
        }
    }
    ArrayList<Activity2.Point> points = new ArrayList<Activity2.Point>();
    Button btnDrawRed, btnDrawBlue, btnDrawBlack, btnClear;
    LinearLayout drawLinear;
    int color = Color.BLACK;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);

            final Activity2.MyView m = new Activity2.MyView(this);

            findViewById(R.id.btnDrawRed).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    color = Color.RED;
                }
            });
            findViewById(R.id.btnDrawBlue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    color = Color.BLUE;
                }
            });
            findViewById(R.id.btnDrawBlack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    color = Color.BLACK;
                }
            });

            btnClear = findViewById(R.id.btnClear);
            btnClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    points.clear();
                    m.invalidate();
                }
            });
            drawLinear.addView(m);
    }
}