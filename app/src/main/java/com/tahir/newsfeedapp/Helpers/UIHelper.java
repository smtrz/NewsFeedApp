package com.tahir.newsfeedapp.Helpers;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.Settings;

import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UIHelper {


    public static void showLongToastInCenter(Context ctx, int messageId) {

        if (ctx == null) return;

        Toast toast = Toast.makeText(ctx, messageId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLongToastInCenter(Context ctx, String message) {
        if (ctx == null) return;
//        message = Strings.nullToEmpty(message);
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLongToastInBottom(Context ctx, String message) {
        if (ctx == null) return;
//        message = Strings.nullToEmpty(message);
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public static void showShortToastInCenter(Context ctx, String message) {
        if (ctx == null) return;
//        message = Strings.nullToEmpty(message);


        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);


        toast.show();
    }

    public static void showShortToastInCenter(Context ctx, int message) {
        if (ctx == null) return;
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    public static void hideSoftKeyboard(Context context, EditText editText) {
        if (context == null) return;
        try {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Throwable t) {
        }

    }

    public static void hideSoftKeyboard(Context context, View view) {
        if (context == null) return;
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public static void showAlertDialog(String message, CharSequence title,
                                       Context context) {

        if (context == null) return;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setTitle(title)
                .setCancelable(true)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public static Rect locateView(View v) {
        int[] loc_int = new int[2];
        if (v == null)
            return null;
        try {
            v.getLocationOnScreen(loc_int);
        } catch (NullPointerException npe) {
            // Happens when the view doesn't exist on screen anymore.
            return null;
        }
        Rect location = new Rect();
        location.left = loc_int[0];
        location.top = loc_int[1];
        location.right = location.left + v.getWidth();
        location.bottom = location.top + v.getHeight();
        return location;
    }

    public static void textMarquee(TextView txtView) {
        txtView.setEllipsize(TruncateAt.END);
    }


    public static void dimBehind(Dialog dialog) {
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.9f;
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setCancelable(false);
    }


    public static String truncate(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len) + "...";
        } else {
            return str;
        }
    }


    public static void showSnackToast(View view, String message) {
        if (view == null) {
            return;
        }
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }


    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    public static void showSettingsDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivityForResult(intent, 101);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }


}