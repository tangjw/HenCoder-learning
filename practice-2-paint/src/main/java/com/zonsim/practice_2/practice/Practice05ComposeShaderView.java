package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zonsim.practice_2.R;

public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        
        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
        
        BitmapShader bitmapShader1 = new BitmapShader(
                BitmapFactory.decodeResource(getResources(), R.drawable.batman),//目标图像
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        
        BitmapShader bitmapShader2 = new BitmapShader(
                BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo),//源图像
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        
        ComposeShader composeShader = new ComposeShader(bitmapShader1, bitmapShader2,
//https://developer.android.com/reference/android/graphics/PorterDuff.Mode.html
//                PorterDuff.Mode.SRC //只显示源图像
//                PorterDuff.Mode.SRC_OVER //源图像压在目标图像上，全部显示
//                PorterDuff.Mode.SRC_IN //源图像与目标图像交叉部分显示源图像内容
//                PorterDuff.Mode.SRC_ATOP //源图像与目标图像交叉部分显示在目标图像上，目标图像也显示
//                PorterDuff.Mode.SRC_OUT //只显示源图像与目标图像没有交叉部分
//                PorterDuff.Mode.DST //只显示目标图像
//                PorterDuff.Mode.DST_OVER //目标图像压在源图像像上，全部显示
//                PorterDuff.Mode.DST_IN //目标图像与源图像交叉部分显示目标图像内容
//                PorterDuff.Mode.DST_ATOP 
//                PorterDuff.Mode.DST_OUT 
//                PorterDuff.Mode.XOR
//                PorterDuff.Mode.CLEAR



//                PorterDuff.Mode.DARKEN
//                PorterDuff.Mode.LIGHTEN
//                PorterDuff.Mode.MULTIPLY
//                PorterDuff.Mode.SCREEN
                PorterDuff.Mode.OVERLAY
                
        
        );
        
        paint.setShader(composeShader);
        
        
    }
    
    public Practice05ComposeShaderView(Context context) {
        super(context);
    }
    
    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        canvas.drawCircle(200, 200, 200, paint);
    }
}
