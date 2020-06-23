package common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import common.util.JsonUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoHttpWithApache {
    private static final Logger log = LoggerFactory.getLogger(DoHttpWithApache.class);

    /**
     * Http Get 请求示例
     */
    public static void httpGet(String url, Object params) {
        CloseableHttpResponse response = null;
        try {
            Map<String, String> map = JsonUtils.objectNativeConvert(params, new TypeReference<Map<String, String>>() {
            });
            assert map != null;
            List<NameValuePair> list = new ArrayList<>(map.size());
            map.forEach((k, v) -> list.add(new BasicNameValuePair(k, v)));
            URIBuilder uriBuilder = new URIBuilder(url).addParameters(list);
            // 创建 HttpGet 对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            // 执行 Http Get 请求
            response = HttpClientUtil.getHttpclient().execute(httpGet);
            // 输出响应内容
            if (response.getEntity() != null) {
                log.info(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
            }
            // 销毁流
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ParseException | URISyntaxException e) {
            log.error("", e);
        } finally {
            // 释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
    }

    /**
     * Http Post Form 表单请求示例
     */
    public static String httpPostForm(String url, Object params) {
        CloseableHttpResponse response = null;
        String res = "";
        try {
            // 创建 HttpPost 对象
            HttpPost httpPost = new HttpPost(url);
            // 设置 HttpPost 请求参数
            Map<String, String> map = JsonUtils.objectNativeConvert(params, new TypeReference<Map<String, String>>() {
            });
            assert map != null;
            List<NameValuePair> list = new ArrayList<>(map.size());
            map.forEach((k, v) -> list.add(new BasicNameValuePair(k, v)));
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, StandardCharsets.UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
            // 设置 Content-Type
            httpPost.addHeader("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            // 执行 Http Post 请求
            response = HttpClientUtil.getHttpclient().execute(httpPost);
            // 输出响应内容
            if (response.getEntity() != null) {
                res = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                log.info("httpclient form return:{}", res);
            }
            // 销毁流
            EntityUtils.consume(urlEncodedFormEntity);
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ParseException e) {
            log.error("", e);
        } finally {
            // 释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
        return res;
    }

    /**
     * Http Post Json 表单请求示例
     */
    public static String httpPostJson(String url, Object params) {
        CloseableHttpResponse response = null;
        InputStream inputStream = null;
        String res = "";
        try {
            // 创建 HttpPost 对象
            HttpPost httpPost = new HttpPost(url);
            // 设置请求对象
            // 将请求对象通过 jackson 中方法转换为 Json 字符串，并创建字符串实体对象
            StringEntity stringEntity = new StringEntity(JsonUtils.serialize(params), StandardCharsets.UTF_8);
            // 设置 HttpPost 请求参数
            httpPost.setEntity(stringEntity);
            // 设置 Content-Type
            httpPost.addHeader("Content-Type", ContentType.APPLICATION_JSON);
            // 执行 Http Post 请求
            response = HttpClientUtil.getHttpclient().execute(httpPost);
            // 输出响应内容
            if (response.getEntity() != null) {
                inputStream = response.getEntity().getContent();
                res = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                log.info("httpclient post return:{}", res);
            }
            // 销毁流
            EntityUtils.consume(stringEntity);
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ParseException e) {
            log.error("", e);
        } finally {
            // 释放资源
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
        return res;
    }


    /**
     * Http Post 上传文件示例
     */
    public static void httpPostUpload() {
        File file = new File("D:" + File.separator + "测试.xlsx");
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost("http://localhost:8080/file/upload");
            HttpEntity entity = MultipartEntityBuilder.create()
                    // 设置编码方式
                    .setCharset(StandardCharsets.UTF_8)
                    // 设置为兼容模式，解决返回中文乱码问题
                    .setMode(HttpMultipartMode.LEGACY)
                    .addPart("file", new FileBody(file))
                    .build();
            httpPost.setEntity(entity);
            // 执行提交
            response = HttpClientUtil.getHttpclient().execute(httpPost);
            // 输出响应内容
            if (response.getEntity() != null) {
                log.info(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
            }
            // 销毁流
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ParseException e) {
            log.error("", e);
        } finally {
            // 释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
    }

    /**
     * Http Get 下载文件示例
     */
    public static void httpGetDownload() {
        CloseableHttpResponse response = null;
        try {
            // 创建 HttpGet 对象
            HttpGet httpGet = new HttpGet("http://localhost:8080/file/download");
            // 执行 Http Get 请求
            response = HttpClientUtil.getHttpclient().execute(httpGet);
            // 从 headers 中获取文件名
            String content = response.getHeader("Content-Disposition").getValue();
            String filename = content.substring(content.lastIndexOf('=') + 1, content.lastIndexOf('.'));
            String suffix = content.substring(content.lastIndexOf('.'));
            // 将文件名转码
            filename = URLDecoder.decode(filename, "UTF-8");
            // 获取响应实体对象
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 获取输入流并且将保存下载的文件
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream fileOutputStream = new FileOutputStream("d://" + filename + suffix)
                ) {
                    byte[] tmp = new byte[1024];
                    int l;
                    while ((l = inputStream.read(tmp)) != -1) {
                        fileOutputStream.write(tmp, 0, l);
                    }
                    fileOutputStream.flush();
                }
            }
            // 销毁流
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ProtocolException e) {
            log.error("", e);
        } finally {
            // 释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
    }
}
