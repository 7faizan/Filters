package c.singularities.filters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class userLocation extends AppCompatActivity {
TextView abc;
private static String userlocation=filterSuggestion.getvalue();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);
        abc=findViewById(R.id.abc);
        //intent loc = getIntent();
       // String lo = getIntent().getStringExtra("locatio");
        abc.setText(userlocation);
    }
}