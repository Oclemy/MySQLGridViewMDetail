package com.tutorials.hp.mysqlgridviewmdetail.m_DetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.mysqlgridviewmdetail.R;
import com.tutorials.hp.mysqlgridviewmdetail.m_UI.PicassoClient;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt,propTxt,descTxt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        nameTxt= (TextView) findViewById(R.id.nameTxtDetail);
        descTxt= (TextView) findViewById(R.id.descDetailTxt);
        propTxt= (TextView) findViewById(R.id.propellantTxtDetail);
        img= (ImageView) findViewById(R.id.spacecraftImageDetail);

        //RECEIVE
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String propellant=i.getExtras().getString("PROPELLANT_KEY");
        String desc=i.getExtras().getString("DESCRIPTION_KEY");
        String imageurl=i.getExtras().getString("IMAGEURL_KEY");

        //BIND
        nameTxt.setText(name);
        propTxt.setText(propellant);
        descTxt.setText(desc);
        PicassoClient.downloadImage(this,imageurl,img);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
