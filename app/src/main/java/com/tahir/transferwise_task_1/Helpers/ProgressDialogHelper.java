package com.tahir.transferwise_task_1.Helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;


public class ProgressDialogHelper {

    public static ProgressDialog showDialog(Context c) {
        ProgressDialog pd = new ProgressDialog(c);
        pd.setMessage("loading....please wait");
        pd.show();

        return pd;
    }

    public static void cancelDialog(ProgressDialog pDialog) {


        pDialog.cancel();
    }
}
