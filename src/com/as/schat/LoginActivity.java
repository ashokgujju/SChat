package com.as.schat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.ParseUser;

public class LoginActivity extends Activity{

	EditText mUsername;
	EditText mPassword;
	TextView  mSignUp;
	Button mLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		mUsername = (EditText) findViewById(R.id.username);
		mPassword = (EditText) findViewById(R.id.password);
		mLogin = (Button) findViewById(R.id.login_button);
		
		mLogin.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();
				
					
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					
					@Override
					public void done(ParseUser e, com.parse.ParseException arg1) {
						Toast.makeText(LoginActivity.this, "Wt the..", Toast.LENGTH_LONG).show();
						if(e == null) {
							Toast.makeText(LoginActivity.this, "I'm here", Toast.LENGTH_LONG).show();
							Intent i = new Intent(LoginActivity.this, MainActivity.class);
							startActivity(i);
						}
						else {
							Toast.makeText(LoginActivity.this, arg1.getMessage(), Toast.LENGTH_LONG).show();
						}
					}
				});
			}
		});
		
		mSignUp = (TextView) findViewById(R.id.signup);
		mSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(i);				
			}
		});
	}
}