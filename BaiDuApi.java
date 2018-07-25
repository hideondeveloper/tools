package onemuggle;

import java.net.URLEncoder;

public class BaiDuApi {

    public static void main(String[] args) throws Exception {
        String apihost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        // 本地图片路径
        String filePath = "C:\\Users\\Neuer\\Desktop\\333.png";
        try {
            byte[] imgData = OcrFileUtil.readFileByBytes(filePath);
            String imgStr = OcrBase64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            String accessToken = AuthService.getAuth();
            String result = BaiDuHttpUtil.post(apihost, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
