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

public class gAndOzActivity extends AppCompatActivity {

    private EditText we2EditText;
    private Button g, oz;
    private TextView we2Result;
    private Button halpButton;
    private Intent halpButtonIntent;

    private AlertDialog.Builder we2Dialog;
    java.text.DecimalFormat weRound = new java.text.DecimalFormat("0.0");

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_and_oz);

        we2EditText = (EditText) findViewById(R.id.we2EditText);
        g = (Button) findViewById(R.id.grams);
        oz = (Button) findViewById(R.id.ounces);
        we2Result = (TextView) findViewById(R.id.result4ID);
        halpButton = (Button) findViewById(R.id.halp);


        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        we2EditText.setTypeface(myTypeFace);
        g.setTypeface(myTypeFace);
        oz.setTypeface(myTypeFace);
        we2Result.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);


        g.setOnClickListener (new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextWe2Val = we2EditText.getText().toString();

                if (editTextWe2Val.isEmpty() || editTextWe2Val.contains(error2) ||
                        editTextWe2Val.contains(error3) || editTextWe2Val.contains(error4) || editTextWe2Val.contains(error5) ||
                        editTextWe2Val.contains(error6) || editTextWe2Val.contains(error7) || editTextWe2Val.contains(error8) ||
                        editTextWe2Val.contains(error9) || editTextWe2Val.contains(error10) || editTextWe2Val.contains(error11) ||
                        editTextWe2Val.contains(error12) || editTextWe2Val.contains(error13) || editTextWe2Val.contains(error14) ||
                        editTextWe2Val.contains(error15) || editTextWe2Val.contains(error16) || editTextWe2Val.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    we2Dialog = new AlertDialog.Builder(gAndOzActivity. this);
                    //set Title
                    we2Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    we2Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    we2Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    we2Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = we2Dialog.create();

                    //Show Dialog
                    alertD.show();

                }  else  {

                    double doubleEditTextWe2Val = Double.parseDouble(editTextWe2Val);

                    double convertedWe2Val = convertToGrams(doubleEditTextWe2Val);

                    String finalWe2Result = String.valueOf(weRound.format(convertedWe2Val));

                    we2Result.setText(finalWe2Result + " g");

                }

            }
        });

        oz.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextWe2Val = we2EditText.getText().toString();

                if (editTextWe2Val.isEmpty() || editTextWe2Val.contains(error2) ||
                        editTextWe2Val.contains(error3) || editTextWe2Val.contains(error4) || editTextWe2Val.contains(error5) ||
                        editTextWe2Val.contains(error6) || editTextWe2Val.contains(error7) || editTextWe2Val.contains(error8) ||
                        editTextWe2Val.contains(error9) || editTextWe2Val.contains(error10) || editTextWe2Val.contains(error11) ||
                        editTextWe2Val.contains(error12) || editTextWe2Val.contains(error13) || editTextWe2Val.contains(error14) ||
                        editTextWe2Val.contains(error15) || editTextWe2Val.contains(error16) || editTextWe2Val.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    we2Dialog = new AlertDialog.Builder(gAndOzActivity. this);
                    //set Title
                    we2Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    we2Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    we2Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    we2Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = we2Dialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditWe2Val = Double.parseDouble(editTextWe2Val);

                    double convertedWe2Val = convertToOunces(doubleEditWe2Val);

                    String finalWe2Result = String.valueOf(weRound.format(convertedWe2Val));

                    we2Result.setText(finalWe2Result + " oz");

                }

            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(gAndOzActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });

    }

    public double convertToGrams(double ozVal){

        //gramsResult = ozVal / 0.035274

        double gramsResult = 0;

        gramsResult = ozVal / 0.035274;

        return gramsResult;

    }

    public double convertToOunces(double gVal){

        //ounces = gVal * 0.035274

        double ouncesResult = 0;

        ouncesResult = gVal * 0.035274;

        return ouncesResult;

    }

}
