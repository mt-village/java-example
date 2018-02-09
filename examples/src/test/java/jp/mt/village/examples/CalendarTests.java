package jp.mt.village.examples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarTests {

    private SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private String toString(Calendar calendar) {
        return formater.format(calendar.getTime());
    }

    @Test
    public void getInstance() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getTime());
        System.out.println(toString(calendar));
        System.out.println("YEAR：" + calendar.get(Calendar.YEAR));
        System.out.println("MONTH：" + (calendar.get(Calendar.MONTH) + 1)); // MONTHは0始まり
        System.out.println("DATE：" + calendar.get(Calendar.DATE));
    }

    @Test
    public void convert() {
        Date date = Calendar.getInstance().getTime();
//        Calendar calendar = Calendar.getInstance().setTime(new Date());
    }

    @Test
    public void set() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(toString(calendar));

        calendar.set(Calendar.YEAR, 2019);
        System.out.println("年に2018年を設定：" + toString(calendar));

        calendar.set(Calendar.MONTH, 9);
        System.out.println("月に10月を設定：" + toString(calendar));

        calendar.set(Calendar.DATE, 5);
        System.out.println("日に5日を設定：" + toString(calendar));

        calendar.set(2020,3,7);
        System.out.println("2020年4月7日に設定：" + toString(calendar));

        calendar.set(2020,3,7,11,10,59);
        System.out.println("2020年4月7日11時10分59秒に設定：" + toString(calendar));
    }

    @Test
    public void add() {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.YEAR, 1);
        System.out.println(toString(calendar));

        calendar.add(Calendar.MONTH, 1);
        System.out.println(toString(calendar));

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(toString(calendar));

        calendar.add(Calendar.YEAR, -5);
        System.out.println(toString(calendar));
    }
}
