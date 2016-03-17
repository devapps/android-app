package app.simplypay.demoapp.infrastructure.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import app.simplypay.demoapp.R;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
    ImageView app_icon;
    Animation translate;
    TextView app_name;
    EditText mobile_number;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        app_icon=(ImageView)findViewById(R.id.imageView1);
        translate= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.translate_effect);

        mobile_number=(EditText)findViewById(R.id.editText1);
        login=(Button)findViewById(R.id.button1);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub


                Animation animTranslate = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_effect);
                animTranslate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                    }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        //  LoginBox.setVisibility(View.VISIBLE);
                        Animation animFade = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade_in);
                        //  LoginBox.startAnimation(animFade);
                        mobile_number.setVisibility(View.VISIBLE);
                        login.setVisibility(View.VISIBLE);

                        mobile_number.startAnimation(animFade);
                        login.startAnimation(animFade);


                    }
                });
                ImageView imgLogo = (ImageView) findViewById(R.id.imageView1);
                imgLogo.startAnimation(animTranslate);


                //app_icon.startAnimation(translate);
            }
        }, 2000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
