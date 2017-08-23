package com.ducnd.demoheart;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by ducnd on 8/21/17.
 */

public class Flower {
    private Bitmap bmFlower;
    private int x, y;
    private int maxXMove;
    private int maxYMove;
    private int updateX;
    private int updateY;


    public Flower(Bitmap bmFlower, int x, int y) {
        this.bmFlower = bmFlower;
        this.x = x;
        this.y = y;
        updateX = x;
        updateY = y;
    }

    public int getMaxXMove() {
        return maxXMove;
    }

    public void setMaxXMove(int maxXMove) {
        this.maxXMove = maxXMove;
    }

    public int getMaxYMove() {
        return maxYMove;
    }

    public void setMaxYMove(int maxYMove) {
        this.maxYMove = maxYMove;
    }

    public int getUpdateX() {
        return updateX;
    }

    public void setUpdateX(int updateX) {
        this.updateX = updateX;
    }

    public int getUpdateY() {
        return updateY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setUpdateY(int updateY) {
        this.updateY = updateY;
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmFlower, updateX, updateY, null);
    }
}
