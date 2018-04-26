package com.example.dell.task_force;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class show extends AppCompatActivity {

    private String TAG = show.class.getSimpleName();
    private ProgressDialog pDialog;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView1;
    static String city= "";
    static String country="";
     static int i;
    static int j=0;
    static int id=200;
    static String des="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        new GetWeather().execute();

    }

    public class GetWeather extends AsyncTask<Void, Void, Double> {

        Intent intent = getIntent();
        String p1=intent.getStringExtra(get.EXTRA_TEXT1);
        String p2=intent.getStringExtra(get.EXTRA_TEXT2);
        String t1=p2.toString();
        String t2=p1.toString();
        private String url ="http://api.openweathermap.org/data/2.5/weather?q="+t1+","+t2+"&appid=27cda6c32b5a9429145b008d0b23599f";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(show.this);
            pDialog.setMessage("please wait");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        public Double doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " +jsonStr);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject main1 = jsonObj.getJSONObject("main");
                    Double temp = main1.getDouble("temp");

                     JSONObject weather= new JSONObject(jsonStr);
                     JSONArray i = weather.getJSONArray("weather");
                        JSONObject ico =i.getJSONObject(0);
                        int iii= ico.getInt("id");
                         id=iii;
                  final String climate=ico.getString("main");
                  String descrip=ico.getString("description");
                  des=descrip;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    " " +climate,
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                      JSONObject cntry= new JSONObject(jsonStr);
                      JSONObject c=cntry.getJSONObject("sys");
                      String ctry =c.getString("country");
                        country=ctry;

                    JSONObject dis= new JSONObject(jsonStr);
                    String area=dis.getString("name");

                    city=area;


                    return temp;


                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "check your internet connection!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }
        public String idg(int id){
        String s="";
        switch (id) {
            case 200:
                s=getString(R.string.wi_owm_200);
                        break;
            case 201:
                s=getString(R.string.wi_owm_201);
                break;
            case 202:
                s=getString(R.string.wi_owm_202);
                break;
            case 210:
                s=getString(R.string.wi_owm_210);
                break;
            case 211:
                s=getString(R.string.wi_owm_211);
                break;
            case 212:
                s=getString(R.string.wi_owm_212);
                break;
            case 230:
                s=getString(R.string.wi_owm_230);
                break;
            case 231:
                s=getString(R.string.wi_owm_231);
                break;
            case 232:
                s=getString(R.string.wi_owm_232);
                break;
            case 300:
                s=getString(R.string.wi_owm_300);
                break;
            case 301:
                s=getString(R.string.wi_owm_301);
                break;
            case 302:
                s=getString(R.string.wi_owm_302);
                break;
            case 310:
                s=getString(R.string.wi_owm_310);
                break;
            case 311:
                s=getString(R.string.wi_owm_311);
                break;
            case 312:
                s=getString(R.string.wi_owm_312);
                break;
            case 313:
                s=getString(R.string.wi_owm_313);
                break;
            case 314:
                s=getString(R.string.wi_owm_314);
                break;
            case 321:
                s=getString(R.string.wi_owm_321);
                break;
            case 500:
                s=getString(R.string.wi_owm_500);
                break;
            case 501:
                s=getString(R.string.wi_owm_501);
                break;
            case 502:
                s=getString(R.string.wi_owm_502);
                break;
            case 503:
                s=getString(R.string.wi_owm_503);
                break;
            case 504:
                s=getString(R.string.wi_owm_504);
                break;
            case 511:
                s=getString(R.string.wi_owm_511);
                break;
            case 520:
                s=getString(R.string.wi_owm_520);
                break;
            case 521:
                s=getString(R.string.wi_owm_521);
                break;
            case 522:
                s=getString(R.string.wi_owm_522);
                break;
            case 531:
                s=getString(R.string.wi_owm_531);
                break;
            case 600:
                s=getString(R.string.wi_owm_600);
                break;
            case 601:
                s=getString(R.string.wi_owm_601);
                break;
            case 602:
                s=getString(R.string.wi_owm_602);
                break;
            case 611:
                s=getString(R.string.wi_owm_611);
                break;
            case 612:
                s=getString(R.string.wi_owm_612);
                break;
            case 615:
                s=getString(R.string.wi_owm_615);
                break;
            case 616:
                s=getString(R.string.wi_owm_616);
                break;
            case 620:
                s=getString(R.string.wi_owm_620);
                break;
            case 621:
                s=getString(R.string.wi_owm_621);
                break;
            case 622:
                s=getString(R.string.wi_owm_622);
                break;
            case 701:
                s=getString(R.string.wi_owm_701);
                break;
            case 711:
                s=getString(R.string.wi_owm_711);
                break;
            case 721:
                s=getString(R.string.wi_owm_721);
                break;
            case 731:
                s=getString(R.string.wi_owm_731);
                break;
            case 741:
                s=getString(R.string.wi_owm_741);
                break;
            case 761:
                s=getString(R.string.wi_owm_761);
                break;
            case 762:
                s=getString(R.string.wi_owm_762);
                break;
            case 771:
                s=getString(R.string.wi_owm_771);
                break;
            case 781:
                s=getString(R.string.wi_owm_781);
                break;
            case 800:
                s=getString(R.string.wi_owm_800);
                break;
            case 802:
                s=getString(R.string.wi_owm_802);
                break;
            case 803:
                s=getString(R.string.wi_owm_803);
                break;
            case 801:
                s=getString(R.string.wi_owm_801);
                break;
            case 804:
                s=getString(R.string.wi_owm_804);
                break;
            case 900:
                s=getString(R.string.wi_owm_900);
                break;
            case 901:
                s=getString(R.string.wi_owm_901);
                break;
            case 902:
                s=getString(R.string.wi_owm_902);
                break;
            case 903:
                s=getString(R.string.wi_owm_903);
                break;
            case 904:
                s=getString(R.string.wi_owm_904);
                break;
            case 905:
                s=getString(R.string.wi_owm_905);
                break;
            case 906:
                s=getString(R.string.wi_owm_906);
                break;
            case 957:
                s=getString(R.string.wi_owm_957);
                break;

        }
        return s;
        }

        protected void onPostExecute(Double result) {

            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            final double r=result;
            final double c=(result-273.15);
            final TextView textView = findViewById(R.id.t1);
            final TextView textView2 = findViewById(R.id.t2);
            final Switch cswitch=findViewById(R.id.s1);

            String fontPath = "icons/font/weathericons-regular-webfont.ttf";
           TextView txtGhost = findViewById(R.id.ic);
           //txtGhost.setText(("wi_owm_"+id));
            Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
            txtGhost.setTypeface(tf);
           txtGhost.setText(idg(id));
           txtGhost.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   Snackbar.make(view,des.toUpperCase(),Snackbar.LENGTH_LONG).setAction("Action",null).show();
               }
           });
           /* icm = new icon_mang();
            ((TextView)findViewById(R.id.ic)).setTypeface(icm.get_icons("icons/font/weathericons-regular-webfont.ttf",this));
            */
           // textView3.setText("K");
            textView.setText(r +" Kelvin");

            if (j>0){if(i==0){
             //   textView3.setText("C");
                textView.setText(c +" Celsius"); j++;}
            else{ // textView3.setText("k");
                textView.setText( r +" Kelvin");j++;}}

            swipeRefreshLayout = findViewById(R.id.Swipe);
            textView1=findViewById(R.id.tttt);
            textView2.setText(city+" , "+country);

            cswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean b ) {
                    if(b)
                    {i=0;

                        textView.setText(c +" Celsius");

                    }
                    else{
                        i=1;

                        textView.setText(r +" Kelvin");

                    }

                }
            });

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    textView1.setText("    ");
                    if (i==0){
                        j=0;

                        textView.setText(c +" Celsius");
                        j++;}
                    else{ j=0;
                        //textView3.setText("k");
                        textView.setText( r +" Kelvin");
                        j++;}
                    new GetWeather().execute();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    },40);
                }
            });



        }
    }
    @Override
    public void onBackPressed(){
        /*Intent intent3 = new Intent(this,MainActivity.class);
        startActivity(intent3);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);*/
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}