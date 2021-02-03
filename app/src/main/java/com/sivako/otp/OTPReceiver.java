package com.sivako.otp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

public class OTPReceiver extends BroadcastReceiver
{
    private static EditText editText;

    public void setEditText(EditText editText) {
        Log.d("LOG", "OTPReciever.editText = editText;");
        OTPReceiver.editText = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        Log.d("LOG", "Telephony.Sms.Intents.getMessagesFromIntent(intent)");

        for (SmsMessage sms : messages) {
            String message = sms.getMessageBody();
            String otp = message.replaceAll("\\D+", ""); //.split(": ")[1];
            editText.setText(otp);
        }
    }
}
