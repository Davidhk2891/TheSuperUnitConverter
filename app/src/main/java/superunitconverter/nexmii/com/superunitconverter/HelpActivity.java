package superunitconverter.nexmii.com.superunitconverter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView halps1, halps2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        halps1 = (TextView) findViewById(R.id.halpy1);
        halps2 = (TextView) findViewById(R.id.halpy2);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"courier.ttf");
        halps1.setTypeface(myTypeFace);
        halps2.setTypeface(myTypeFace);

    }
}
