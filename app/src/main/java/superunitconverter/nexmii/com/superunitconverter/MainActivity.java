package superunitconverter.nexmii.com.superunitconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //HOW TO BUILD A COLOR PICKER TO CHANGE THE TEXT COLOR FOR THE WHOLE APP. TRIED FOR SEVERAL
    //HOURS BUT NOTHING WORKED. NEED TO TALK TO SOMEONE WITH MORE KNOWLEDGE.

    protected Button tempButton, disButton, weButton;
    protected Intent tempButtonIntent, disButtonIntent, weButtonIntent;
    protected TextView chooseCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempButton = (Button) findViewById(R.id.tempyButton);
        disButton = (Button) findViewById(R.id.disyButton);
        weButton = (Button) findViewById(R.id.weButton);
        chooseCat = (TextView) findViewById(R.id.chooseCat);

        //-----fonts-----------------------------------------------
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        tempButton.setTypeface(myTypeFace);
        disButton.setTypeface(myTypeFace);
        weButton.setTypeface(myTypeFace);
        chooseCat.setTypeface(myTypeFace);
        //---------------------------------------------------------

        tempButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                tempButtonIntent = new Intent (MainActivity.this, TemperatureActivity.class);
                startActivity(tempButtonIntent);

            }
        });

        disButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                disButtonIntent = new Intent (MainActivity.this, DistanceActivity.class);
                startActivity(disButtonIntent);

            }
        });

        weButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                weButtonIntent = new Intent (MainActivity.this, WeightActivity.class);
                startActivity(weButtonIntent);

            }
        });

    }

}
