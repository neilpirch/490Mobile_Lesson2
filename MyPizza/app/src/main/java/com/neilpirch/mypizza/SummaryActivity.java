package com.neilpirch.mypizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();
        String orderSummary = intent.getExtras().getString("orderSummary");
        TextView userNameView = (TextView) findViewById(R.id.user_name);
        userNameView.setText("name");
        TextView summaryTextView = (TextView) findViewById(R.id.txtSummary);
        summaryTextView.setText(orderSummary);
    }

    public void orderButton(View view) {
        TextView summaryTextView = (TextView) findViewById(R.id.txtSummary);
        String summary = summaryTextView.getText().toString();
        TextView userNameView = (TextView) findViewById(R.id.user_name);
        String userInputName = userNameView.getText().toString();

        // intent to summary activity
        sendEmail(userInputName, summary);

    }


    public void sendEmail(String name, String output) {
        // Write the relevant code for triggering email

        // Hint to accomplish the task
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, name + "@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Order");
        intent.putExtra(Intent.EXTRA_TEXT, output);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
