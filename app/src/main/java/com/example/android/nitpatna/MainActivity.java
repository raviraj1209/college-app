package com.example.android.nitpatna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int noOfContest = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//making a function so all can use
    public String sumaarydetail() {
        CheckBox hostelCheckBox = (CheckBox) findViewById(R.id.hostel);
        boolean hostelFee = hostelCheckBox.isChecked();

        CheckBox messCheckBox = (CheckBox) findViewById(R.id.mess);
        boolean messFee = messCheckBox.isChecked();

        EditText nameEditText = (EditText) findViewById(R.id.yourName);
        String nameStr = nameEditText.getText().toString();

        EditText rollEditText = (EditText) findViewById(R.id.yourRoll);
        String rollStr = rollEditText.getText().toString();

        int netFee = calculatetotalfee(hostelFee, messFee);

        String detailsMessage = TotalFeeDetail(nameStr, rollStr, hostelFee, messFee, noOfContest, netFee);
        displayfee(detailsMessage);

        return nameStr;

    }

    public void save(View view) {

//        CheckBox hostelCheckBox = (CheckBox) findViewById(R.id.hostel);
//        boolean hostelFee = hostelCheckBox.isChecked();
//
//        CheckBox messCheckBox = (CheckBox) findViewById(R.id.mess);
//        boolean messFee = messCheckBox.isChecked();
//
//        EditText nameEditText = (EditText) findViewById(R.id.yourName);
//        String nameStr = nameEditText.getText().toString();
//
//        EditText rollEditText = (EditText) findViewById(R.id.yourRoll);
//        String rollStr = rollEditText.getText().toString();
//
//        int netFee = calculatetotalfee(hostelFee, messFee);

//        String detailsMessage = TotalFeeDetail(nameStr, rollStr, hostelFee, messFee, noOfContest, netFee);
//        using a function to not write those stuff again and again
        sumaarydetail();

    }

    public void goToemail(View V) {

//        CheckBox hostelCheckBox = (CheckBox) findViewById(R.id.hostel);
//        boolean hostelFee = hostelCheckBox.isChecked();
//
//        CheckBox messCheckBox = (CheckBox) findViewById(R.id.mess);
//        boolean messFee = messCheckBox.isChecked();
//
        EditText nameEditText = (EditText) findViewById(R.id.yourName);
        String nameStr = nameEditText.getText().toString();
//
//        EditText rollEditText = (EditText) findViewById(R.id.yourRoll);
//        String rollStr = rollEditText.getText().toString();
//
//        int netFee = calculatetotalfee(hostelFee, messFee);
//
//        String detailsMessage = TotalFeeDetail(nameStr, rollStr, hostelFee, messFee, noOfContest, netFee);

        sumaarydetail();



        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Details "+ nameStr);
        intent.putExtra(Intent.EXTRA_TEXT, sumaarydetail());
        startActivity(intent);
    }







    private String TotalFeeDetail(String nameStr, String rollStr, boolean hostelFee, boolean messFee, int noOfContest, int calculatetotalfee){
        String detailsMessage ;
        detailsMessage = "Name :-" + nameStr ;
        detailsMessage += "\nRoll No :-" + rollStr ;
        if (hostelFee)
          detailsMessage += "\nHostel Fee = 9000";
        if (messFee)
            detailsMessage += "\nMess Fee = 16000" ;
        detailsMessage += "\nNo of contest won :-" + noOfContest ;
        detailsMessage += "\nFee Reducable :-" + (noOfContest * 1500);
        detailsMessage += "\nNet fee to paid :-" + calculatetotalfee ;
        detailsMessage += "\nThank Your for submit your detail.\nfrom NITP";
        return detailsMessage ;

    }

    public void increment(View view){
        noOfContest = noOfContest + 1;
        if (noOfContest > 10){
            noOfContest = 10;
            Toast.makeText(this,"You cannot have more than 10 wons",Toast.LENGTH_SHORT).show();
        }
        display(noOfContest);
    }

    public void decrement(View view){
        noOfContest = noOfContest - 1;
        if (noOfContest < 0){
            noOfContest = 0;
            Toast.makeText(this,"You cannot have less than 0 wons",Toast.LENGTH_SHORT).show();
        }
        display(noOfContest);
    }

    public int calculatetotalfee(boolean hostelFee, boolean messFee){
       int fees = 65500;
       if (hostelFee)
           fees = fees + 9000 ;
       if (messFee)
           fees= fees + 16000;
       fees = fees - (noOfContest * 1500);
       return fees;
    }

    private void display(int number){
        TextView contestFee = (TextView) findViewById(R.id.contest_won);
        contestFee.setText("" +number);
    }

    private void displayfee(String message){
        TextView displayfeeTextView = (TextView) findViewById(R.id.deduct);
         displayfeeTextView.setText(message);
    }

    public void hello(View view){
        Toast.makeText(this,"You opened the number lists",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, NumberActivity.class);
        startActivity(i);
    }
}