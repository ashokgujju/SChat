package com.as.schat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity{

	protected EditText mUsername;
	protected EditText mPassword;
	protected EditText mEmail;
	protected Button mSignUp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		mUsername = (EditText) findViewById(R.id.username_signup);
		mPassword = (EditText) findViewById(R.id.password_signup);
		mEmail = (EditText) findViewById(R.id.email);
		
		mSignUp = (Button) findViewById(R.id.signup_button);
		mSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();
				String email = mEmail.getText().toString();
				
				username = username.trim();
				password = password.trim();
				email = email.trim();
				
				if(username.isEmpty() || password.isEmpty() || email.isEmpty()) {
					AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
					builder.setMessage(R.string.signup_error_message);
					builder.setTitle(R.string.signup_error_title);
					builder.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				}
				else {
					ParseUser newuser = new ParseUser();
					newuser.setUsername(username);
					newuser.setPassword(password);
					newuser.setEmail(email);
					newuser.signUpInBackground(new SignUpCallback() {
						
						@Override
						public void done(com.parse.ParseException e) {
							if(e == null) {
								Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
								startActivity(i);
							}
						}
					});					
				}
			}
		});
	}
}