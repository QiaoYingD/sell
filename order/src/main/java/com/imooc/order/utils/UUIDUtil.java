package com.imooc.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    private static final SimpleDateFormat S_FORMT = new SimpleDateFormat("yyyyMMddHHmmss");

    public synchronized static String genUniqueKey() {
        return S_FORMT.format(new Date()) + UUID.randomUUID();
    }


}
