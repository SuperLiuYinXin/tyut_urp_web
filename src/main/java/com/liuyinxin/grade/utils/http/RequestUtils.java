package com.liuyinxin.grade.utils.http;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @Author LiuYinXin
 * Created at 2017/5/25.16:38.
 */
public class RequestUtils {


    private static final Logger log = Logger.getLogger(RequestUtils.class.getName());

    /**
     * get 请求
     * @param url      url地址
     * @param head     请求头 map 类型
     * @param encoding 编码
     * @return 返回请求到的数据
     */
    public static String get(String url, Map<String, String> head, String encoding) throws HttpException {

        if(url==null || url.trim().equals("")){
            throw new HttpException("地址不能为空");
        }

//        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        /**  如果head不为空，则加添请求头  **/
        if(head!=null && head.size()>0){
            for (Map.Entry<String,String>map:head.entrySet()) {
//                adddHeader，如果同名header已存在，则追加至原同名header后面。
//                setHeader，如果同名header已存在，则覆盖一个同名header。
                httpGet.setHeader(map.getKey(),map.getValue());
            }
        }

        String result = null;
        try {
            result = executeRequest(httpGet,encoding);
        } catch (HttpException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            result =null;
        }
//            //执行请求头，获取请求体
        return result;
    }

    /**
     * 发送请求的封装
     * @param request 请求头
     * @param encoding 编码类型
     * @return 请求的结果
     * @throws IOException io 出现异常
     * @throws HttpException 请求网站出错
     */
    private static String executeRequest(HttpRequestBase request,String encoding) throws HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(request);
            if(response ==null){
                throw new HttpException("请求网站错误");
            }
            HttpEntity httpEntity =  response.getEntity();
            result = EntityUtils.toString(httpEntity,encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response !=null ){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpClient!=null ){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    /**
     * get请求，默认为 utf-8编码
     *
     * @param url  url 地址
     * @param head 请求头 map 类型
     * @return 返回请求到的数据
     */
    public static String get(String url, Map<String, String> head) throws HttpException {
        return get(url,head,"utf-8");
    }

    /**
     *
     * @param url  请求图片的链接
     * @param storeBasePath  保存的基础路径
     * @return  返回保存的全路径
     * @throws HttpException
     */
    public static String  requestImage(String url,String storeBasePath) throws HttpException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String savePath = null;
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response =  httpClient.execute(httpGet);
            if(! isRequestSuccess(response)){
                throw new HttpException("请求失败");
            }
            HttpEntity entity =   response.getEntity();
            InputStream is  = entity.getContent();
            savePath=  UploadFileUtil.saveImage(is,storeBasePath);
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return savePath;
    }

    private static Boolean isRequestSuccess(CloseableHttpResponse closeableHttpResponse){
        if(closeableHttpResponse !=null && closeableHttpResponse.getStatusLine().getStatusCode() ==HttpStatus.SC_OK){
            return true;
        }
        return false;
    }

    /**
     * Post 请求
     *
     * @param url      url地址
     * @param head     请求头 map 类型
     * @param body     请求体
     * @param encoding 编码
     * @return 返回请求到的数据
     */
    public  static String post(String url, Map<String, String> head, Map<String, String> body, String encoding) throws HttpException {

        if(url==null || url.trim().equals("")){
            throw new HttpException("请求地址不能为空");
        }

        HttpPost post = new HttpPost(url);
        if(head!=null){
            //遍历请求头
            for (Map.Entry<String,String> entry: head.entrySet()) {
                post.setHeader(entry.getKey(),entry.getValue());
            }
        }
        //如果请求体不为空 ， 添加请求体
        if(body!=null){
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for(Map.Entry<String,String>ent:body.entrySet()){
                nvps.add(new BasicNameValuePair(ent.getKey(),ent.getValue()));
            }
            Collections.sort(nvps, new Comparator<NameValuePair>() {
                @Override
                public int compare(NameValuePair o1, NameValuePair o2) {
                    return o1.getName().compareTo(o2.toString());
                }
            });
            post.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("GBK")));
//            HttpEntity entity=null;
//           try {
//                entity = new UrlEncodedFormEntity(nvps);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            post.setEntity(entity);
        }
        String result =  executeRequest(post,encoding);
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            CloseableHttpResponse response = httpClient.execute(post);
//            HttpEntity responseEntity = response.getEntity();
//            if (! isRequestSuccess(response)){
//                result   = EntityUtils.toString(responseEntity,encoding);
//            }
        return result;
    }

    /**
     * Post 请求，默认为utf-8编码
     * @param url  url地址
     * @param head 请求头 map 类型
     * @param body 请求体
     * @return 返回请求到的数据
     */
    public static String post(String url, Map<String, String> head, Map<String, String> body) throws HttpException {
        return post(url,head,body,"utf-8");
    }

    /**
     * 通过发送JSON请求 ，默认为 uft-8编码
     *
     * @param url      url地址
     * @param jsonData json 字符串
     * @return 返回请求到的数据
     */

    public static String post(String url, String jsonData) {
        return null;
    }

    /**
     * 通过发送JSON请求
     *
     * @param url      url地址
     * @param jsonData json 字符串
     * @param encoding 编码方式
     * @return 返回请求到的数据
     */
    public static String post(String url, String jsonData, String encoding) {
        return null;
    }

    /**
     * 获取默认的请求头
     */
    public static Map<String,String> defaultMap;
    static {
        defaultMap= new HashMap<>();
        defaultMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        defaultMap.put("Cache-Control","max-age=0");
        defaultMap.put("Content-Type","application/x-www-form-urlencoded");
        defaultMap.put("Accept-Language","zh-CN,zh;q=0.8");
        defaultMap.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        defaultMap.put("Origin","http://202.207.247.49");
        defaultMap.put("Connection","close");
    }


}
