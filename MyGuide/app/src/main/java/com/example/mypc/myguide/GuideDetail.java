package com.example.mypc.myguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by my pc on 3/10/2016.
 */
public class GuideDetail extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView name_txt,email_txt,mobile_txt;
    Button call_bttn,email_bttn,message_bttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_detail);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView= (ImageView) findViewById(R.id.d_image);
        name_txt= (TextView) findViewById(R.id.d_name);
        email_txt= (TextView) findViewById(R.id.d_email);
        mobile_txt= (TextView) findViewById(R.id.d_mobile);

        call_bttn= (Button) findViewById(R.id.d_call);
        email_bttn= (Button) findViewById(R.id.d_send_email);
        message_bttn= (Button) findViewById(R.id.d_message);


        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
        name_txt.setText(getIntent().getStringExtra("guide_name"));
        email_txt.setText(getIntent().getStringExtra("email_id"));
        mobile_txt.setText(getIntent().getStringExtra("mobile_number"));

        call_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + getIntent().getStringExtra("mobile_number")));
                    startActivity(callIntent);
                } catch (SecurityException se) {
                    System.out.println(se.getMessage());
                }

            }
        });

        message_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + getIntent().getStringExtra("mobile_number")));
                    startActivity(callIntent);
                } catch (SecurityException se) {
                    System.out.println(se.getMessage());

                }

            }
        });

        email_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{getIntent().getStringExtra("email_id")});
                    //emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
                    emailIntent.setType("message/rfc822");
                    startActivity(emailIntent);

                } catch (SecurityException se) {
                    System.out.println(se.getMessage());
                }catch(ActivityNotFoundException anfe){
                    Toast.makeText(GuideDetail.this,"Sorry, no email client found!",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
