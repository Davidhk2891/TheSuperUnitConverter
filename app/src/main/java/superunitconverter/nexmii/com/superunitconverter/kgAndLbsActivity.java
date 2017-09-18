package superunitconverter.nexmii.com.superunitconverter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kgAndLbsActivity extends AppCompatActivity {

    private EditText weEditText;
    private Button kg, lbs;
    private TextView weTextView;
    private Button halpButton;
    private Intent halpButtonIntent;

    private AlertDialog.Builder weDialog;

    java.text.DecimalFormat roundy = new java.text.DecimalFormat("0.0");

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg_and_lbs);

        weEditText = (EditText) findViewById(R.id.weEditText);
        kg = (Button) findViewById(R.id.Kilograms);
        lbs = (Button) findViewById(R.id.Pounds);
        weTextView = (TextView) findViewById(R.id.result3ID);
        halpButton = (Button) findViewById(R.id.halp);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        weEditText.setTypeface(myTypeFace);
        kg.setTypeface(myTypeFace);
        lbs.setTypeface(myTypeFace);
        weTextView.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);

        kg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextWeVal = weEditText.getText().toString();

                if(editTextWeVal.isEmpty() || editTextWeVal.contains(error2) ||
                        editTextWeVal.contains(error3) || editTextWeVal.contains(error4) || editTextWeVal.contains(error5) ||
                        editTextWeVal.contains(error6) || editTextWeVal.contains(error7) || editTextWeVal.contains(error8) ||
                        editTextWeVal.contains(error9) || editTextWeVal.contains(error10) || editTextWeVal.contains(error11) ||
                        editTextWeVal.contains(error12) || editTextWeVal.contains(error13) || editTextWeVal.contains(error14) ||
                        editTextWeVal.contains(error15) || editTextWeVal.contains(error16) || editTextWeVal.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    weDialog = new AlertDialog.Builder(kgAndLbsActivity. this);
                    //set Title
                    weDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    weDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    weDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    weDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = weDialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextWe = Double.parseDouble(editTextWeVal);

                    double convertWeVal = convertToKilograms(doubleEditTextWe);

                    String weFinalString = String.valueOf(roundy.format(convertWeVal));

                    weTextView.setText(weFinalString + " Kg");

                }

            }
        });

        lbs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextWeVal = weEditText.getText().toString();

                if(editTextWeVal.isEmpty() || editTextWeVal.contains(error2) ||
                        editTextWeVal.contains(error3) || editTextWeVal.contains(error4) || editTextWeVal.contains(error5) ||
                        editTextWeVal.contains(error6) || editTextWeVal.contains(error7) || editTextWeVal.contains(error8) ||
                        editTextWeVal.contains(error9) || editTextWeVal.contains(error10) || editTextWeVal.contains(error11) ||
                        editTextWeVal.contains(error12) || editTextWeVal.contains(error13) || editTextWeVal.contains(error14) ||
                        editTextWeVal.contains(error15) || editTextWeVal.contains(error16) || editTextWeVal.contains(error17) ){

                    //In case no value is placed, handle error with alert dialog
                    weDialog = new AlertDialog.Builder(kgAndLbsActivity. this);
                    //set Title
                    weDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    weDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    weDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    weDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = weDialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextWe = Double.parseDouble(editTextWeVal);

                    double convertedWeVal = convertToPounds(doubleEditTextWe);

                    String weFinalResult = String.valueOf(roundy.format(convertedWeVal));

                    weTextView.setText(weFinalResult + " lbs");

                }

            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(kgAndLbsActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });

    }
    //-----Convert to Kilograms and Pounds operations------------------------
    public double convertToKilograms(double lbsVal){

        //kg = lbs / 2.2046

        double kilogramsResult = 0;

        kilogramsResult = lbsVal / 2.2046;

        return kilogramsResult;

    }

    public double convertToPounds(double kgVal){

        //lbs = kg * 2.2046

        double poundsResult = 0;

        poundsResult = kgVal * 2.2046;

        return poundsResult;

    }
//---------------------------------------------------------------------



}
