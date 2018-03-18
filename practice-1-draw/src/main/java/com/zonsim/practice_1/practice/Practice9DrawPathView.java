package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zonsim.practice_1.R;

public class Practice9DrawPathView extends View {
    
    public Practice9DrawPathView(Context context) {
        super(context);
    }
    
    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        
        
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
        
        paint.setStyle(Paint.Style.STROKE);
        
        paint.setStrokeWidth(3);
        
        Path path = new Path();
        
        canvas.drawLine(100, 0, 100, 1000, paint);
        canvas.drawLine(200, 0, 200, 1000, paint);
        canvas.drawLine(300, 0, 300, 1000, paint);
        canvas.drawLine(400, 0, 400, 1000, paint);
        canvas.drawLine(500, 0, 500, 1000, paint);
        canvas.drawLine(600, 0, 600, 1000, paint);
        canvas.drawLine(700, 0, 700, 1000, paint);
        canvas.drawLine(800, 0, 800, 1000, paint);
        canvas.drawLine(900, 0, 900, 1000, paint);
        canvas.drawLine(1000, 0, 1000, 1000, paint);
        canvas.drawLine(0, 100, 2000, 100, paint);
        canvas.drawLine(0, 200, 2000, 200, paint);
        canvas.drawLine(0, 300, 2000, 300, paint);
        canvas.drawLine(0, 400, 2000, 400, paint);
        canvas.drawLine(0, 500, 2000, 500, paint);
        canvas.drawLine(0, 600, 2000, 600, paint);
        canvas.drawLine(0, 700, 2000, 700, paint);
        canvas.drawLine(0, 800, 2000, 800, paint);
        canvas.drawLine(0, 900, 2000, 900, paint);
        
        paint.setColor(Color.RED);
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, true);
        path.lineTo(400, 542);
        //path.lineTo((float) (300 - (100 * Math.sin(Math.PI / 4))), (float) (300 + (100 * Math.cos(Math.PI / 4))));
        path.close();
        
        
        System.out.println(Math.sin(Math.PI / 4));
        System.out.println(Math.cos(Math.PI / 4));
        System.out.println(Math.sin(Math.PI / 4) == Math.cos(Math.PI / 4));
        System.out.println(Math.sin(Math.PI / 4) * Math.cos(Math.PI / 4));
        
        canvas.drawPath(path, paint);
        
        RectF rectF = new RectF(100, 100, 200, 200);
        //Path方法一：addXxx()
        paint.setStyle(Paint.Style.FILL);
        Path path1 = new Path();
//        path1.setFillType(Path.FillType.EVEN_ODD);//默认
        path1.setFillType(Path.FillType.EVEN_ODD);
        path1.addCircle(100, 100, 100, Path.Direction.CW);
        path1.addCircle(200, 100, 100, Path.Direction.CW);
        path1.addCircle(150, 200, 100, Path.Direction.CW);
        
        canvas.drawPath(path1, paint);
        
        
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        
        //Path方法一：xxxTo()
        Path path2 = new Path();
        
        
        path2.moveTo(600, 600);
        path2.lineTo(700, 600);
//        path2.lineTo(200,0);
        
        path2.addArc(200, 400, 400, 600, -225, 225);
        //第三三个参数 forceMoveTo：true 将画笔抬起 重新画，false 将画笔拖过去接着画会有拖动痕迹
//        path2.arcTo(500, 400, 700, 600, -180, 225, true);
        path2.arcTo(500, 400, 700, 600, -180, 225, false);
        
        canvas.drawPath(path2, paint);
        
        //Path方法一：xxxTo()
        Path path3 = new Path();

//        path3.moveTo(600, 600);
//        path3.lineTo(700, 600);
//        path2.lineTo(200,0);
        
        path3.addArc(200, 500, 400, 700, -225, 225);
        //第三三个参数 forceMoveTo：true 将画笔抬起 重新画，false 将画笔拖过去接着画会有拖动痕迹
//        path2.arcTo(500, 400, 700, 600, -180, 225, true);
        path3.arcTo(500, 500, 700, 700, -180, 225, false);
        
        path3.lineTo(600, 800);
        path3.close();
        canvas.drawPath(path3, paint);
        
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        
        canvas.drawBitmap(bitmap, 700, 300, paint);
        Rect rect_src = new Rect(0, 0, 50, 50);
        paint.setColor(Color.BLUE);
        Rect rect_dst = new Rect(700, 0, 900, 200);
        canvas.drawRect(rect_src,paint);
        paint.setColor(Color.RED);
        canvas.drawRect(rect_dst,paint);
        
        canvas.drawBitmap(bitmap, rect_src, rect_dst,null);
    }
}
