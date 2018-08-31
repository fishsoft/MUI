package com.morse.mlibrary.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BieChat extends View {

    private Paint mPaint;
    private Paint mTextPaint;
    private List<Model> mModel = new ArrayList<>();
    private String title = "饼图";
    private int radius = 150;//半径

    private int selectedOffset = 20;

    //    private int lineLength1 = 50;
//    private int lineLength2 = 80;
    private int textOffset = 20;

    {
        mModel.add(new Model("Lollipop", 50, Color.RED));
        mModel.add(new Model("Marshmallow", 30, Color.YELLOW));
        mModel.add(new Model("Froyo", 10, Color.GREEN));
        mModel.add(new Model("Gingerbread", 5, Color.BLUE));
        mModel.add(new Model("Ice Cream Sandwich", 15, Color.CYAN));
        mModel.add(new Model("Jelly Bean", 35, Color.MAGENTA));
        mModel.add(new Model("Kitkat", 40, Color.LTGRAY));
    }

    public BieChat(Context context) {
        this(context, null);
    }

    public BieChat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BieChat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化
     *
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextAlign(Paint.Align.CENTER);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setColor(Color.GREEN);
        mTextPaint.setStyle(Paint.Style.STROKE);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(300, 300, 200, mPaint);//画圆
//        canvas.drawRect(100,100,500,500,mPaint);//画矩形
//        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆点
//        mPaint.setStrokeCap(Paint.Cap.BUTT);//矩形，默认值
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);//矩形，默认值
//        canvas.drawPoint(100,100,mPaint);//画点
//        canvas.drawPoint(100,500,mPaint);//画点
//        canvas.drawPoint(500,100,mPaint);//画点
//        canvas.drawPoint(500,500,mPaint);//画点
//        canvas.drawOval(100, 100, 500, 300, mPaint);//画椭圆
//        float[] points={100,100,200,300,500,200};
//        canvas.drawLines(points, mPaint);
//        canvas.drawRoundRect(100,100,500,300,20,20,mPaint);//绘制圆角矩形
//        canvas.drawArc(200,100,800,500,-110,100,true,mPaint);//绘制扇形
//        canvas.drawArc(200,100,800,500,20,140,false,mPaint);//绘制弧形
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(200,100,800,500,180,60,false,mPaint);//绘制不封口的弧形

        //绘制一个爱心
//        mPath.addArc(200, 200, 400, 400, -255, 255);
//        mPath.arcTo(400, 200, 600, 400, -180, 255, false);
//        mPath.lineTo(400, 542);
//        canvas.drawPath(mPath, mPaint);

//        mPath.addCircle(300,300,200,Path.Direction.CW);
//        canvas.drawPath(mPath,mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.moveTo(100,300);//移动到100，300的位置
//        mPath.lineTo(100,100);//由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        mPath.rLineTo(100,0);// 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
//        mPath.quadTo(200,100,250,70);//二次贝塞尔曲线
//        mPath.cubicTo(250,70,300,100,200,500);//三次贝塞尔曲线
//        mPath.close();
//        canvas.drawPath(mPath,mPaint);

//        mPath.moveTo(100,500);
//        mPath.lineTo(200,600);
//        mPath.arcTo(300,700,500,800,-90,90,false);
//        canvas.drawPath(mPath,mPaint);

//        mPath.moveTo(100,100);
//        mPath.lineTo(200,100);
//        mPath.lineTo(150,150);
//        canvas.drawPath(mPath,mPaint);

//        mPath.setFillType(Path.FillType.WINDING);
//        mPath.addCircle(300,300,200,Path.Direction.CW);
//        mPath.addCircle(500,300,200,Path.Direction.CW);
//        canvas.drawPath(mPath,mPaint);

        int x = getWidth();
        int y = getHeight();

        //绘制标题

        canvas.drawText(title, x / 2, y - 30, mPaint);//标题距离底部40px

        float startAngle = -180;
        float halfAngle = 0;

        boolean isSelected;

        float sum = 0;
        for (Model model : mModel) {
            sum += model.getNum();
        }

        for (int i = 0; i < mModel.size(); i++) {
            Model model = mModel.get(i);

            isSelected = i == 0 ? true : false;

            int offset = isSelected ? selectedOffset : 0;

            float scale = model.getNum() / sum;
            float angle = scale * 360;

            //圆弧中心的角度
            halfAngle = startAngle + angle / 2;
            //圆弧中心的位置
            float halfX = (float) (x / 2 + (radius + offset) * Math.cos(halfAngle * Math.PI / 180));
            float halfY = (float) (y / 2 + (radius + offset) * Math.sin(halfAngle * Math.PI / 180));
            //圆弧引出的线1的结束点
            float line1EndX = (float) (x / 2 + (radius + offset) * Math.cos(halfAngle * Math.PI / 180));
            float line1EndY = (float) (y / 2 + (radius + offset) * Math.sin(halfAngle * Math.PI) / 180);
            //圆弧引出的线2的结束点
            float line2EndX = Math.abs(halfAngle) <= 90 ? line1EndX : line1EndX;
            float line2EndY = line1EndY;
            //文字中心点
            float textX = Math.abs(halfAngle) <= 90 ? line2EndX + textOffset : line2EndX - textOffset;
            float textY = line1EndY;

            //椭圆四边的位置
            float l = (float) (x / 2 - radius + offset * Math.cos(halfAngle * Math.PI / 180));
            float r = (float) (x / 2 + radius + offset * Math.cos(halfAngle * Math.PI / 180));
            float t = (float) (y / 2 - radius + offset * Math.sin(halfAngle * Math.PI / 180));
            float b = (float) (y / 2 + radius + offset * Math.sin(halfAngle * Math.PI / 180));

            mPaint.setColor(model.getColor());
            canvas.drawArc(l, t, r, b, startAngle, angle, true, mPaint);//绘制扇形

            //绘制线和文字
            Path path = new Path();
            path.moveTo(halfX, halfY);
            path.lineTo(line1EndX, line1EndY);
            path.lineTo(line2EndX, line2EndY);
            canvas.drawPath(path, mPaint);
            mTextPaint.setTextAlign(Math.abs(halfAngle) <= 90 ? Paint.Align.LEFT : Paint.Align.RIGHT);
            canvas.drawText(model.getTip(), textX, textY, mTextPaint);

            startAngle += angle;
        }
    }

    class Model {
        int num;
        String tip;
        int color;

        public Model(String tip, int num) {
            this.num = num;
            this.tip = tip;
        }

        public Model(String tip, int num, int color) {
            this.num = num;
            this.tip = tip;
            this.color = color;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }
    }
}
