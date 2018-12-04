package com.example.paul_.foodappv2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paul_.foodappv2.Common.Common;
import com.example.paul_.foodappv2.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    //Field text in care introduc numarul si parola
    EditText editPassword,editPhone;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //Initializare Firebase

      final   FirebaseDatabase database = FirebaseDatabase.getInstance();
      final   DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                //Dialogul micut cu mesaje (Ex:Waiting , Loged in Successfully etc)
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Verificam daca userul exista/nu exista in baza de date

                        if(dataSnapshot.child(editPhone.getText().toString()).exists()) {
                            //Return la datele userului
                            mDialog.dismiss();
                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                            user.setPhone(editPhone.getText().toString()); //Setez userului nr de telefon;
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                Intent homeIntent = new Intent(SignIn.this,Home.class);
                                //cream o variabila in care stocam userul curent(la nivel de sesiune)
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();

                            } else {
                                Toast.makeText(SignIn.this, "Parola gresita !!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            {
                                mDialog.dismiss();
                                Toast.makeText(SignIn.this, "Cont inexistent . Vă rugăm să vă creați un cont nou", Toast.LENGTH_SHORT).show();
                                Intent signupIntent = new Intent(SignIn.this,SignUp.class);
                                startActivity(signupIntent);
                                finish();
                            }
                        }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}