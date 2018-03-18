package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint;
    
    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
        
        LinearGradient linearGradient = new LinearGradient(
                100, 100, 0, 0, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        
        int[] colors = {Color.RED, Color.BLUE, Color.GREEN};
        //0~1 坐标位置 0-0.2是RED，0.2-0.5BLUE, 0.5-1GREEN
        float[] positions = {0.2f, 0.5f, 1.0f};
        
        RadialGradient radialGradient = new RadialGradient(
                300, 300, 200, colors, positions, Shader.TileMode.CLAMP);
        
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
        mPaint.setShader(radialGradient);
        
    }
    
    public Practice02RadialGradientView(Context context) {
        super(context);
    }
    
    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        canvas.drawCircle(300, 300, 200, mPaint);
        
        mPaint.setAlpha(100);
        canvas.drawRect(0, 0, 600, 600, mPaint);
    }
    
}
