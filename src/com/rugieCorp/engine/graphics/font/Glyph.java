package com.rugieCorp.engine.graphics.font;

/**
 * User: Adam Chlupacek
 * Date: 04/05/14
 * Time: 22:44
 * Package: com.rugieCorp.engine.graphics.font
 */
public class Glyph {

    private int x,y, xs, ys;

    private int offX, offY, advX;

    public Glyph(int x, int y, int xs, int ys, int offX, int offY, int advX) {
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.offX = offX;
        this.offY = offY;
        this.advX = advX;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXs() {
        return xs;
    }

    public int getYs() {
        return ys;
    }

    public int getOffX() {
        return offX;
    }

    public int getOffY() {
        return offY;
    }

    public int getAdvX() {
        return advX;
    }

    @Override
    public String toString() {
        return "Glyph{" +
                "x=" + x +
                ", y=" + y +
                ", xs=" + xs +
                ", ys=" + ys +
                ", offX=" + offX +
                ", offY=" + offY +
                ", advX=" + advX +
                '}';
    }
}
