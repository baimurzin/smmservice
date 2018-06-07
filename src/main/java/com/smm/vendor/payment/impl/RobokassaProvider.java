package com.smm.vendor.payment.impl;

import com.smm.model.Order;
import com.smm.tools.HelperUtil;
import com.smm.vendor.payment.PayStrategy;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component("robokassa")
public class RobokassaProvider implements PayStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobokassaProvider.class);

    @Value("${payment.robokassa.url}")
    private String url;
    @Value("${payment.robokassa.login}")
    private String login;
    @Value("${payment.robokassa.password1}")
    private String password1;
    @Value("${payment.robokassa.password2}")
    private String password2;
    @Value("${payment.robokassa.test}")
    private boolean isTest;

    @Override
    public String pay(Order order) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(url);
            builder.append("?");
            String paramsString = buildParams(order);
            builder.append(paramsString);
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Paid with " + this.getClass().getSimpleName());
        return null;
    }

    private String buildParams(Order order) throws NoSuchAlgorithmException {
        String signature = getRequestSignature(order.getOrderSum().toString(), order.getInvId());
        Map<String, String> params = new HashMap();
        params.put("MrchLogin", login);
        params.put("OutSum", HelperUtil.urlEncodeUTF8(order.getOrderSum().toString()));
        params.put("InvId", String.valueOf(order.getInvId()));
        params.put("Desc", order.getDesc());
        params.put("SignatureValue", signature);
        params.put("IncCurrLabel", order.getCurrency());
        params.put("Email", order.getEmail());
        params.put("Culture", order.getCulture());
        params.put("IsTest", String.valueOf((isTest) ? 1 : 0));
        return HelperUtil.urlEncodeUTF8(params);
    }

    private String getRequestSignature(String sum, long invoiceId)
            throws NoSuchAlgorithmException {
        // sMerchantLogin:nOutSum:nInvId:sMerchantPass1
        StringBuilder stringBuilder = generateResultHash(String.valueOf(invoiceId), sum, password1);
        stringBuilder.insert(0, login + ":");
        return getHash(stringBuilder);
    }

    private String getResultHash(String sum, String invoce)
            throws NoSuchAlgorithmException {
        // nOutSum:nInvId:sMerchantPass2
        return getHash(generateResultHash(invoce, sum, password2));
    }

    private String getSuccessHash(String nInvId, String sum)
            throws NoSuchAlgorithmException {
        // nOutSum:nInvId:sMerchantPass1
        return getHash(generateResultHash(nInvId, sum, password1));
    }

    private StringBuilder generateResultHash(String nInvId, String sum, String pass) throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        builder.append(sum);
        builder.append(":");
        builder.append(nInvId);
        builder.append(":");
        builder.append(password1);
        return builder;
    }

    private String getHash(StringBuilder builder)
            throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(builder.toString().getBytes(
                Charset.forName("UTF8")));
        final byte[] resultByte = messageDigest.digest();
        final String result = new String(Hex.encodeHex(resultByte));
        return result;
    }
}
