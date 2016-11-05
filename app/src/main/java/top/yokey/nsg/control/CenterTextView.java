package top.yokey.nsg.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：图标文字居中的 TextView 仅支持 drawableLeft 记得设置 文字对齐 center|left
*
*/

public class CenterTextView extends TextView {

    public CenterTextView(Context context, AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
    }

    public CenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableLeft = drawables[0];
            if (drawableLeft != null) {
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawableLeft.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                canvas.translate((getWidth() - bodyWidth) / 2, 0);
            }
        }
        super.onDraw(canvas);
    }

}
