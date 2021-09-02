package com.sys.hotalbookingsystem.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.sys.hotalbookingsystem.config.AlipayConfig;
import com.sys.hotalbookingsystem.entity.Order;
import com.sys.hotalbookingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@Controller
public class AlipayController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/pay")
    public void payController(int oId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Order order = orderService.selectOrderById(oId);
        int price = order.getTotalPrise();
        String roomType = order.getRoomType();

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = String.valueOf(oId);

        //付款金额，必填
        String total_amount = String.valueOf(price);

        //订单名称，必填
        String subject = roomType;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + price + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //      + "\"total_amount\":\""+ total_amount +"\","
        //      + "\"subject\":\""+ subject +"\","
        //      + "\"body\":\""+ body +"\","
        //      + "\"timeout_express\":\"10m\","
        //      + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
        //请求

        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
    @RequestMapping("/refund")
    public void refundController(int oId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Order order = orderService.selectOrderById(oId);
        int price = order.getTotalPrise();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = String.valueOf(oId);

        //需要退款的金额，该金额不能大于订单金额，必填
        String refund_amount = String.valueOf(price);
        //退款的原因说明
        String refund_reason = new String("退款");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"refund_amount\":\""+ price +"\","
                + "\"refund_reason\":\""+ refund_reason +"\"}");
        //请求
        try {
            String result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
}
