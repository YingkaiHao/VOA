package com.dbfinal.common;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

@Data
public class GenerateId {

    private static HashMap<String, int[]> map = new HashMap<>();

    public static String getId(String source, Timestamp date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        if (!map.containsKey(source) || map.get(source)[0] != year) {
            map.put(source, new int[] {year, 1});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(year));
        sb.append(String.valueOf(month));
        sb.append(String.valueOf(day));
        String number = String.valueOf(map.get(source)[1]);
//        for (int i = 0; i < 4 - number.length(); i++) {
//            number = "0" + number;
//        }
        sb.append(number);

        map.get(source)[1] = map.get(source)[1] + 1;

        return sb.toString();
    }
}
