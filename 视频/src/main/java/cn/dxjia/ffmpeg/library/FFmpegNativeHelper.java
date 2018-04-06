package cn.dxjia.ffmpeg.library;

import android.util.Log;

public class FFmpegNativeHelper {
	public FFmpegNativeHelper() {
	}
	
	static {
		System.loadLibrary("avutil-54");
		System.loadLibrary("swresample-1");
		System.loadLibrary("avcodec-56");
		System.loadLibrary("avformat-56");
		System.loadLibrary("swscale-3");
		System.loadLibrary("avfilter-5");
		System.loadLibrary("avdevice-56");
		System.loadLibrary("ffmpegjni");
	}

	// success 0, error 1
	public static String runCommand(String command) {
		if(command == null || command.length() == 0) {
            return null;
        }
		String[] args = command.split(" ");
		try {
			return ffmpeg_run(args);
		} catch (Exception e) {
            return null;
		}
	}

	// Deprecated, no use anymore
    public static int init() {
        return ffmpeg_init();
    }

	// Deprecated, no use anymore
    public static int uninit() {
        return ffmpeg_uninit();
    }

	private static native int ffmpeg_init();
	private static native int ffmpeg_uninit();
	private static native String ffmpeg_run(String[] args);
}
