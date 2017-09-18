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

public class mAndftActivity extends AppCompatActivity {

    private EditText dis2EditText;
    private Button m, ft;
    private TextView result2;
    private AlertDialog.Builder dis2Dialog;
    private Button halpButton;
    private Intent halpButtonIntent;

    public EditText getDis2EditText() {
        return dis2EditText;
    }

    java.text.DecimalFormat roundy2 = new java.text.DecimalFormat("0.0");

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_andft);

        dis2EditText = (EditText) findViewById(R.id.dis2EditText);
        m = (Button) findViewById(R.id.meters);
        ft = (Button) findViewById(R.id.feet);
        result2 = (TextView) findViewById(R.id.result2ID2);
        halpButton = (Button) findViewById(R.id.halp);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        dis2EditText.setTypeface(myTypeFace);
        m.setTypeface(myTypeFace);
        ft.setTypeface(myTypeFace);
        result2.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);


        m.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String dis2EditTextVal = dis2EditText.getText().toString();

                if (dis2EditTextVal.isEmpty() || dis2EditTextVal.contains(error2) ||
                        dis2EditTextVal.contains(error3) || dis2EditTextVal.contains(error4) || dis2EditTextVal.contains(error5) ||
                        dis2EditTextVal.contains(error6) || dis2EditTextVal.contains(error7) || dis2EditTextVal.contains(error8) ||
                        dis2EditTextVal.contains(error9) || dis2EditTextVal.contains(error10) || dis2EditTextVal.contains(error11) ||
                        dis2EditTextVal.contains(error12) || dis2EditTextVal.contains(error13) || dis2EditTextVal.contains(error14) ||
                        dis2EditTextVal.contains(error15) || dis2EditTextVal.contains(error16) || dis2EditTextVal.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    dis2Dialog = new AlertDialog.Builder(mAndftActivity. this);
                    //set Title
                    dis2Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    dis2Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    dis2Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    dis2Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = dis2Dialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextDis2 = Double.parseDouble(dis2EditTextVal);

                    double convertedDis2Val = convertToMeters(doubleEditTextDis2);

                    String dis2FinalResult = String.valueOf(roundy2.format(convertedDis2Val));

                    result2.setText(dis2FinalResult + " m");

                }


            }
        });

        ft.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String dis2EditTextVal = dis2EditText.getText().toString();

                if (dis2EditTextVal.isEmpty() || dis2EditTextVal.contains(error2) ||
                        dis2EditTextVal.contains(error3) || dis2EditTextVal.contains(error4) || dis2EditTextVal.contains(error5) ||
                        dis2EditTextVal.contains(error6) || dis2EditTextVal.contains(error7) || dis2EditTextVal.contains(error8) ||
                        dis2EditTextVal.contains(error9) || dis2EditTextVal.contains(error10) || dis2EditTextVal.contains(error11) ||
                        dis2EditTextVal.contains(error12) || dis2EditTextVal.contains(error13) || dis2EditTextVal.contains(error14) ||
                        dis2EditTextVal.contains(error15) || dis2EditTextVal.contains(error16) || dis2EditTextVal.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    dis2Dialog = new AlertDialog.Builder(mAndftActivity. this);
                    //set Title
                    dis2Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    dis2Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    dis2Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    dis2Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = dis2Dialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextDis2 = Double.parseDouble(dis2EditTextVal);

                    double convertedDis2Val = convertToFeet(doubleEditTextDis2);

                    String dis2FinalResult = String.valueOf(roundy2.format(convertedDis2Val));

                    result2.setText(dis2FinalResult + " ft");

                }

            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(mAndftActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });


    }

    //---------Convert to meters and feet-----------------------------------------------------------

    public double convertToMeters(double ftVal){

        //m = ftVal / 3.2808

        double meterResult = 0;

        meterResult = ftVal / 3.2808;

        return meterResult;

    }

    public double convertToFeet(double mVal){

        //ft = mVal * 3.2808

        double feetResult = 0;

        feetResult = mVal * 3.2808;

        return feetResult;

    }
    //----------------------------------------------------------------------------------------------

}
