package com.as.schat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
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
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_login);
		setProgressBarIndeterminateVisibility(false);
		
		mUsername = (EditText) findViewById(R.id.username);
		mPassword = (EditText) findViewById(R.id.password);
		mLogin = (Button) findViewById(R.id.login_button);
		mLogin.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				setProgressBarIndeterminateVisibility(true);
				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					
					@Override
					public void done(ParseUser user, com.parse.ParseException e) {
						if(e == null) {							
							Intent i = new Intent(LoginActivity.this, MainActivity.class);
							i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
							startActivity(i);
						}
						else {
							mUsername.setText("");
							mPassword.setText("");
							Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
						}
						setProgressBarIndeterminateVisibility(false);
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