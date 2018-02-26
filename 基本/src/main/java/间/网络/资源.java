package 间.网络;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.Response;
import 间.工具.字符;
import 间.工具.流;
import 间.工具.错误;
import 间.接口.方法;

public class 资源 {

    private Response 资源;
    private byte[] 内容;

    public 资源(Response $资源) {
        资源 = $资源;
    }
    
    public int 进度(long $当前) {
        return new Float(new Float((float)$当前 / (float)大小()).floatValue() * 100).intValue();
    }
    
    public long 大小() {
        return 资源.body().contentLength();
    }

    public boolean 成功() {
        if (资源 == null) {
            return false;
        }
        return 资源.isSuccessful();
    }

    public boolean 重定向() {
        if (资源 == null) {
            return false;
        }
        return 资源.isRedirect();
    }

    public int 状态码() {
        if (资源 == null) {
            return -1;
        }
        return 资源.code();
    }

    public byte[] 字节() {
        if (资源 == null) {
            return null;
        }
        try {
            if (内容 == null)
                内容 = 资源.body().bytes();
            return 内容;
        } catch (IOException $错误) {}
        return null;
    }

    public String 文本() {
        if (资源 == null) {
            return null;
        }
        return 字符.转换(字节());
    }

    public void 保存(String $输出) {
        保存($输出, null);
    }

    public void 保存(String $输出,方法 $进度) {
        保存($输出, $进度, null, null);
    }

    public void 保存(String $输出,方法 $进度,方法 $开始,方法 $结束) {
        if (资源 == null) {
            return;
        }
        OutputStream $流 = 流.输出.文件($输出);
        if ($流 == null) {
            错误.内容("无法保存到: " + $输出);
        }
        流.非阻塞保存($流, 内容 == null ? 资源.body().byteStream() : 流.输入.字节(内容), $进度, $开始, $结束);
    }

}
