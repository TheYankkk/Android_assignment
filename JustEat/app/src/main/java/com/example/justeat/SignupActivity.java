package com.example.justeat;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justeat.service.UserService;

public class SignupActivity extends Activity {
    EditText username;
    EditText password;
    EditText password_confirm;
    Button sign_up_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean cancel = false;
                View focusView = null;
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String confirm = password_confirm.getText().toString().trim();

                //reset error
                username.setError(null);
                password.setError(null);
                password_confirm.setError(null);


                //check account
                if (TextUtils.isEmpty(name)) {
                    username.setError(getString(R.string.error_field_required));
                    focusView = username;
                    cancel = true;
                } else if (!UserUtils.isUsernameValid(name)) {
                    username.setError(getString(R.string.error_invalid_account));
                    focusView = username;
                    cancel = true;
                }

                //check password

                if (TextUtils.isEmpty(pass)) {
                    password.setError(getString(R.string.error_field_required));
                    focusView = password;
                    cancel = true;
                } else if (!UserUtils.isPasswordValid(pass)) {
                    password.setError(getString(R.string.error_invalid_password));
                    focusView = password;
                    cancel = true;
                }

                //check confirm
                if (TextUtils.isEmpty(confirm)) {
                    password_confirm.setError(getString(R.string.error_field_required));
                    focusView = password_confirm;
                    cancel = true;
                } else if (!pass.equals(confirm)) {
                    password_confirm.setError(getString(R.string.error_password_different));
                    focusView = password_confirm;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {
                    //start login progress
                    Log.i("TAG", name + "_" + pass);
                    UserService uService = new UserService(SignupActivity.this);
                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(pass);
                    uService.register(user);
                    Toast.makeText(SignupActivity.this, "register success", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void findViews() {
            username = (EditText) findViewById(R.id.username);
            password = (EditText) findViewById(R.id.password);
            password_confirm = (EditText) findViewById(R.id.password_confirm);
            sign_up_button = (Button) findViewById(R.id.sign_up_button);
        }
    }

            /**  private UserSignupTask mSignUpTask = null;
    TopBar mTopBar;
    private ProgressDialog dialog;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Utils.setStatusBarColor(SignupActivity.this, Color.rgb(0,0,0),true);

        mTopBar = (TopBar) findViewById(R.id.topbar);
        mTopBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void titleClick() {
                finish();
            }

            @Override
            public void menuClick() {
                //Toast.makeText(SignupActivity.this,"You clicked the menu button",Toast.LENGTH_SHORT).show();
            }
        });
        //mTopBar.setMenuButtonVisible(false);

        mUsername = (EditText) findViewById(R.id.username);
        Drawable ic_user = getResources().getDrawable(R.mipmap.ic_user,null);
        if (ic_user!=null)
            ic_user.setBounds(0,0,50,50);
        mUsername.setCompoundDrawables(ic_user,null,null,null);

        mPassword = (EditText) findViewById(R.id.password);
        Drawable ic_pass = getResources().getDrawable(R.mipmap.ic_pass,null);
        if (ic_pass!=null)
            ic_pass.setBounds(0,0,50,50);
        mPassword.setCompoundDrawables(ic_pass,null,null,null);

        mConfirm = (EditText) findViewById(R.id.password_confirm);
        Drawable ic_confirm = getResources().getDrawable(R.mipmap.ic_pass,null);
        if (ic_confirm!=null)
            ic_confirm.setBounds(0,0,50,50);
        mConfirm.setCompoundDrawables(ic_confirm,null,null,null);

        mSignUp = (Button) findViewById(R.id.sign_up_button);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SignupActivity","Attempt Sign up");
                attemptSignup();
            }
        });
    }





    private void showProgress(boolean show){
        if (show) {
            dialog=new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setTitle("注册中...");
            dialog.setMessage("请稍等");
            dialog.show();
        }
        else {
            dialog.hide();
        }
    }
    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.

    public class UserSignupTask extends AsyncTask<Void, Void, Boolean> {

        private final String email;
        private final String password;

        UserSignupTask(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgress(true);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            boolean result=false;
            try {
                result = UserUtils.signup(email,password);
            } catch (Exception e) {
                return false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mSignUpTask = null;
            showProgress(false);

            if (success) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setMessage(getString(R.string.error_username_occupied));
                builder.setPositiveButton("确定",null);
                builder.show();
                mUsername.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mSignUpTask = null;
            showProgress(false);
        }
    }
}
             */