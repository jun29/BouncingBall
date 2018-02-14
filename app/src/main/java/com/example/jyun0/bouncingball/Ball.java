package com.example.jyun0.bouncingball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball {
    private float ballRadius;
    private float ball_x = this.ballRadius + this.ballRadius/4;
    private float ball_y = this.ballRadius + this.ballRadius/2;
    private float ballSpeedX;
    private float ballSpeedY;
    private int alpha;
    private int red;
    private int green;
    private int blue;
    private RectF ballBounds;
    private Paint paint;

    public Ball (float ball_x, float ball_y, float radius, float ballSpeedX, float ballSpeedY, int alpha, int red, int green, int blue){

        this.ball_x = ball_x;
        this.ball_y = ball_y;
        this.ballRadius = radius;
        this.ballSpeedX = ballSpeedX;
        this.ballSpeedY = ballSpeedY;

        this.ballBounds = new RectF();
        this.paint = new Paint();

        this.setColor(alpha, red,green,blue);
    }

    public Ball(float ball_x, float ball_y, float radius,int alpha, int red, int green, int blue){
        this.ball_x = ball_x;
        this.ball_y = ball_y;
        this.ballRadius = radius;

        this.ballBounds = new RectF();
        this.paint = new Paint();

        this.setColor(alpha,red,green,blue);
    }

    public void setColor(int alpha, int red, int green, int blue) {
        this.paint.setARGB(alpha,red,green,blue);
    }

    public void setBallSpeed(float SpeedX, float SpeedY){
        this.ballSpeedX = SpeedX;
        this.ballSpeedY = SpeedY;
    }

    public void update(int xMin, int xMax,int yMin, int yMax){
        this.ball_x += this.ballSpeedX;
        this.ball_y += this.ballSpeedY;

        if(this.ball_x + this.ballRadius < xMax){
            this.ballSpeedX = - this.ballSpeedX;
            this.ballSpeedX = xMax - this.ballRadius;
        }
        else{
            if(this.ball_x + this.ballRadius < xMin){
                this.ballSpeedX = - this.ballSpeedX;
                this.ballSpeedX = xMin - this.ballRadius;
            }
        }
        if(this.ball_y + this.ballRadius < yMax){
            this.ballSpeedY = - this.ballSpeedY;
            this.ballSpeedY = yMax - this.ballRadius;
        }
        else{
            if(this.ball_y + this.ballRadius < yMin){
                this.ballSpeedY = - this.ballSpeedY;
                this.ballSpeedY = yMin - this.ballRadius;
            }
        }
    }

    public void draw(Canvas canvas){
        this.ballBounds.set(this.ball_x - ballRadius, this.ball_y - ballRadius, this.ball_x + ballRadius, this.ball_y + ballRadius);
        canvas.drawOval(this.ballBounds, this.paint);
    }
}
