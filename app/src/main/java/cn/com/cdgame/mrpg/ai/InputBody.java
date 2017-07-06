package cn.com.cdgame.mrpg.ai;

import android.text.TextUtils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * Author：陈东
 * Time：2017/7/6 - 下午3:11
 * Notes:输入内容
 */

public class InputBody {
    String body;//原内容
    List<Term> content; //分词内容
    List<String> keys; //提取关键词


    public InputBody(String body) {
        this.body = body;
        if (!TextUtils.isEmpty(body)) {
            keys = HanLP.extractKeyword(body, (body.length() / 2)+1);
            content = HanLP.segment(body);
        }
    }



}
