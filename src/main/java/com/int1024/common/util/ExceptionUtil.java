package com.int1024.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * @author 双料特工・钏钐钾
 * @description 异常工具
 * @createTime 2023-10-13
 */
public class ExceptionUtil {

    /**
     * 判断指定异常是否为ClientAbortException异常
     *
     * @param t 指定异常
     * @return 若为ClientAbortException异常返回true，否则返回false
     */
    public static boolean isClientAbortException(Throwable t) {
        return t.toString().contains("ClientAbortException");
    }

    /**
     * 堆栈信息字符串
     * @param throwable 指定异常
     * @return 堆栈字符串
     */
    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
