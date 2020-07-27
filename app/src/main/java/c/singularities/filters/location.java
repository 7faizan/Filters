package c.singularities.filters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class location extends AppCompatActivity {
    private String userlocation = filterSuggestion.getvalue();

    TextView knowmore, tur, phV, car, msgs, ars, locsView;
    DatabaseReference getlocationvalues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        phV = findViewById(R.id.phvalue);
        tur = findViewById(R.id.turbudityvalue);
        car = findViewById(R.id.carbonatesvalue);
        ars = findViewById(R.id.arsenicvalue);
        msgs = findViewById(R.id.msg);
        knowmore = findViewById(R.id.know_more);
        locsView = findViewById(R.id.locationView);

        locsView.setText(userlocation);

        values();

        knowmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goweb = new Intent();
                goweb.setAction(Intent.ACTION_VIEW);
                goweb.setData(Uri.parse("https://bestchoices.site"));
                startActivity(goweb);
            }
        });
    }

    public void values() {
        getlocationvalues = FirebaseDatabase.getInstance().getReference().child(userlocation);
        getlocationvalues.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ph = dataSnapshot.child("ph").getValue().toString();
                String carbonate = dataSnapshot.child("carbonate").getValue().toString();
                String arsenic = dataSnapshot.child("arsenic").getValue().toString();
                String turbudity = dataSnapshot.child("turbudity").getValue().toString();
                String message = dataSnapshot.child("msg").getValue().toString();


                phV.setText(new StringBuilder().append(ph).append(" pH Value").toString());
                tur.setText(new StringBuilder().append(turbudity).append(" Turbudity value").toString());
                car.setText(new StringBuilder().append(carbonate).append(" Carbonate Value").toString());
                ars.setText(new StringBuilder().append(arsenic).append(" Arsenic Value").toString());
                userlocation="null";
                msgs.setText(message);


                Toast.makeText(location.this, "Realtime values", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });



    }

}
