package com.int1024.common.util.net;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author 双料特工・钏钐钾
 * @description 网络相关工具
 * @createTime 2023-10-13
 */
public class NetUtil {

    /**
     * 判断请求是否是异步请求
     * @param request   请求
     * @return  是否为异步请求
     */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
