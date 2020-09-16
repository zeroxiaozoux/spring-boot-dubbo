package com.face;

import com.zero.common.sign.Base64Util;
import com.zero.common.sign.SignUtil;

/**
 * @author zero
 * @date 2020/9/1-16:15
 */
public class SignTest {
    public static void main(String[] args) throws Exception {
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAN17Mzs41yIseubyJcwC9WcPjKqwLKpmoxm+UrjeZieYqoc6UndHk9IJG18kx9+13K5KfnHnaqh9YQ4cZu/T3W8CAwEAAQ==\n";
        String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEA3XszOzjXIix65vIlzAL1Zw+MqrAsqmajGb5SuN5mJ5iqhzpSd0eT0gkbXyTH37Xcrkp+cedqqH1hDhxm79PdbwIDAQABAkBw1Y8oILEZa+fBOKQg53D2bGmRm+dleJynRNsH6+XHTYDgY8NaMvqE3NhITPX/fGEXaVZjH3FXpo6ohX5m2eAhAiEA+Ac2X4aEurNYd+2PvLmwO673vLVK0uGDr2OsV5chRNsCIQDkmY7yMHmSnIhcQCITbQjn9/l+gVgDCUDcVZqrHYDD/QIhAOA/9SNNRnhfax+ThKAH65Uqzwapi2s7RoqvPcU7+XJ9AiAh2wQqpjc7GWewkeb6DYnmIPmYXLuWJ4atmxf/A62QWQIgDQzIcUSuVLaX3TlVMm4BqbEbu2YeuSvR0V4/k/Ssc58=\\n\";\n+UrjeZieYqoc6UndHk9IJG18kx9+13K5KfnHnaqh9YQ4cZu/T3W8CAwEAAQ==\n";
        String plain = "{\"timestamp\":\"1682222222200\",\"notify_url\":\"ddddd\",\"item\":{\"name\":\"你好kkkkk\",\"sex\":\"男\",\"age\":22,\"email\":\"123kkkkkks@qq.com\"},\"sign\":\"U9WJbJplROO5tZXZvadCacarRlZUmgoUwnvVQYAyap68dCHKXTkpBSYnhDDFC4h5VJzhMF4eesu6iLuLGpB0lQ==\"}";
         //原始报文
        System.out.println("原始报文是:" + plain);
        int beginIndex = plain.indexOf("\"sign\"") -1;
        String signContent = plain.substring(0,beginIndex)+"}";
        String signStr = plain.substring(beginIndex+9,plain.length()-2);
        System.out.println("签名 sign:"+signStr);
        System.out.println("移除"+signContent);
        //String plain = "欢迎大家关注我的公众号，捡田螺的小男孩";
        //加签
        byte[] signatureByte = SignUtil.sign(signContent,privateKey);

       // String encodeString = new BASE64Encoder().encode(signatureByte);
        String encodeString = Base64Util.encode(signatureByte);
        System.out.println("加签结果:"+encodeString);
        // byte[] decodeByte = new BASE64Decoder().decodeBuffer(encodeString);
         byte[] decodeByte = Base64Util.decode(encodeString);
        System.out.println( );
        //System.out.println("加签结果2:"+signatureByte.toString());
        //验签
        boolean verifyResult =  SignUtil.verify(signContent, decodeByte,publicKey);
        System.out.println("验签结果:" + verifyResult);

    }
}
