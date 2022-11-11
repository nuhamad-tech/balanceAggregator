package com.bank.balanceAggregator.util;

import java.time.*;
import java.util.Date;

public class DateUtil {
    public static Month dateToMonth(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth();
    }

    public static int dateToYear(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
    }

    public static Date generateDate(int year, Month month, int dayOfMonth){
        return Date.from(LocalDate.of(year, month, dayOfMonth)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
