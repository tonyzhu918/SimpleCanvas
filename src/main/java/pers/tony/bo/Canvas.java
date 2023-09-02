package pers.tony.bo;

import pers.tony.vo.Point;

public class Canvas {
    public static final int MIN_WIDTH = 1;
    public static final int MAX_WIDTH = 100;

    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 100;

    private int width;
    private int height;

    private boolean[][] pixes;

    private Canvas() {
    }

    public static Canvas createCanvas(int width, int height) {
        Canvas canvas = new Canvas();
        canvas.setBoundary(width, height);
        return canvas;
    }

    private void setBoundary(int width, int height) {
        checkBoundary(width, height);
        this.width = width;
        this.height = height;
        this.pixes = new boolean[height][width];
    }

    private void checkBoundary(int width, int height) throws IllegalArgumentException {
        if (width > MAX_WIDTH || width < MIN_WIDTH) {
            String widthOutOfBounds = String.format("width should be between %d and %d", MIN_WIDTH, MAX_WIDTH);
            throw new IllegalArgumentException(widthOutOfBounds);
        }
        if (height > MAX_HEIGHT || height < MIN_HEIGHT) {
            String heightOutOfBounds = String.format("height should be between %d and %d", MIN_HEIGHT, MAX_HEIGHT);
            throw new IllegalArgumentException(heightOutOfBounds);
        }
    }

    public void draw() {
        drawWholeLine();
        for (int i = 0; i < height; i++) {
            drawLineStart();
            for (int j = 0; j < width; j++) {
                if (pixes[i][j]) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            drawLineEnd();
        }
        drawWholeLine();
    }

    private void drawWholeLine() {
        for (int i = 0; i < width + 2; i++)
            System.out.print("-");
        System.out.println();
    }

    private void drawLineStart() {
        System.out.print("|");
    }

    private void drawLineEnd() {
        System.out.print("|");
        System.out.println();
    }

    public void setPix(Point p) {
        checkPos(p); // make sure (x,y) not exceeds canvas boundary
        pixes[p.getY() - 1][p.getX() - 1] = true;
    }

    public boolean getPix(Point p) {
        checkPos(p); // make sure (x,y) not exceeds canvas boundary
        return pixes[p.getY() - 1][p.getX() - 1];
    }

    public void checkPos(Point p) throws IllegalArgumentException {
        if (p.getX() > width || p.getX() < 1) {
            String xOutOfBounds = String.format("x should be between %d and %d", 1, width);
            throw new IllegalArgumentException(xOutOfBounds);
        }
        if (p.getY() > height || p.getY() < 1) {
            String yOutOfBounds = String.format("y should be between %d and %d", 1, height);
            throw new IllegalArgumentException(yOutOfBounds);
        }
    }
}
