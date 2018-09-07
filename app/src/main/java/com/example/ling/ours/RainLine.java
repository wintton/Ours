package com.example.ling.ours;

import java.util.Random;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class RainLine {
    private Random random = new Random();

    private int startX;
    private int startY;
    private int stopX;
    private int stopY;

    private int deltaX = 20;
    private int deltaY = 30;

    private int maxX; //x最大范围
    private int maxY; //y最大范围


    public RainLine(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        initRandom();
    }

    public void initRandom() {

        startX = random.nextInt(maxX);
        startY = random.nextInt(maxY);

        stopX = startX + deltaX;
        stopY = startY + deltaY;
    }

    /**
     * 随机初始化
     */
    public void resetRandom() {
        if (random.nextBoolean()) { //随机 true, 雨点从x轴出来
            startY = 0;
            startX = random.nextInt(maxX);
        } else { //随机 false，雨点从y轴出来
            startX = 0;
            startY = random.nextInt(maxY);
        }
        stopX = startX + deltaX;
        stopY = startY + deltaY;
    }
    /**
     * 下雨
     */
    public void rain() {
        startX += deltaX;
        stopX += deltaX;
        startY += deltaY;
        stopY += deltaY;
    }

    /**
     * @return 是否出界
     */
    public boolean outOfBounds() {
        if (getStartY() >= maxY || getStartX() >= maxX) {
            resetRandom();
            return true;
        }
        return false;
    }

    public int getStartY() {
        return startY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStopX() {
        return stopX;
    }

    public int getStopY() {
        return stopY;
    }
}
