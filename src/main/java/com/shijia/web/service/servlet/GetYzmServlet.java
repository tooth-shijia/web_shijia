package com.shijia.web.service.servlet;

import com.shijia.web.common.utils.DrawYzmUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Tangxinqi on 2016/6/10.
 */
public class GetYzmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        BufferedImage img = new BufferedImage(120,40,BufferedImage.TYPE_INT_ARGB_PRE);
        DrawYzmUtils draw = new DrawYzmUtils(120,40);
        String code  = draw.FormatYzmImage(img);
        req.getSession().setAttribute("checkcode", code);
        OutputStream out = resp.getOutputStream();
        ImageIO.write(img, "png",out);
        try{
            out.flush();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
