package common.http;

import common.util.JsonUtils;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 易错点：超时、重试、并发
 */
public class HttpUtil {
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectionPool(new ConnectionPool(500, 5, TimeUnit.MINUTES))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build();
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    public static String sendPostRequest(Map<String, Object> params, String url, Map<String, String> header) {
        String res = "";
        Request request = new Request.Builder()
                .headers(Headers.of(header))
                .post(RequestBody.create(JsonUtils.serialize(params), MediaType.get("application/json; charset=utf8")))
                .url(url)
                .build();
        res = getHttpResponse(params, url, res, request);
        LOGGER.info("调用第三方接口结束，url:{},params:{},返回结果：{}", url, params, res);
        return res;
    }

    public static String sendGetRequest(Map<String, Object> params, String url, Map<String, String> header) {
        String res = "";
        Request request = new Request.Builder()
                .headers(Headers.of(header))
                .url(url)
                .get()
                .build();
        res = getHttpResponse(params, url, res, request);
        LOGGER.info("调用第三方接口结束，url:{},json:{},返回结果：{}", url, params, res);
        return res;
    }

    private static String getHttpResponse(Map<String, Object> params, String url, String res, Request request) {
        Response response;
        Call call = null;
        try {
            call = client.newCall(request);
            response = call.execute();
            res = response.body().string();
        } catch (IOException e) {
            LOGGER.info("请求失败----------------url:{},参数：{}", url, params);
            LOGGER.error("请求失败----------------", e);
        } finally {
            if (call != null) {
                call.cancel();
            }
        }
        return res;
    }
}
