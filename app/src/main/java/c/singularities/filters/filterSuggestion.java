package c.singularities.filters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class filterSuggestion extends AppCompatActivity {
    private static String lo;
    public static  String getvalue(){
        return lo;
    }
    DatabaseReference availableLocation;

    Button locate;
    EditText locs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_suggestion);
        locate = findViewById(R.id.getToLocation);
        locs = findViewById(R.id.search);


        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 lo = locs.getText().toString();
               /* availableLocation = FirebaseDatabase.getInstance().getReference().child("locations");
                availableLocation.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });*/


                if (lo.isEmpty()) {
                    locs.setError("enter the location");
                    locs.requestFocus();
                    return;
                }

                if (lo.equals("hebbal")) {
                    Intent loc = new Intent(getApplicationContext(), location.class);
                    startActivity(loc);
                    Toast.makeText(filterSuggestion.this, "your location is " + lo, Toast.LENGTH_SHORT).show();
                }else if (lo.equals("yelhanka")) {
                    Intent loc = new Intent(getApplicationContext(), location.class);
                    startActivity(loc);
                    Toast.makeText(filterSuggestion.this, "your location is "+ lo, Toast.LENGTH_SHORT).show();

                }  else {
                    Toast.makeText(filterSuggestion.this, lo + " coming soon", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
