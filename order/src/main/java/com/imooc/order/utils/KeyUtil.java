package com.imooc.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间加流水号
     */
    private static volatile KeyUtil keyUtil;

    private static int DATE_NUMBER = 0;

    private static String lastDate = "";

    private KeyUtil() {
    }

    /**
     * 取得PromaryGenerater的单例实例
     */
    public static KeyUtil getInstance() {
        if (keyUtil == null) {
            synchronized (KeyUtil.class) {
                if (keyUtil == null) {
                    keyUtil = new KeyUtil();
                }
                if (keyUtil.equals("")) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                    lastDate = format.format(new Date());
                }
            }
        }
        return keyUtil;
    }

    /**
     * 生成唯一日期编号
     */
    public String getFinalNumber() {
        synchronized (KeyUtil.class) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String formatDate = format.format(new Date());
            String newDate = formatDate.substring(0, 8);
            if (lastDate.equals(newDate)) {
                if (DATE_NUMBER < 9999) {
                    DATE_NUMBER += 1;
                } else {
                    DATE_NUMBER = 0;
                }
                return newDate + String.format("%04d", DATE_NUMBER);
            } else {
                DATE_NUMBER = 1;
                lastDate = newDate;
                return newDate + String.format("%04d", DATE_NUMBER);
            }

        }
    }

}
