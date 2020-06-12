package com.wd.erp.until;

import com.sun.org.slf4j.internal.Logger;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BasisUntil {
    /**
     * 计算传入月份的第一天或最后一天
     *
     * @param month
     * @return
     */
    public static String calMonthFirstAndLastDay(String month, int type) {
        try {
            Calendar cale = Calendar.getInstance();
            Date date = new SimpleDateFormat("yyyy-MM").parse(month);
            cale.setTime(date);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //cale = Calendar.getInstance();//获取前月的第一天
            cale.add(Calendar.MONTH, type == 0 ? 0 : 1);
            cale.set(Calendar.DAY_OF_MONTH, type == 0 ? 1 : 0);
            return format.format(cale.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }


}
