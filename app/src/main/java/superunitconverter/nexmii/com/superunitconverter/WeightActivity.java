package superunitconverter.nexmii.com.superunitconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WeightActivity extends AppCompatActivity {

    private TextView weMainTitle;
    private Button kgAndlbs, gAndoz;
    private Intent kgAndlbsIntent, gAndozIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        weMainTitle = (TextView) findViewById(R.id.weMenuTitle);
        kgAndlbs = (Button) findViewById(R.id.KgANDLbs);
        gAndoz = (Button) findViewById(R.id.gANDoz);

        //fonts-----------------------------------------------------------------------
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"courier.ttf");
        weMainTitle.setTypeface(myTypeface);
        kgAndlbs.setTypeface(myTypeface);
        gAndoz.setTypeface(myTypeface);
        //----------------------------------------------------------------------------

        kgAndlbs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                kgAndlbsIntent = new Intent(WeightActivity. this, kgAndLbsActivity. class);
                startActivity(kgAndlbsIntent);

            }
        });

        gAndoz.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                gAndozIntent = new Intent(WeightActivity. this, gAndOzActivity.class);
                startActivity(gAndozIntent);

            }
        });

    }
}
