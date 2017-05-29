package com.liuyinxin.grade.utils.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.23:36.
 */
public class EvaluateUtils {

    public static Map<String,String> DEFAULT_EVALUATE;
    static {
        DEFAULT_EVALUATE = new HashMap<>();
        DEFAULT_EVALUATE.put("0000000136","25_0.95");
        DEFAULT_EVALUATE.put("0000000137","25_0.95");
        DEFAULT_EVALUATE.put("0000000138","30_0.95");
        DEFAULT_EVALUATE.put("0000000139","20_0.95");
    }

    /**
     *
     * @param attitude 0 1 2 默认  0 很好  好  一般
     * @param level 0 1 2 默认  0 很好  好  一般
     * @param method 0 1 2 默认  0 很好  好  一般
     * @param effect 0 1 2 默认  0 很好  好  一般
     * @return
     */
    public static  Map<String,String> getEvaluateMap(int attitude,
                                                     int level,
                                                     int method,
                                                     int effect){


        Map<String,String> map = new HashMap<>();
        switch (attitude){
            case 0: map.put("0000000136","25_0.95"); break;
            case 1: map.put("0000000136","25_0.75");break;
            case 2: map.put("0000000136","25_0.05");break;
            default:map.put("0000000136","25_0.95");
        }
        switch (level){
            case 0: map.put("0000000137","25_0.95"); break;
            case 1: map.put("0000000137","25_0.75");break;
            case 2: map.put("0000000137","25_0.05");break;
            default:map.put("0000000137","25_0.95");
        }
        switch (method){
            case 0: map.put("0000000138","30_0.95"); break;
            case 1: map.put("0000000138","30_0.75");break;
            case 2: map.put("0000000138","30_0.05");break;
            default:map.put("0000000138","30_0.95");
        }
        switch (effect){
            case 0: map.put("0000000139","20_0.95"); break;
            case 1: map.put("0000000139","20_0.75");break;
            case 2: map.put("0000000139","20_0.05");break;
            default:map.put("0000000139","20_0.95");
        }

        return map;

    }


//    教学态度与课前准备：师德师风，备课情况，教材选用。
//    public static Map<String,String> teacherAttitude;

//    教学水平与授课艺术：语言表达，板书或多媒体的使用，讲课进度安排。
//    public static Map<String ,String> teacherLevel;

//    教学方法与教学手段：引导和拓展思维，激发兴趣，培养实践能力，师生互动。
//    public static Map<String ,String> teacherMethod;

//    教学效果：接受和掌握课程内容，应用课程内容解决问题，思维能力和学习能力的提高。
//    public static Map<String ,String> teacherEffect;



}
