package superunitconverter.nexmii.com.superunitconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DistanceActivity extends AppCompatActivity {

    private TextView distanceTitle;
    private Button kmAndMi, mAndft, cmAndin;
    private Intent kmAndMiIntent, mAndftIntent, cmAndinIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        distanceTitle = (TextView) findViewById(R.id.distanceTitle);
        kmAndMi = (Button) findViewById(R.id.kmANDmi);
        mAndft = (Button) findViewById(R.id.mANDft);
        cmAndin = (Button) findViewById(R.id.cmANDin);

        //Fonts---------------------------------------------------------------------
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"courier.ttf");
        distanceTitle.setTypeface(myTypeface);
        kmAndMi.setTypeface(myTypeface);
        mAndft.setTypeface(myTypeface);
        cmAndin.setTypeface(myTypeface);
        //--------------------------------------------------------------------------

        kmAndMi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                kmAndMiIntent = new Intent(DistanceActivity. this, KmAndMiActivity.class);
                startActivity(kmAndMiIntent);

            }
        });

        mAndft.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                mAndftIntent = new Intent(DistanceActivity. this, mAndftActivity.class);
                startActivity(mAndftIntent);

            }
        });

        cmAndin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                cmAndinIntent = new Intent(DistanceActivity. this, cmAndinActivity.class);
                startActivity(cmAndinIntent);

            }
        });

    }
}
