package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleTranslateTest {

    public static void main(String[] args) throws Exception {
        translate("夏季 - 新款 - 韩国 - 复古 - 绑带 - 腰 - 厚 - 雪纺 - 显瘦  - a字 - 纯色 - 半身裙 - 1299", "zh-cn", "en-US");
    }

    private static String googleToken(String text) {// 获取tk参数的值
        String tk = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            FileReader reader = new FileReader(
                    GoogleTranslateTest.class.getClassLoader().getResource("").getPath() + "/Google.js");
            engine.eval(reader);

            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable) engine;
                tk = String.valueOf(invoke.invokeFunction("token", text));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public static String translate(String transalteContente, String fromLanguage, String toLanguage)
            throws InterruptedException {
        StringBuilder url = new StringBuilder();
        try {
            url.append("https://translate.google.cn/translate_a/single?").append("client=t&sl=").append(fromLanguage)
                    .append("&tl=").append(toLanguage).append("&hl=zh-CN")
                    .append("&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw")
                    .append("&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&otf=2&ssel=0&tsel=0&kc=1&tk=")
                    .append(googleToken(transalteContente)).append("&q=")
                    .append(URLEncoder.encode(transalteContente, "utf-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        System.out.println(url);
        // 获取请求连接
        Thread.sleep(1000);
        Connection con = Jsoup.connect(url.toString());
        // 请求头设置，特别是cookie设置（这些参数在f12都可以kanda）
        con.header("Accept", "*/*");
        con.header("Content-Type", "application/json; charset=UTF-8");
        con.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        con.header("Cookie", "");
        // 解析请求结果
        Document doc;
        try {
            doc = con.ignoreContentType(true).get();
            String result = doc.body().text().split(",")[0].replace("[[[", "").replace("\"", "");

            // 获取翻译后的内容
            System.out.println(result);
            // 返回内容
            return Base64.getEncoder().encodeToString(result.getBytes());
            // return Base64.encodeBase64String(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
