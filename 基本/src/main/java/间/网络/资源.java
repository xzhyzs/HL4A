package 间.网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import 间.工具.字符;
import 间.工具.流;

public class 资源 {

    private int 状态码;
    private int 长度;
    private InputStream 输入;
    private boolean 是断点;
    private byte[] 缓存;

    public 资源(int $状态码,int $长度,InputStream $输入) {
        状态码 = $状态码;
        长度 = $长度;
        输入 = $输入;
        是断点 = 状态码 == 206;
    }

    public boolean 已成功() {
        return 状态码 >= 200 && 状态码 < 300;
    }

    public boolean 无连接() {
        return 状态码 == -1;
    }

    public int 取状态码() {
        return 状态码;
    }

    public byte[] 字节() {
        if (缓存 == null)
            缓存 = 流.读取(输入, 1024);
        return 缓存;
    }

    public String 文本() {
        return 字符.转换(字节());
    }

    public void 保存(String $输出) {
        OutputStream $流 = 流.输出.文件($输出,是断点);
        流.保存($流,输入);
    }

}
