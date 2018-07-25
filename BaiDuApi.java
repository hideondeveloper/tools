package onemuggle;

import java.net.URLEncoder;
import java.util.Base64;

public class BaiDuApi {

    public static void main(String[] args) throws Exception {
        String apihost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        // 本地图片路径
        String filePath = "C:\\Users\\Neuer\\Desktop\\333.png";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64.getEncoder().encodeToString(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            String accessToken = AuthService.getAuth();
            String result = BaiDuHttpUtil.post(apihost, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
