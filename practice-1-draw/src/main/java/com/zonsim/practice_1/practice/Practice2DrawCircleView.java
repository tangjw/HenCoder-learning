package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.zonsim.practice_1.R;


public class Practice2DrawCircleView extends View {
    
    public Practice2DrawCircleView(Context context) {
        super(context);
    }
    
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

//        抗锯齿画笔
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint = new Paint();
        
        //添加 flag 如抗锯齿
        //paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        
        //设置 paint 抗锯齿
        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.FILL);
        //paint.setStyle(Paint.Style.STROKE);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        
        Paint paint1 = new Paint();
        //将 paint 的所有属性 设置给 paint1
        paint1.set(paint);
        paint1.setStyle(Paint.Style.FILL);
        
        
        canvas.drawCircle(300, 200, 160, paint);
        
        canvas.drawCircle(700, 200, 160, paint1);
        
        
        canvas.drawLine(300, 400, 600, 400, paint1);
//        paint.setStyle();
        
    
    }
}
