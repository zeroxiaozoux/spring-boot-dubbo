package com.face.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zero.common.sign.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpInputMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.stream.Collectors;

/**
 * @author zero
 * @date 2020/9/1-19:29
 */
@Slf4j
public class CommonUtils {
    public static boolean Signature(Object body, String publicKeyStr, String privateKey) {
        try {
            // jackson.databind.exc.MismatchedInputException No content to map due to end-of-input  操作inputMessage 报异常
//            String content = new BufferedReader(new InputStreamReader(inputMessage.getBody()))
//                    .lines().collect(Collectors.joining(System.lineSeparator()));
            String signBody = JSON.toJSONString(body); // 剔除NULL的属性
            log.info("签名请求参数正文--剔除NULL属性 :{}", signBody);
            // 会改变json 属性顺序
//            JSONObject jsonObject = JSON.parseObject(signBody);
//            String signStr = jsonObject.getString("sign");
//            jsonObject.remove("sign");

            // 保证 sign 属性 最后 剔除
            int beginIndex = signBody.indexOf("\"sign\"") - 1;
            String signContent = signBody.substring(0, beginIndex) + "}";
            String signStr = signBody.substring(beginIndex + 9, signBody.length() - 2);
            if (!StringUtils.isEmpty(privateKey)) { // 调试使用
                log.info("参与签名正文：{}", signContent);
                log.info("生成签名正文 :{}", SignUtil.signEncode(signContent, privateKey));
            }
            return SignUtil.verifyDecode(signContent, signStr, publicKeyStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // 验证失败
    }
}
