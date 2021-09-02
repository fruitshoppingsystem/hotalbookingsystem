package com.sys.hotalbookingsystem.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000118604215";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCFnVRUh7GIAMkrswiAy5mISBZx/AVPttoBxuJ6KO5iTuvqJJpottP7nu6ZYoEuoK+2AAnv7pz+8K3FGwxuJrWeuINtCjs3UZ8nVS54IV81LC3Q5x471lnE7wTruppSBkGiLfwFZJS1oIPFHzoBDhTVi9lJaVVmSqd6foiuqWWYCBZC+jcfxCK524k+S3OkM/4RkFF2xsZ0gixDdXnOoIrhf5RyzG46QzkxVheuzrf37lFbOn/NYxfWmV049r3SAPyPwnHbTSsk75hzpzU7R126zV+5Iux6F3JFY09EX7emvG4NMrdMk3cLJryyMuavQtxgGN1+jg9yvNPMxSWt2IrvAgMBAAECggEAPAkYJi8eRtTLj1YPYQeagdCaPTcXD91CEYBSrL8NdaCugfNWaeyUTT/5R3QqRVAwA1/7FxKo+igcfC8OI8RC4QFZFDp/pviGwX6VtaaRB+xE3dOrEwnaJhGbrWuYAXkMLpno3md2JjHsYzsHrgesttLym/i3RZIPtIt8ULaOjoOVJ2qg+uERlKqiqULm3j/2PV+uukLEJcw7JDSisQ4Tx+SAOsJT/N3LP+hEw0Mjr7Ch30g4sEkKEuvPMWOsnrFKYCZj+OjH7uLeXdVswNtJjo2PLKGqCr7DnpXmUhJ325K1tRvLzvYfxRX7PU7l0rUcS9fcjcHDgYuR4qASphB6sQKBgQDFXEP181wsWN0siItH7T2p2WYxvI2Q3L/uSeX22NvGFMSEAtwqdlsvSpMvqfKsqmgo9NclQTLu9hq52FAL5dufOBrxDvFFt4XuXtNe0n5PMAwg6jT2yoI4Lp3GRQirzkm6r8djxLuXUYLUimZPAvlg/TJyzErRlk22TrT/o/W5pwKBgQCtUGSeTa0QUGv30CgpjHX0iyd4tO74pVfyNxQOCu5KbdizF4vHGzNZpnfAzmmX8vpDstR5khN3vJ4FYyW5wI6eBNLovHXma930zii+IC0bkP7v+SWgqLd3v9/t/+7asQ1vcYpfLqFZn/G2LGxIpthuOYIvW3RXOeyYPEdyM7E9eQKBgQCSt5SOMuxCy40gniFsxyEgM02Vi+Zx2qmUK7uZVn2LM8UjnjyuFG6VKYth06VkVwo36ExIlb+Xhb04i2Z2cdpi8wKUUddrTJN0MWpRA4qCs+VQUsws6z8DJSSFUKyxjBmjfylrMcWDKEVqW7jS5BMf1xq53MWCKYp8DObhZLI34QKBgB5q053s6AjK9IgDomjYXANVQNIwfxhofGzoOb7VMEkjyjp0UXXaUkLTsoTGNUYTwNSM2DmV55DGK72qTv6wytb05ccu/Eo6eDP00rW7k+8YnYWkZnQx6DE+HaD5oAQFuuPqO2zFFFBUf+mHFmIR1j5SHYUOOfbtFZcKTUe/xsWRAoGBAJfEIfOZZc2JHqdfxOVj3YkYQTL9Kfw2ecPoIaFetgixs6NjU3gFEvk/To413+0AuD/gYUAo5vst3i7XD1U1ezZxQGISfCUZrqdfkw5KH2bJnxO4vV7cZgBvdCNvY3UjpaQzWKVLK4ls3HW+Uc+XFG10ebj8IbtpGLbcvQqWh2AA";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmQhCXOeXWvPGXovn8NpQjiIdAtuYLOWBUfEWYJXabApo+PPWAlZ7Mvq67fQDl4OjbyZWGlLddmgMuv66TjlrX4U0KoJOx2569XcUYhIq0AVhIQFYBgMID4GbAOlBJFOomn92O4ViqSXfsdK+XeEzzxLKGXnTZs4095nOLepCei26DgiN0dvlpDjQ2kz7EYJ6CUHl7/ot97UE+ObEaq+JQoKKZjwg551Zp1rEofxrAJ8CQcseJFxfs0Ty2WbuIOUaTv2pbF7Ys5/q/XhDhDF6ADkgJjNmremWhLJUdIZZR3agKegNZg/PpT7VZoPFC4NiQPa87ZKEvi/k3JT4bmLG+wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/payReturn.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
