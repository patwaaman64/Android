package com.example.firebase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
EditText name,age,newuser,newpassword;
String sname,sage,snewuser,snewpassword;
FirebaseDatabase firebaseDatabase;
FirebaseAuth auth;
    private static final String TAG = "EmailPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        newuser=findViewById(R.id.newusername);
        newpassword=findViewById(R.id.newpassword);
        firebaseDatabase=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
    }

    public void signin(View view) {
        Intent intent=new Intent(register.this,MainActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        sname=name.getText().toString();
        sage=age.getText().toString();
        snewpassword=newpassword.getText().toString();
        snewuser=newuser.getText().toString();
        auth.createUserWithEmailAndPassword(snewuser, snewpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Users users =new Users(sname,sage,snewuser,snewpassword);
                            String id=task.getResult().getUser().getUid();
                            firebaseDatabase.getReference().child("Users").child(id).setValue(users);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
}