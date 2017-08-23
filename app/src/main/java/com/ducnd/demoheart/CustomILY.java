package com.ducnd.demoheart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ducnd on 8/21/17.
 */

public class CustomILY extends View {
    private static final String TAG = CustomILY.class.getSimpleName();
    private List<Flower> flowers;
    private int height = -1;
    private RunThread runThread;
    private int padding;

    public CustomILY(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inits();
    }

    public CustomILY(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits();
    }

    private void inits() {
        flowers = new ArrayList<>();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w <= 0 && h <= 0) {
            return;
        }
        initsFlowers(w, h);
    }

    private void initsFlowers(int width, int height) {
        if (flowers.size() > 0) {
            flowers.clear();
        }
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.flower1);
        Bitmap bm1 = Bitmap.createBitmap(bm.getWidth() * 2 / 3, bm.getHeight() * 2 / 3, Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(bm1);
        canvas1.drawBitmap(bm, new Rect(0, 0, bm.getWidth(), bm.getHeight()), new Rect(0, 0, bm1.getWidth(), bm1.getHeight()), null);
        bm.recycle();

        int sizeText = width / 3;
        int sizeFlower = bm.getWidth() * 3 / 2;
        int number1 = sizeText / sizeFlower;

        List<Bitmap> bms = new ArrayList<>();
        bms.add(bm1);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.flower2);
        bm1 = Bitmap.createBitmap(bm.getWidth() * 2 / 3, bm.getHeight() * 2 / 3, Bitmap.Config.ARGB_8888);
        canvas1 = new Canvas(bm1);
        canvas1.drawBitmap(bm, new Rect(0, 0, bm.getWidth(), bm.getHeight()), new Rect(0, 0, bm1.getWidth(), bm1.getHeight()), null);
        bm.recycle();
        bms.add(bm1);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.flower3);
        bm1 = Bitmap.createBitmap(bm.getWidth() * 2 / 3, bm.getHeight() * 2 / 3, Bitmap.Config.ARGB_8888);
        canvas1 = new Canvas(bm1);
        canvas1.drawBitmap(bm, new Rect(0, 0, bm.getWidth(), bm.getHeight()), new Rect(0, 0, bm1.getWidth(), bm1.getHeight()), null);
        bm.recycle();
        bms.add(bm1);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.flower4);
        bm1 = Bitmap.createBitmap(bm.getWidth() * 2 / 3, bm.getHeight() * 2 / 3, Bitmap.Config.ARGB_8888);
        canvas1 = new Canvas(bm1);
        canvas1.drawBitmap(bm, new Rect(0, 0, bm.getWidth(), bm.getHeight()), new Rect(0, 0, bm1.getWidth(), bm1.getHeight()), null);
        bm.recycle();
        bms.add(bm1);

        Random rd = new Random();

        if (number1 % 2 == 0) {
            number1 = number1 + 1;
        }

        int space = 100;

        //i
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), width / 3 + sizeFlower * i, padding));
        }
        for (int i = 1; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), width / 3 + number1 * sizeFlower / 2, i * sizeFlower + padding));
        }
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), width / 3 + sizeFlower * i, sizeText + padding));
        }

        //v
