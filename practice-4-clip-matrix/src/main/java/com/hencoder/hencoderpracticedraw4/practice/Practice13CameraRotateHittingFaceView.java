package com.hencoder.hencoderpracticedraw4.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice13CameraRotateHittingFaceView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point = new Point(200, 50);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 360);
    
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 2, bitmap.getHeight() * 2, true);
        bitmap.recycle();
        bitmap = scaledBitmap;
        
        animator.setDuration(2000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
    
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    
        float newZ = -displayMetrics.density * 5;
    
        System.out.println("density newZ: "+newZ);
        
        camera.setLocation(0,0,newZ);
    }
    
    public Practice13CameraRotateHittingFaceView(Context context) {
        super(context);
    }
    
    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }
    
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }
    

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
    
        paint.setColor(Color.parseColor("#6CCCCCCC"));
        canvas.drawRect(point.x,point.y,point.x+bitmapWidth,point.y+bitmapHeight,paint);
        paint.reset();
        
        int centerX = point.x + bitmapWidth / 2;
        int centerY = point.y + bitmapHeight / 2;
        
        camera.save();
        matrix.reset();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point.x, point.y, paint);
        canvas.restore();
    }
}