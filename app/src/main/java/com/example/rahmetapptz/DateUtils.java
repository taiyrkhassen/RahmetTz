package com.example.rahmetapptz;


import org.joda.time.DateTime;

import java.util.Calendar;

public class DateUtils {
    public static int getCurrentDayOfWeek(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK);
    }
    public static boolean isCurrentDateInInterval(String start, String end){
        int startHours = Integer.parseInt(start.substring(0,2));
        if(start.substring(0,2).equals("00"))
            startHours = 24;
        int endHours = Integer.parseInt(end.substring(0,2));
        if(end.substring(0,2).equals("00"))
            endHours = 24;
        int currentHours = Integer.parseInt(getCurrentDate().substring(0,2));

        if(startHours <= currentHours && currentHours <= endHours )
            return true;

        return false;
    }
     private static String getCurrentDate(){
        DateTime jodaTime = new DateTime();
        String hours = jodaTime.getHourOfDay() + "";
        // convert to kazakhstan time
        hours = (Integer.parseInt(hours) + 6)%24 + "";
        if(hours.equals(String.valueOf(0)))
            hours = "24";
        if(hours.length() == 1)
            hours = "0" + hours;
        String minutes = jodaTime.getMinuteOfHour() + "";
        if(minutes.length() == 1)
            minutes = "0" + minutes;
        return hours + ":" + minutes;
    }
}