//        for (int i = 0; i < number1; i++) {
//            int y = i * sizeFlower + number1 * sizeFlower + space;
//            int x = i * sizeFlower / 2 + sizeText;
//            flowers.add(new Flower(bms.get(rd.nextInt(4)), x, y + padding));
//        }
//
//        for (int i = 0; i < number1; i++) {
//            int y = i * sizeFlower + number1 * sizeFlower + space;
//            int x = sizeText * 2 - i * sizeFlower / 2;
//            flowers.add(new Flower(bms.get(rd.nextInt(4)), x, y + padding));
//        }


        int startLoveX = 200;
        int endLoveX = width - 200;
        int spaceLetter = 40;
        int sizeLetter = (endLoveX - startLoveX - spaceLetter * 3) / 4;
        int numberWidth = sizeLetter / sizeFlower;
        //l
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX, i * sizeFlower + number1 * sizeFlower + space + padding));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + i * sizeFlower, number1 * sizeFlower * 2 + space + padding));
        }
        //o
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter + spaceLetter, i * sizeFlower + number1 * sizeFlower + space + padding));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + i * sizeFlower + sizeLetter + spaceLetter, number1 * sizeFlower * 2 + space + padding));
        }

        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter + spaceLetter + sizeLetter - sizeFlower * 2, i * sizeFlower + number1 * sizeFlower + space + padding));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + i * sizeFlower + sizeLetter + spaceLetter, number1 * sizeFlower + space + padding));
        }

        //v
        float arcCotag = (float) sizeLetter / (number1 * sizeFlower * 2);
        for (int i = 0; i < number1; i++) {
            int y = i * sizeFlower;
            int x = (int) (arcCotag * y);
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + spaceLetter * 2 + sizeLetter * 2 + x,
                    i * sizeFlower + number1 * sizeFlower + space + padding));
        }
        for (int i = 0; i < number1+1; i++) {
            int y = i * sizeFlower;
            int x = sizeLetter - (int) (arcCotag * y);
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + spaceLetter * 2 + sizeLetter * 2 + x,
                    i * sizeFlower + number1 * sizeFlower + space + padding));
        }

        //e
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter*3 + spaceLetter * 3, i * sizeFlower + number1 * sizeFlower + space + padding));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter*3 + spaceLetter * 3 + i * sizeFlower , number1 * sizeFlower * 2 + space + padding));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter*3 + spaceLetter * 3 + i * sizeFlower , number1 * sizeFlower*3/2  + space + padding ));
        }
        for (int i = 0; i < numberWidth; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), startLoveX + sizeLetter*3 + spaceLetter * 3 + i * sizeFlower , number1 * sizeFlower  + space + padding ));
        }

        //u
        for (int i = 0; i < number1; i++) {
            int y = number1 * sizeFlower * 2 + space * 2 + i * sizeFlower;
            flowers.add(new Flower(bms.get(rd.nextInt(4)), sizeText, y + padding));
        }

        int y = number1 * sizeFlower * 2 + space * 2 + sizeFlower * number1;
        for (int i = 0; i < number1; i++) {
            flowers.add(new Flower(bms.get(rd.nextInt(4)), sizeText + i * sizeFlower, y + padding));
        }

        for (int i = 0; i < number1; i++) {
            y = number1 * sizeFlower * 2 + space * 2 + i * sizeFlower;
            flowers.add(new Flower(bms.get(rd.nextInt(4)), sizeText * 2 - sizeFlower / 2, y + padding));
        }
        Log.d(TAG, "initsFlowers........");

        if (runThread != null) {
            runThread.isRunning = false;
        }
        runThread = new RunThread();
        runThread.isRunning = true;
        runThread.isRunningResume = true;
        runThread.start();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.flower1);
        Bitmap bm1 = Bitmap.createBitmap(bm.getWidth() * 2 / 3, bm.getHeight() * 2 / 3, Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(bm1);
        canvas1.drawBitmap(bm, new Rect(0, 0, bm.getWidth(), bm.getHeight()), new Rect(0, 0, bm1.getWidth(), bm1.getHeight()), null);
        bm.recycle();


        int sizeText = width / 3;
        int sizeFlower = bm.getWidth() * 3 / 2;
        int number1 = sizeText / sizeFlower;

        int currentHeight = number1 * sizeFlower * 2 + 100 * 2 + sizeFlower * number1 + sizeFlower;
        padding = (height - currentHeight) / 2;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow........");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Flower flower : flowers) {
            flower.draw(canvas);
        }
    }

    public void onResume() {
        if (flowers != null && flowers.size() > 0) {
            if (runThread != null) {
                runThread.isRunningResume = true;
            }
        }
    }

    public void onPause() {
        if (flowers != null && flowers.size() > 0) {
            if (runThread != null) {
                runThread.isRunningResume = false;
            }
        }
    }

    private class RunThread extends Thread {
        private boolean isRunning;
        private boolean isRunningResume;

        @Override
        public void run() {
            Random rd = new Random();
            while (isRunning) {
                SystemClock.sleep(3000);
                if (!isRunning) {
                    break;
                }
                for (Flower flower : flowers) {
                    int maxX = rd.nextInt(600) - 300;
                    int maxY = rd.nextInt(600) - 300;
                    flower.setMaxXMove(maxX);
                    flower.setMaxYMove(maxY);
                }

                for (int i = 0; i < 800; i++) {
                    SystemClock.sleep(9);
                    if (!isRunning) {
                        break;
                    }
                    while (!isRunningResume) {
                        SystemClock.sleep(100);
                        if (!isRunning) {
                            break;
                        }
                    }
                    for (Flower flower : flowers) {
                        int detalX = flower.getMaxXMove() * i / 800;
                        int detalY = flower.getMaxYMove() * i / 800;
                        flower.setUpdateX(flower.getX() + detalX);
                        flower.setUpdateY(flower.getY() + detalY);
                    }
                    postInvalidate();
                }

                for (int i = 799; i >= 0; i--) {
                    SystemClock.sleep(9);
                    if (!isRunning) {
                        break;
                    }
                    while (!isRunningResume) {
                        SystemClock.sleep(100);
                        if (!isRunning) {
                            break;
                        }
                    }
                    for (Flower flower : flowers) {
                        int detalX = flower.getMaxXMove() * i / 800;
                        int detalY = flower.getMaxYMove() * i / 800;
                        flower.setUpdateX(flower.getX() + detalX);
                        flower.setUpdateY(flower.getY() + detalY);
                    }
                    postInvalidate();
                }
            }
        }

    }

    @Override
    protected void onDetachedFromWindow() {
        if (runThread != null) {
            runThread.isRunning = false;
            runThread = null;
        }
        super.onDetachedFromWindow();
    }
}
