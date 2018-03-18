package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice03SweepGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
    
        SweepGradient sweepGradient = new SweepGradient(300, 300, Color.RED, Color.BLUE);
    
        int[] colors = {Color.RED, Color.BLUE, Color.GREEN};
        //0~1 坐标位置 0-0.2是RED，0.2-0.5BLUE, 0.5-1GREEN
        float[] positions = {0.2f, 0.5f, 1.0f};
    
        SweepGradient sweepGradient1 = new SweepGradient(300, 300, colors, positions);
    
    
        paint.setShader(sweepGradient1);
    }
    
    public Practice03SweepGradientView(Context context) {
        super(context);
    }
    
    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        canvas.drawCircle(300, 300, 200, paint);
        paint.setAlpha(100);
        canvas.drawRect(0, 0, 600, 600, paint);
    
        paint.setAlpha(255);
        paint.setStrokeWidth(30);
        canvas.drawLine(600,600,800,500,paint);
    }
}
