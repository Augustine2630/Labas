package com.aug.labas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class NewDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Вернуться на главный экран?");
        builder.setPositiveButton("Да", (dialog, id) -> {
            returnToMain();
        });
        builder.setNegativeButton("Нет", (dialog, id) -> dialog.cancel());
        return builder.create();
    }

    public void returnToMain(){
        Intent i= new Intent(getContext() , MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onStop();
    }
}