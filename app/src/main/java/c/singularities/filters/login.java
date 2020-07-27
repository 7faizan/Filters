package c.singularities.filters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText emailid, password;
    Button signup, backToAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailid = findViewById(R.id.Emailid);
        password = findViewById(R.id.password);

        signup = findViewById(R.id.signup);
        backToAdmin = findViewById(R.id.backToAdmin);
        backToAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mai=new Intent(view.getContext(),MainActivity.class);
                startActivity(mai);
                Toast.makeText(login.this, "our service is Trusted service", Toast.LENGTH_SHORT).show();

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                if ((email.isEmpty()) && (pwd.isEmpty())) {
                    /*emailid.setError("enter the email");
                    emailid.requestFocus();
                    password.setError("enter the password");
                    password.requestFocus();*/
                    Toast.makeText(login.this, "please enter email and password", Toast.LENGTH_SHORT).show();
                } else if (pwd.isEmpty()) {
                    password.setError("enter the password");
                    password.requestFocus();
                } else if (email.isEmpty()) {
                    emailid.setError("enter the email");
                    emailid.requestFocus();
                } else if (!(email.isEmpty()) && !(pwd.isEmpty()))
                {
                    if(email.equals("faizan@borewell.com") &&(pwd.equals("12345"))) {
                        Intent bor=new Intent(view.getContext(),adminPage.class);
                        startActivity(bor);
                        Toast.makeText(login.this, "sign up successful", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (email !=("faizan@borewell.com") && (pwd !=("12345"))) {
                        Toast.makeText(login.this, "sign up unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }





            }
        });
    }
}