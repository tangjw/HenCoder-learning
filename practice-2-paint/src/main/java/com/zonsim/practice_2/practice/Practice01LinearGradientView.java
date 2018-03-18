package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    
    private Paint mPaint;

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    
        LinearGradient linearGradient = new LinearGradient(
                100, 100, 0, 0, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
        mPaint.setShader(linearGradient);
        
    }
    
    public Practice01LinearGradientView(Context context) {
        super(context);
    }
    
    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, mPaint);
        
        mPaint.setAlpha(100);
        canvas.drawRect(0, 0, 600,600, mPaint);
    }
}