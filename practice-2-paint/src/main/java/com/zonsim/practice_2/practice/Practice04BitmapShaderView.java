package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zonsim.practice_2.R;

public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    
        BitmapShader bitmapShader = new BitmapShader(
                BitmapFactory.decodeResource(getResources(), R.drawable.batman), 
                Shader.TileMode.REPEAT, 
                Shader.TileMode.MIRROR);
        paint.setShader(bitmapShader);
    
    }
    
    public Practice04BitmapShaderView(Context context) {
        super(context);
    }
    
    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        canvas.drawCircle(500, 400, 400, paint);
    }
}