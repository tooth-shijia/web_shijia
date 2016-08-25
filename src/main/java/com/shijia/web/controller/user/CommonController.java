package com.shijia.web.controller.user;

import com.shijia.web.common.utils.DrawYzmUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Controller
public class CommonController {

    @RequestMapping(value = "/login/vcode")
    public void loginVCode(HttpServletRequest req, HttpServletResponse resp) {
        try {

            BufferedImage img = new BufferedImage(120, 40, BufferedImage.TYPE_INT_ARGB_PRE);
            DrawYzmUtils draw = new DrawYzmUtils(120, 40);
            String code = draw.FormatYzmImage(img);
            req.getSession().setAttribute("checkcode", code);
            OutputStream out = resp.getOutputStream();
            ImageIO.write(img, "png", out);
            try {
                out.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out.close();
            }
        } catch (Exception e) {

        }
    }
}
