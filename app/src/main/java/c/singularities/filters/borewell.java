package c.singularities.filters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static c.singularities.filters.App.CHANNEL_1_ID;

public class borewell extends AppCompatActivity {
    TextView cur, vol, wat;
    Button ref;
    DatabaseReference getdat;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell);
        notificationManager = NotificationManagerCompat.from(this);


        cur = findViewById(R.id.currentVal);
        vol = findViewById(R.id.voltageVal);
        wat = findViewById(R.id.waterVal);
        cur.setText("1.5 Amps");
        vol.setText("5 volts");
        wat.setText("Low");
        ref = findViewById(R.id.refresh2);
        

    }

    public void send(View view) {
        Toast.makeText(borewell.this, "Realtime values", Toast.LENGTH_SHORT).show();

        getdat = FirebaseDatabase.getInstance().getReference().child("sensors");
        getdat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String curren = dataSnapshot.child("current").getValue().toString();
                String voltag = dataSnapshot.child("voltage").getValue().toString();
                String leve = dataSnapshot.child("level").getValue().toString();
                cur.setText(new StringBuilder().append(curren).append(" Amps").toString());
                vol.setText(new StringBuilder().append(voltag).append(" Volts").toString());
                wat.setText(leve);
                float a = Float.parseFloat(curren);
                float b = Float.parseFloat(voltag);

                if ((leve.equals("LOW")) || (a > 15) || (b > 210)) {
                    notif();
                }


                // Toast.makeText(borewell.this, "Realtime values", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

    }

    public void notif() {


        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.not)
                .setContentTitle("SWITCH OFF THE MOTOR")
                .setContentText("VOLTAGE or WATERLEVEL is Unexpected ")
                .setPriority(NotificationCompat.PRIORITY_HIGH);


// notificationId is a unique int for each notification that you must define
        notificationManager.notify(100, builder.build());
    }
}


