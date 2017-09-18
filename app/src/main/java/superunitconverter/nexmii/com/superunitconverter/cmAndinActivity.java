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

public class cmAndinActivity extends AppCompatActivity {

    private EditText dis3EditText;
    private Button cm, in;
    private Button halpButton;
    private Intent halpButtonIntent;
    private TextView result3;
    private AlertDialog.Builder dis3Dialog;

    java.text.DecimalFormat roundy3 = new java.text.DecimalFormat("0.0");

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_andin);

        dis3EditText = (EditText) findViewById(R.id.dis3EditText);
        cm = (Button) findViewById (R.id.centimeters);
        in = (Button) findViewById(R.id.inches);
        result3 = (TextView) findViewById(R.id.result3ID3);
        halpButton = (Button) findViewById(R.id.halp);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        dis3EditText.setTypeface(myTypeFace);
        cm.setTypeface(myTypeFace);
        in.setTypeface(myTypeFace);
        result3.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);

        cm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String dis3editTextVal = dis3EditText.getText().toString();

                if (dis3editTextVal.isEmpty() || dis3editTextVal.contains(error2) ||
                        dis3editTextVal.contains(error3) || dis3editTextVal.contains(error4) || dis3editTextVal.contains(error5) ||
                        dis3editTextVal.contains(error6) || dis3editTextVal.contains(error7) || dis3editTextVal.contains(error8) ||
                        dis3editTextVal.contains(error9) || dis3editTextVal.contains(error10) || dis3editTextVal.contains(error11) ||
                        dis3editTextVal.contains(error12) || dis3editTextVal.contains(error13) || dis3editTextVal.contains(error14) ||
                        dis3editTextVal.contains(error15) || dis3editTextVal.contains(error16) || dis3editTextVal.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    dis3Dialog = new AlertDialog.Builder(cmAndinActivity. this);
                    //set Title
                    dis3Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    dis3Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    dis3Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    dis3Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = dis3Dialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextDis3 = Double.parseDouble(dis3editTextVal);

                    double convertedDis3 = convertToCentimeters(doubleEditTextDis3);

                    String finalResultDis3 = String.valueOf(roundy3.format(convertedDis3));

                    result3.setText(finalResultDis3 + " cm");

                }

            }
        });

        in.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String dis3editTextVal = dis3EditText.getText().toString();

                if (dis3editTextVal.isEmpty() || dis3editTextVal.contains(error2) ||
                        dis3editTextVal.contains(error3) || dis3editTextVal.contains(error4) || dis3editTextVal.contains(error5) ||
                        dis3editTextVal.contains(error6) || dis3editTextVal.contains(error7) || dis3editTextVal.contains(error8) ||
                        dis3editTextVal.contains(error9) || dis3editTextVal.contains(error10) || dis3editTextVal.contains(error11) ||
                        dis3editTextVal.contains(error12) || dis3editTextVal.contains(error13) || dis3editTextVal.contains(error14) ||
                        dis3editTextVal.contains(error15) || dis3editTextVal.contains(error16) || dis3editTextVal.contains(error17)){

                    //In case no value is placed, handle error with alert dialog
                    dis3Dialog = new AlertDialog.Builder(cmAndinActivity. this);
                    //set Title
                    dis3Dialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    dis3Dialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    dis3Dialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    dis3Dialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = dis3Dialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditTextDis3 = Double.parseDouble(dis3editTextVal);

                    double convertedDis3Val = convertToInches(doubleEditTextDis3);

                    String finalResultDis3 = String.valueOf(roundy3.format(convertedDis3Val));

                    result3.setText(finalResultDis3 + " in");

                }

            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(cmAndinActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });

    }

    public double convertToCentimeters(double inVal) {

        //cm = inVal / 0.39370

        double centimetersResult = 0;

        centimetersResult = inVal / 0.39370;

        return centimetersResult;

    }

    public double convertToInches(double cmVal) {

        //in = cmVal * 0.39370

        double inchesResult = 0;

        inchesResult = cmVal * 0.39370;

        return inchesResult;
    }

}
