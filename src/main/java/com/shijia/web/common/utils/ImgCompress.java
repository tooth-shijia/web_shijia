package com.shijia.web.common.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author YanxiSir
 * @since 17/4/5
 */
public class ImgCompress {

    private static final Logger logger = LoggerFactory.getLogger(ImgCompress.class);

    private static final int COVER_WIDTH = 540;
    private static final int COVER_HEGH = 347;

    public static void compress(InputStream is, File newFile) {
        try {
            Image img = ImageIO.read(is);
            int width = img.getWidth(null);
            int height = img.getHeight(null);
            resizeFix(img, height, width, COVER_WIDTH, COVER_HEGH, newFile);
        } catch (Exception e) {

        }
    }

    /**
     * 按照宽度还是高度进行压缩
     *
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public static void resizeFix(Image img, int height, int width, int w, int h, File newFile) throws IOException {
        if (height < h || width < w) {
            //扩大
            if (Double.compare((double) width / (double) height, (double) w / (double) h) < 0) {
                int newHeight = w * height / width;
                resize(img, w, newHeight, newFile);
            } else {
                int newWidth = h * width / height;
                resize(img, newWidth, h, newFile);
            }
            return;
        }
        //缩放
        if (Double.compare((double) width / (double) height, (double) w / (double) h) < 0) {
            resizeByWidth(img, height, width, w, newFile);
        } else {
            resizeByHeight(img, height, width, h, newFile);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     *
     * @param w int 新宽度
     */
    public static void resizeByWidth(Image img, int height, int width, int w, File newFile) throws IOException {
        int h = (int) (height * w / width);
        resize(img, w, h, newFile);
    }

    /**
     * 以高度为基准，等比例缩放图片
     *
     * @param h int 新高度
     */
    public static void resizeByHeight(Image img, int height, int width, int h, File newFile) throws IOException {
        int w = (int) (width * h / height);
        resize(img, w, h, newFile);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     *
     * @param w int 新宽度
     * @param h int 新高度
     */
    public static void resize(Image img, int w, int h, File newFile) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        FileOutputStream out = new FileOutputStream(newFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();

        if (w == COVER_WIDTH && h > COVER_HEGH) {
            int offsetHeight = (h - COVER_HEGH) / 2;
            cut(newFile, 0, offsetHeight);
        } else if (h == COVER_HEGH && w > COVER_WIDTH) {
            int offsetWidth = (w - COVER_WIDTH) / 2;
            cut(newFile, offsetWidth, 0);
        }
    }

    public static void cut(File newImg, int offsetWidth, int offsetHeight) throws IOException {
        // 读取图片文件
        InputStream is = new FileInputStream(newImg);

        // 获取文件格式
        String ext = "jpg";

        // ImageReader声称能够解码指定格式
        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(ext);
        ImageReader reader = it.next();

        // 获取图片流
        ImageInputStream iis = ImageIO.createImageInputStream(is);

        // 输入源中的图像将只按顺序读取
        reader.setInput(iis, true);

        // 描述如何对流进行解码
        ImageReadParam param = reader.getDefaultReadParam();

        // 图片裁剪区域
        Rectangle rect = new Rectangle(offsetWidth, offsetHeight, COVER_WIDTH, COVER_HEGH);

        // 提供一个 BufferedImage，将其用作解码像素数据的目标
        param.setSourceRegion(rect);

        // 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象
        BufferedImage bii = reader.read(0, param);

        ImageIO.write(bii, ext, newImg);
    }
}
