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

import java.text.DecimalFormat;

public class TemperatureActivity extends AppCompatActivity {

    private EditText myEditText;
    private Button celsiusBtn, fahBtn;
    private Button halpButton;
    private Intent halpButtonIntent;
    private TextView showResult;

    private AlertDialog.Builder theDialog;

    String  error2 = "..", error3 = "...", error4 = "....", error5 = ".....",
            error6 = "......", error7 = ".......", error8 = "........", error9 = ".........",
            error10 = "..........", error11 = "...........", error12 = "............",
            error13 = ".............", error14 = "..............", error15 = "...............",
            error16 = "................", error17 = ".................";

    DecimalFormat roundy = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        myEditText = (EditText) findViewById (R.id.editTextID);
        celsiusBtn = (Button) findViewById (R.id.celisusID);
        fahBtn = (Button) findViewById (R.id.fahrenheitID);
        showResult = (TextView) findViewById (R.id.resultID);
        halpButton = (Button) findViewById (R.id.halp);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        myEditText.setTypeface(myTypeFace);
        celsiusBtn.setTypeface(myTypeFace);
        fahBtn.setTypeface(myTypeFace);
        showResult.setTypeface(myTypeFace);
        halpButton.setTypeface(myTypeFace);

        celsiusBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = myEditText.getText().toString();
                if (editTextVal.isEmpty() || editTextVal.contains(error2) ||
                        editTextVal.contains(error3) || editTextVal.contains(error4) || editTextVal.contains(error5) ||
                        editTextVal.contains(error6) || editTextVal.contains(error7) || editTextVal.contains(error8) ||
                        editTextVal.contains(error9) || editTextVal.contains(error10) || editTextVal.contains(error11) ||
                        editTextVal.contains(error12) || editTextVal.contains(error13) || editTextVal.contains(error14) ||
                        editTextVal.contains(error15) || editTextVal.contains(error16) || editTextVal.contains(error17)){
                    //In case no value is placed, handle error with alert dialog
                    theDialog = new AlertDialog.Builder(TemperatureActivity. this);
                    //set Title
                    theDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set message
                    theDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    theDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //cancel dialog Box
                                    theDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = theDialog.create();

                    //Show Dialog
                    alertD.show();

                } else {

                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToCelsius(doubleEditText);

                    String finalResult = String.valueOf(roundy.format(convertedVal));

                    showResult.setText(finalResult + " °C");
                }

            }
        });

        fahBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String editTextVal = myEditText.getText().toString();
                if (editTextVal.isEmpty() || editTextVal.contains(error2) ||
                        editTextVal.contains(error3) || editTextVal.contains(error4) || editTextVal.contains(error5) ||
                        editTextVal.contains(error6) || editTextVal.contains(error7) || editTextVal.contains(error8) ||
                        editTextVal.contains(error9) || editTextVal.contains(error10) || editTextVal.contains(error11) ||
                        editTextVal.contains(error12) || editTextVal.contains(error13) || editTextVal.contains(error14) ||
                        editTextVal.contains(error15) || editTextVal.contains(error16) || editTextVal.contains(error17)) {

                    //Again, in case no value is placed, handle error with alert dialog
                    theDialog = new AlertDialog.Builder(TemperatureActivity. this);
                    //set Title
                    theDialog.setTitle(getResources().getString(R.string.dialog_title));
                    //set Message
                    theDialog.setMessage(getResources().getString(R.string.dialog_message));
                    //set cancelable
                    theDialog.setNegativeButton(getResources().getString(R.string.negativeButton),
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    theDialog.setCancelable(true);

                                }
                            });

                    //Create Dialog
                    AlertDialog alertD = theDialog.create();

                    //Show Dialog
                    alertD.show();


                } else {

                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(doubleEditText);

                    String finalResult = String.valueOf(roundy.format(convertedVal));

                    showResult.setText(finalResult + " °F");

                }

            }
        });

        halpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                halpButtonIntent = new Intent(TemperatureActivity. this, HelpActivity. class);
                startActivity(halpButtonIntent);

            }
        });

    }

    //-----Convert to celsius and fahrenheit mathematical ops-------------------------
    public double convertToCelsius(double fahVal){

        //[°C] = ([°F]-32) * 5/9 --> From Fahrenheit to celsius

        double resultCelsius = 0;

        resultCelsius = ( fahVal - 32 ) * 5 / 9;

        return resultCelsius;

    }

    public double convertToFahrenheit(double celVal){

        //[°F] = [°C] * 9/5 + 32 --> From Celsius to Fahrenheit
        double resultFahrenheit = 0;

        resultFahrenheit = celVal * ( 9 / 5 ) + 32;

        return resultFahrenheit;

    }
    //----------------------------------------------------------------

}
