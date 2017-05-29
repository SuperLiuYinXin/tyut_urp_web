package com.liuyinxin.grade.utils.http;

import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.dto.Captcha;
import com.liuyinxin.grade.exception.UpLoadFileException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BufferedHeader;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 验证码工具
 * @Author LiuYinXin
 * Created at 2017/5/25.18:01.
 */
public class CaptchaUtils {

    private static final Logger log = Logger.getLogger(CaptchaUtils.class.getName());


    /**
     * 返回验证码信息
     * @param url
     * @return
     * @throws HttpException
     */
    public static Captcha requestCaptcha(String url)  throws HttpException {

        String storeBasePath = PathConfig.getCaptchaSavePath();

        String savePath = null;
        String cookies = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response =  httpClient.execute(httpGet);
            if(response==null || response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                throw new HttpException("请求失败");
            }
            HttpEntity entity =   response.getEntity();
            InputStream is  = entity.getContent();
            savePath=  UploadFileUtil.saveImage(is,storeBasePath);
            BufferedHeader header = (BufferedHeader) response.getFirstHeader("Set-Cookie");
            cookies = header.getValue();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return new Captcha(savePath,cookies);
    }

    public static void outPutCaptcha(HttpServletResponse response,
                              String path)throws UpLoadFileException {

        File file = new File(PathConfig.getCaptchaSavePath() + path);
        if (!file.exists()) {
            throw new UpLoadFileException("加载文件不存在");
        }
        byte[] bs = new byte[1024 * 2];
        int len;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            os = response.getOutputStream();
            while ((len = is.read(bs)) != -1) {
                os.write(bs);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new UpLoadFileException("加载验证码失败");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        file.delete();
    }
}
