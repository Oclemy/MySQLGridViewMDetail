package com.tutorials.hp.mysqlgridviewmdetail.m_UI;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tutorials.hp.mysqlgridviewmdetail.R;

/**
 * Created by Oclemy on 6/6/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class PicassoClient {

    public static void downloadImage(Context c,String imageUrl,ImageView img)
    {
        if(imageUrl!=null && imageUrl.length()>0)
        {
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.placeholder).into(img);
        }else {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }
}
