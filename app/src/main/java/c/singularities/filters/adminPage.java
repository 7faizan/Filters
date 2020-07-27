package c.singularities.filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class adminPage extends AppCompatActivity {
    TextView borewellOne,borewell2,borewell3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        borewellOne=findViewById(R.id.borewell1);
        borewellOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adm=new Intent(view.getContext(),borewell.class);
                startActivity(adm);
                // Toast.makeText(this,"admin login here",Toast.LENGTH_SHORT).show();
            }
        });
        borewell2=findViewById(R.id.borewell2);
        borewell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u=new Intent(view.getContext(),borewelltwo.class);
                startActivity(u);


            }
        });


    }
}
