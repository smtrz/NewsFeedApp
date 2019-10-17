package com.tahir.newsfeedapp.Helpers;

import android.content.Context;
import android.content.Intent;

public class GeneralHelper {


    public static void shareNews(String subject, String body, Context context) {
        Intent txtIntent = new Intent(android.content.Intent.ACTION_SEND);
        txtIntent .setType("text/plain");
        txtIntent .putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        txtIntent .putExtra(android.content.Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(txtIntent ,"Share"));
    }
}
