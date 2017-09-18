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

public class KmAndMiActivity extends AppCompatActivity {

    private EditText disEditText;
    private Button km, mi;
    private TextView result;
    private AlertDialog.Builder disDialog;
    private Button halpButton;
    private Intent halpButtonIntent;

    java.text.DecimalFormat roundy = new java.text.DecimalFormat("0.0");

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_and_mi);

        disEditText = (EditText) findViewById(R.id.disEditText);
        km = (Button) findViewById(R.id.Kilometers);
        mi = (Button) findViewById(R.id.Miles);
        result = (TextView) findViewById(R.id.result2ID);
        halpButton = (Button) findViewById(R.id.halp);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        disEditText.setTypeface(myTypeFace);
        km.setTypeface(myTypeFace);
        mi.setTypeface(myTypeFace);
        result.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);



        km.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = disEditText.getText().toString();

                if (editTextVal.isEmpty() || editTextVal.contains(error2) ||
                        editTextVal.contains(error3) || editTextVal.contains(error4) || editTextVal.contains(error5) ||
                        editTextVal.contains(error6) || editTextVal.contains(error7) || editTextVal.contains(error8) ||
                        editTextVal.contains(error9) || editTextVal.contains(error10) || editTextVal.contains(error11) ||
                        editTextVal.contains(error12) || editTextVal.contains(error13) || editTextVal.contains(error14) ||
                        editTextVal.contains(error15) || editTextVal.contains(error16) || editTextVal.contains(error17)){
                    //In case no value is placed, handle error with alert dialog
                    disDialog = new AlertDialog.Builder(KmAndMiActivity. this);
                    //set Title
                    disDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    disDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    disDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    disDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = disDialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextDis = Double.parseDouble(editTextVal);

                    double convertedDisVal = convertToKilometers(doubleEditTextDis);

                    String disFinalResult = String.valueOf(roundy.format(convertedDisVal));

                    result.setText(disFinalResult + " Km");


                }
            }
        });

        mi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = disEditText.getText().toString();

                if (editTextVal.isEmpty() || editTextVal.contains(error2) ||
                        editTextVal.contains(error3) || editTextVal.contains(error4) || editTextVal.contains(error5) ||
                        editTextVal.contains(error6) || editTextVal.contains(error7) || editTextVal.contains(error8) ||
                        editTextVal.contains(error9) || editTextVal.contains(error10) || editTextVal.contains(error11) ||
                        editTextVal.contains(error12) || editTextVal.contains(error13) || editTextVal.contains(error14) ||
                        editTextVal.contains(error15) || editTextVal.contains(error16) || editTextVal.contains(error17)) {
                    //In case no value is placed, handle error with alert dialog
                    disDialog = new AlertDialog.Builder(KmAndMiActivity.this);
                    //set Title
                    disDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    disDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    disDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    disDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = disDialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditText =  Double.parseDouble(editTextVal);

                    double convertedVal = convertToMiles(doubleEditText);

                    String disFinalResult = String.valueOf(roundy.format(convertedVal));

                    result.setText(disFinalResult + " Mi");

                }
            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(KmAndMiActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });

    }
    //-------convert to kilometers and miles-----------------------
    public double convertToMiles(double kmVal){

        // mi = km * 0.62137

        double milesResult =  0;

        milesResult = kmVal * 0.62137;

        return milesResult;
    }

    public double convertToKilometers(double miVal) {

        // km = mi / 0.62137

        double kilometersResult = 0;

        kilometersResult = miVal / 0.62137;

        return kilometersResult;

    }
//--------------------------------------------------------------

}
