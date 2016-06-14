package com.tutorials.hp.mysqlgridviewmdetail.m_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import com.tutorials.hp.mysqlgridviewmdetail.m_DataObject.Spacecraft;
import com.tutorials.hp.mysqlgridviewmdetail.m_UI.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/6/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataParser extends AsyncTask<Void,Void,Boolean> {
    
    Context c;
    String jsonData;
    GridView gv;

    ProgressDialog pd;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

    public DataParser(Context c, String jsonData, GridView gv) {
        this.c = c;
        this.jsonData = jsonData;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing..Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute(parsed);

        pd.dismiss();

        if(parsed)
        {
            //BIND
            CustomAdapter adapter=new CustomAdapter(c,spacecrafts);
            gv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            spacecrafts.clear();
            Spacecraft spacecraft;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String prop=jo.getString("propellant");
                String desc=jo.getString("description");
                String imageUrl=jo.getString("imageurl");

                spacecraft=new Spacecraft();

                spacecraft.setId(id);
                spacecraft.setName(name);
                spacecraft.setPropellant(prop);
                spacecraft.setDescription(desc);
                spacecraft.setImageUrl(imageUrl);

                spacecrafts.add(spacecraft);

            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

}











