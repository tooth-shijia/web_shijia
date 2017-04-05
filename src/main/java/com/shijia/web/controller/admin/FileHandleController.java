package com.shijia.web.controller.admin;

import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.FileUtils;
import com.shijia.web.common.utils.IconCompressUtils;
import com.shijia.web.common.utils.ImgCompress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YanxiSir
 * @since 17/3/21
 */
@Controller
@RequestMapping("/web/image")
public class FileHandleController {

    private static final Logger logger = LoggerFactory.getLogger(FileHandleController.class);

    //    @Value("${UploadImageCover_Product}")
    private String productCoverPath = "/Users/yanxi/shijia_web/image/cover/product/";

    //    @Value("${UploadImageCover_News}")
    private String newsCoverPath = "/Users/yanxi/shijia_web/image/cover/news/";

    private static final String PRODUCT_NAME_PREFFIX = "product_";
    private static final String NEWS_NAME_PREFFIX = "news_";

    private static final String IMAGE_SUFFIX = ".jpg";

    private static final int WIDTH = 540;
    private static final int HEGH = 347;

    @ResponseBody
    @RequestMapping(value = "/{type}/uploadImage", method = RequestMethod.POST)
    public Object uploadImage(@RequestParam("file") CommonsMultipartFile file, @PathVariable String type) {
        if (file == null || file.getSize() == 0L) {
            return new AjaxResult(false, "上传图片不能为空");
        }
        String path = "";
        String name = "";
        if ("product".equalsIgnoreCase(type)) {
            path = productCoverPath;
            name = PRODUCT_NAME_PREFFIX + System.currentTimeMillis() + IMAGE_SUFFIX;
        } else if ("news".equalsIgnoreCase(type)) {
            path = newsCoverPath;
            name = NEWS_NAME_PREFFIX + System.currentTimeMillis() + IMAGE_SUFFIX;
        }
        try {
            File imageFile = FileUtils.getFile(path, name);
            // 保存到本地临时目录
//            IconCompressUtils.compressAndCutCoverImg(file.getInputStream(), imageFile);
            ImgCompress.compress(file.getInputStream(), imageFile);
//            file.transferTo(imageFile);
        } catch (Exception e) {
            logger.error("上传图片失败", e);
        }

        String imageUrl = "/" + type + "/show/" + name;
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("imageUrl", imageUrl);
        return new AjaxResult(true, "", map);
    }

    @ResponseBody
    @RequestMapping("/{type}/show/{name}")
    public void showImage(HttpServletResponse response, @PathVariable String type, @PathVariable String name) {
        String path = "";
        if ("product".equalsIgnoreCase(type)) {
            path = productCoverPath;
        } else if ("news".equalsIgnoreCase(type)) {
            path = newsCoverPath;
        }
        if (name.indexOf(".") <= 0) {
            name += ".jpg";
        }
        try {
            File imageFile = FileUtils.getFile(path, name);
            FileInputStream fis = new FileInputStream(imageFile);
            int len;
            byte[] bt = new byte[1024];
            OutputStream os = response.getOutputStream();
            while ((len = fis.read(bt)) != -1) {
                os.write(bt, 0, len);
            }
            os.flush();
            os.close();
            fis.close();
        } catch (Exception e) {
            logger.error("获取图片失败", e);
        }
    }
}
