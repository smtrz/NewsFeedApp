package com.tahir.transferwise_task_1.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateHelper {

    public static String calculateDateDifference(String newsDate) {
        String difference = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date newsdate = dateFormat.parse(newsDate);
            Date now = new Date();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - newsdate.getTime());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - newsdate.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - newsdate.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - newsdate.getTime());
            if (seconds < 60) {
                difference = seconds + " seconds ago";

            } else if (minutes < 60) {
                difference = minutes + " minutes ago";

            } else if (hours < 24) {
                difference = hours + " hours ago";

            } else {
                difference = days + " days ago";

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference;
    }
}
