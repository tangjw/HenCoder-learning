package com.zonsim.practice_2.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    {
        paint.setShader(new LinearGradient(0, 0, 1080, 1080, Color.parseColor("#64b9ff"),
                Color.parseColor("#7593ff"), Shader.TileMode.CLAMP));
    }

    public Sample01LinearGradientView(Context context) {
        super(context);
    }

    public Sample01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    
        canvas.drawRect(0, 0, 1080, 1080, paint);
    }
}
