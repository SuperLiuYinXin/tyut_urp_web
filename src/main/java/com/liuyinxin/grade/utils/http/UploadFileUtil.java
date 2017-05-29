package com.liuyinxin.grade.utils.http;

import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.exception.DownLoadFileException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * 用于文件上传
 * @Author LiuYinXin
 * Created at 2017/5/17.10:37.
 */
@Component
public class UploadFileUtil {



    /**
     * 保存文件
     * @param file
     * @return  返回文件存储的路径
     */
    public String saveFile(MultipartFile file) throws DownLoadFileException{

        StringBuffer savePath = new StringBuffer(PathConfig.getBasePath());

        if(file == null && file.isEmpty()){
                throw new DownLoadFileException("上传的文件不能为空");
        }

//        File saveDir = new File(savePath.toString());
//
//        if( !saveDir.exists()  && ! saveDir.mkdirs()){
//             throw new UpLoadFileException("创建文件夹时出现错误") ;
//        }

        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        if(suffix==null || "".equals(suffix.trim()) ){
            throw new DownLoadFileException("非法文件"+fileName);
        }

        savePath.append("/"+suffix);

        String uuid = UUID.randomUUID().toString().replace("-","").substring(0,16);
        String hash = String.valueOf(Math.abs(uuid.hashCode())%100);

        savePath.append("/").append(hash);
        File storagePath = new File(savePath.toString());
        if( ! storagePath.exists()  && ! storagePath.mkdirs()){
            throw new DownLoadFileException("创建文件夹时出现错误") ;
        }
        savePath.append("/").append(uuid).append("-").append(fileName);

        File storageFile = new File(savePath.toString());

        try {
            file.transferTo(storageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePath.toString();
    }


    public static String saveImage(InputStream inputStream, String basePath){
        StringBuffer savePath = new StringBuffer(PathConfig.captchaSavePath);
        String captchaName = UUID.randomUUID().toString();
        String suffix = String.valueOf(Math.abs(captchaName.hashCode())%10);
        savePath.append("/").append(suffix);
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流保存到本地文件
        File saveFile = new File(savePath.toString());
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        OutputStream os = null;
        savePath.append(File.separator).append(captchaName).append(".jpg");
        try {
            os = new FileOutputStream(savePath.toString());
            // 开始读取
            try {
                while ((len = inputStream.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return savePath.toString();
    }

}


