package cc.cafetime.common.util;

import java.io.*;

/**
 * 流操作工具类
 * Created by liujing on 16/1/10.
 */
public final class StreamUtil {
    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            LoggerUtil.logger().error("get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            int length;
            byte[] buffer = new byte[4 * 1024];
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        } catch (Exception e) {
            LoggerUtil.logger().error("copy stream failure", e);
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                LoggerUtil.logger().error("close stream failure", e);
            }
        }
    }
}
