package com.shijia.web.common.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Tangxinqi on 2016/6/10.
 */
public class DrawYzmUtils {
    private final String baseNumLetter = "0123456789abcdefghijklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
    private int WIDTH;
    private int HEIGHT;
    private final Color[] colors = {Color.blue,Color.green,Color.PINK,Color.BLACK,Color.YELLOW,Color.RED,Color.MAGENTA,Color.ORANGE};


    public DrawYzmUtils(int width,int height){
        this.WIDTH=width;
        this.HEIGHT=height;
    }

    public String FormatYzmImage(BufferedImage image){
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        graphics.setColor(new Color(0.29803923f, 0.7607843f, 0.76862746f, 0.0f));
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        graphics.setColor(new Color(255,255,255));
        graphics.setFont(new Font("宋体", Font.BOLD, 26));

        StringBuffer sb = new StringBuffer();
        int x = 5;
        String ch ="";
        for (int i = 0; i < 4; i++) {
            int degree = new Random().nextInt() % 30;
            ch = baseNumLetter.charAt(new Random().nextInt(baseNumLetter.length()-1)) + "";
            sb.append(ch);
            graphics.rotate(degree * Math.PI / 180, x, 25);
            graphics.drawString(ch, x, 25);
            graphics.rotate(-degree * Math.PI / 180, x, 25);
            x += 30;
        }


        for (int i = 0; i < 7; i++) {

            int j = new Random().nextInt(7);
            Color color = colors[j];
            graphics.setColor(color);
            int x1 = new Random().nextInt(WIDTH/2);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            if(x2<WIDTH/2){
                x2 += x2+WIDTH/2;
            }
            int y2 = new Random().nextInt(HEIGHT);
            graphics.drawLine(x1, y1, x2, y2);
        }



        graphics.dispose();
        return sb.toString();
    }
}
