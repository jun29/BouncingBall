package com.example.jyun0.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;

public class BouncingBallView extends View {
    private int xMin = 0;
    private int xMax;
    private int yMin = 0;
    private int yMax;

    private ArrayList<Ball> balls;
    Ball testBall;

    //constractor
    public BouncingBallView(Context context){
        super(context);

        balls = new ArrayList<Ball>();

        for(int i = 0; i < 150; i++){
            balls.add(this.addBall());
        }
    }

    private Ball addBall() {
        Ball ball;

        int red = 5 + (int)(Math.random() * (255-5));
        int green = 5 + (int)(Math.random() * (255-5));
        int blue = 5 + (int)(Math.random() * (255-5));

        int velX = 1 + (int)(Math.random() * 20);
        int velY = 1 + (int)(Math.random() * 20);
        int radius = 2 + (int)(Math.random() * 50);

        ball = new Ball(0,0,radius,velX,velY,255,red,green,blue);

        return ball;
    }

    //Called back to draw the view. Also
    //

    //
    //
    // called by invalidate()
    @Override
    protected void onDraw(Canvas canvas){
        //draw the ball
        for(int i = 0; i < balls.size(); i++){
            balls.get(i).draw(canvas);
        }
        //update position of the ball, including collision detection and reaction
        for(int i = 0; i < balls.size(); i++){
            balls.get(i).update(xMin,xMax,yMin,yMax);
        }

        //delay
        try{
            Thread.sleep(20);
        }catch (InterruptedException e){
        }

        invalidate(); // Force a re-draw
    }

    //Called backed when the view is first created or its size change
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH){
        //set movement for the bounds for balls
        this.xMax = w -1;
        this.yMax = h -1;
    }
}
