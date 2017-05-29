package com.liuyinxin.grade.biz.impl;

import com.liuyinxin.grade.biz.EvaluateBiz;
import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.config.ResultConfig;
import com.liuyinxin.grade.dto.Evaluate;
import com.liuyinxin.grade.exception.BizException;
import com.liuyinxin.grade.utils.http.EvaluateUtils;
import com.liuyinxin.grade.utils.http.RequestUtils;
import com.liuyinxin.grade.utils.re.EvaluateReUtils;
import org.apache.http.HttpException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于发布文章
 * @Author LiuYinXin
 * Created at 2017/5/26.23:16.
 */
@Service
public class EvaluateBizImpl implements EvaluateBiz {

    private static Logger log = Logger.getLogger(EvaluateBizImpl.class);

    public int autoEvaluate(String cookie, Evaluate evaluate){


        //首先模拟进入详情页面
        String detailResult = getEvaluateDetail(cookie,evaluate);
//        System.out.println(detailResult);


        //再发送请求
        String url = PathConfig.getIndex()+PathConfig.getEvaluatePostPath();

        //创建请求头
        Map<String,String> head = new HashMap<>();
//        head.putAll(RequestUtils.defaultMap);
        head.put("Cookie",cookie);
        head.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//        head.put("Referer", "http://202.207.247.49/jxpgXsAction.do");
//        wjbm=0000000103
//        bpr=101453
//        pgnr=00003346
//        &0000000136=25_0.95
//        &0000000137=25_0.95
//        &0000000138=30_0.95
//        &0000000139=20_0.95
//        &zgpj=%C0%CF%CA%A6%BE%A1%D0%C4%BE%A1%D4%F0%A1%A3%BD%B2%BF%CE%C8%CF%D5%E6%A1%A3%B6%D4%CD%AC%D1%A7%B8%BA%D4%F0%A1%A3%D3%C4%C4%AC%B7%E7%C8%A4
        //创建请求体
        Map<String,String > body = new HashMap<>();
        body.putAll(EvaluateUtils.DEFAULT_EVALUATE);
        body.put("wjbm",evaluate.getEvaluateNumber());
        body.put("bpr",evaluate.getTeacherNumber());
        body.put("pgnr",evaluate.getClassNumber());
        body.put("zgpj",ResultConfig.DEFAULT_EVALUATE_CONTEXT);
//        body.put("oper",evaluate.getOper());
//        body.put("pageSize","20");
//        body.put("page","1");
//        body.put("currentPage","1");
//        body.put("pageNo","");
//        pageSize=20&page=1&currentPage=1&pageNo=

        //如果不是一键评教  则加上这段
//        if(evaluate.getEvaluateMap() == null || evaluate.getEvaluateMap().size()<=0){
//            throw new EvaluateException("教评内容为空");
//        }
//        body.putAll(evaluate.getEvaluateMap());
//        if(evaluate.getContext() == null || evaluate.getContext().trim().equals("")){
//            throw new EvaluateException("教评内容为空");
//        }
//        body.put("zgpj",evaluate.getContext());

        String result = null;
        try {
            //发布请求内容
            result = RequestUtils.post(url,head,body);
        } catch (HttpException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        if( ! EvaluateReUtils.isEvaluateSuccess(result)){
            log.error("评估失败");
            System.out.println("评估失败");
            return ResultConfig.STATIC_RESULT_ERROR;
        }

        return ResultConfig.STATIC_RESULT_SUCCESS;

    }

    /**
     * 获取教评价列表
     * @param cookie cookie 值
     * @return 教评列表
     */
    @Override
    public List<Evaluate> getEvaluateList(String cookie) {

        //创建url
        String url = PathConfig.getIndex()+PathConfig.getEvaluateListPath();

        //创建请求头
        Map<String,String> head = new HashMap<>();
        head.putAll(RequestUtils.defaultMap);
        head.put("Cookie",cookie);

        //发送请求
        String result = null;
        try {
            result =  RequestUtils.get(url,head);
        } catch (HttpException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BizException("获取结果时出现异常");
        }
        //处理请求体
        List<Evaluate> evaluateList = EvaluateReUtils.getEvaluateList(result);

        return evaluateList;
    }

    /**
     * 进入到详情页面
     * @param cookie cookies值
     * @return 返回详情页面的html
     */
    @Override
    public String getEvaluateDetail(String cookie,Evaluate evaluate) {

        String url = PathConfig.index+ PathConfig.evaluateDetailPath;
        //请求头
        Map<String,String> head = new HashMap<>();
        head.putAll(RequestUtils.defaultMap);
        head.put("Cookie",cookie);

        //请求体
        //wjbm=0000000103
        //bpr=101453
        // pgnr=00003346
        // oper=wjShow
        // wjmc=2016-2017%D1%A7%C4%EA%B5%DA%B6%FE%D1%A7%C6%DA%C6%DA%C4%A9%D1%A7%C9%FA%C6%C0%BD%CC&bprm=%CC%EF%CC%ED&pgnrm=%CF%DF%D0%D4%B4%FA%CA%FDE
        Map<String,String> body = new HashMap<>();
        body.put("wjbm",evaluate.getEvaluateNumber());
        body.put("bpr",evaluate.getTeacherNumber());
        body.put("pgnr",evaluate.getClassNumber());
        body.put("oper",evaluate.getOper());
        body.put("wjmc",evaluate.getEvaluateName());

        String result;
        try {
            result = RequestUtils.post(url,head,body);
        } catch (HttpException e) {
            e.printStackTrace();
            log.error("请求失败\n"+e.getMessage());
            return null;
        }

        return  result;
    }
}
