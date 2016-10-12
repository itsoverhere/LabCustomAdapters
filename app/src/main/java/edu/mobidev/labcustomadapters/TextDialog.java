package edu.mobidev.labcustomadapters;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;


/**
 * Created by student on 11/10/2016.
 */

public class TextDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String foodName = getArguments().getString(MainActivity.KEY_FOODNAME);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setTitle("Howdy")
                .setMessage("You chose " + foodName)
                .setPositiveButton("Thanks.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                })
                .create();
        return alertDialog;
    }

    public static TextDialog newInstance(String foodName){
        Bundle b  = new Bundle();
        b.putString(MainActivity.KEY_FOODNAME, foodName);
        TextDialog td = new TextDialog();
        td.setArguments(b);
        return td;
    }

}
