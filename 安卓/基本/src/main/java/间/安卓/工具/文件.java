package 间.安卓.工具;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.supportx.v4.content.FileProvider;
import android.webkit.MimeTypeMap;
import java.io.File;
import 间.安卓.工具.文件;
import 间.安卓.工具.环境;
import 间.工具.反射;
import 间.工具.字符;
import 间.接口.方法;
import 间.接口.调用;
import 间.接口.返回值;

public class 文件 extends 间.工具.文件 {

    protected static void 初始化() {
        替换地址("%", 取存储目录(""));
        替换地址("$", 取数据目录(""));
        替换地址("#", 取自身目录(""));
    }
    
    public static Uri 取Uri(String $地址) {
        if (设备.取SDK() < 24 || 设备.取目标SDK() < 24) {
            return Uri.fromFile(文件.取文件对象($地址));
        } else {
            return FileProvider.getPathStrategy(环境.取应用(), 应用.取包名() + ".fpv").getUriForFile(文件.取文件对象($地址));
        }
    }

    public static String 取Uri路径(Uri $链接) {
        if (null == $链接) return null;
        String $类型 = $链接.getScheme();
        String $返回 = null;
        if ($类型 == null || ContentResolver.SCHEME_FILE.equals($类型)) {
            $返回 = $链接.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals($类型)) {
            String[] $查询 = new String[] {MediaStore.Files.FileColumns.DATA};
            Cursor $内容 = 环境.取应用().getContentResolver().query($链接, $查询, null, null, null);
            if (null != $内容 && $内容.moveToFirst()) {
                int $位置 = $内容.getColumnIndex($查询[0]);
                if ($位置 > -1) {
                    $返回 = $内容.getString($位置);
                }
            }
            $内容.close();
        }
        if ($返回 == null) {
            return FileProvider.getPathStrategy(环境.取应用(), 应用.取包名() + ".fpv").getFileForUri($链接).getPath();
        }
        return $返回;
    }
    
    
    public static void 打开(String $地址) {
        Intent $意图 = new Intent(Intent.ACTION_VIEW);
        $意图.setDataAndType(取Uri($地址), 取MIME($地址));
        $意图.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (设备.取SDK() > 23 && 设备.取目标SDK() > 23) {
            $意图.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        环境.取应用().startActivity($意图);
    }
    
    public static void 分享(String $地址) {
        Intent $意图 = new Intent(Intent.ACTION_SEND);
        $意图.setDataAndType(取Uri($地址), 取MIME($地址));
        $意图.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (设备.取SDK() > 23 && 设备.取目标SDK() > 23) {
            $意图.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        环境.取应用().startActivity($意图);
    }
    

    public static String 取MIME(String $地址) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(取后缀($地址));
    }

    public static String 取存储目录() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String 取存储目录(String... $地址) {
        return 取存储目录() + "/" + 字符.分解($地址, "/");
    }

    public static String 取数据目录() {
        return 环境.取应用().getFilesDir().getParent();
    }

    public static String 取数据目录(String... $地址) {
        return 取数据目录() + "/" + 字符.分解($地址, "/");
    }

    public static String 取缓存目录() {
        return 环境.取应用().getCacheDir().getPath();
    }

    public static String 取缓存目录(String... $地址) {
        return 取数据目录() + "/" + 字符.分解($地址, "/");
    }

    public static String 取自身目录() {
        return 取数据目录("自身");
    }

    public static String 取自身目录(String... $地址) {
        return 取自身目录() + "/" + 字符.分解($地址, "/");
    }

}
