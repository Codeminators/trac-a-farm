package com.android.tracafarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String[] districts = {
            "AGRA",
            "AHMEDABAD",
            "AHMEDNAGAR",
            "AKOLA",
            "ALIGARH",
            "ALLAHABAD",
            "AMBEDKAR NGR.",
            "AMRAVATI",
            "AMRELI",
            "ANAND",
            "AURAIYA",
            "AURANGABAD",
            "AZAMGARH",
            "BADAUN",
            "BAGPAT",
            "BAHRAICH",
            "BALLIA",
            "BALRAMPUR",
            "BANAS KANTHA",
            "BANDA",
            "BARABANKI",
            "BAREILLY",
            "BASTAR",
            "BASTI",
            "BEED",
            "BHAVNAGAR",
            "BIJNOR",
            "BILASPUR",
            "BROACH",
            "BULDHANA",
            "BULLANDSHAHR",
            "CHANDAULI",
            "CHANDRAPUR",
            "CHITRAKUT",
            "DANGS",
            "DANTEWARA",
            "DEORIA",
            "DHAMTARI",
            "DHULE",
            "DOHAD",
            "DURG",
            "ETAH",
            "ETAWAH",
            "FAIZABAD",
            "FARRUKHABAD",
            "FATEHPUR",
            "FIROZABAD",
            "G.BUDDHA NGR.",
            "GADCHIROLI",
            "GANDHINAGAR",
            "GHAZIABAD",
            "GHAZIPUR",
            "GONDA",
            "GORAKHPUR",
            "HAMIRPUR",
            "HARDOI",
            "HINGOLI",
            "J.B.PHULE NGR.",
            "JALANA",
            "JALAUN",
            "JALGAON",
            "JAMNAGAR",
            "JANJGIR-CHAMPA",
            "JASHPUR",
            "JAUNPUR",
            "JHANSI",
            "JUNAGARH",
            "KANKER",
            "KANNAUJ",
            "KANPUR CITY",
            "KAUSHAMBI",
            "KAWARDHA (KABIRDHAM)",
            "KHEDA",
            "KHERI",
            "KOLHAPUR",
            "KORBA",
            "KORIYA",
            "KUSHI NGR.",
            "KUTCH",
            "LALITPUR",
            "LATUR",
            "LUCKNOW",
            "MAHAMAYA NAGAR",
            "MAHARAHGANJ",
            "MAHASMUND",
            "MAHOBA",
            "MAINPURI",
            "MANDURBAR",
            "MATHURA",
            "MAU",
            "MEERUT",
            "MEHSANA",
            "MIRZAPUR",
            "MIXED CROPS",
            "MORADABAD",
            "MUZAFFARNAGAR",
            "NAGPUR",
            "NANDED",
            "NARMADA",
            "NASIK",
            "NAVSARI",
            "OSMANABAD",
            "PANCH MAHALS",
            "PARBHANI",
            "PATAN",
            "PILIBHIT",
            "PORBANDAR",
            "PRATAPGARH",
            "PUNE",
            "RAEBARELI",
            "RAIGARH",
            "RAIPUR",
            "RAJ NANDGAON",
            "RAJKOT",
            "RAMABAI NAGAR",
            "RAMPUR",
            "S.RAVI DAS NGR.",
            "SABARKANTHA",
            "SAHARANPUR",
            "SANGLI",
            "SANT KABIR NGR.",
            "SARGUJA",
            "SATARA",
            "SHAHJAHANPUR",
            "SHIVASTI",
            "SIDDHARTH NGR.",
            "SITAPUR",
            "SOLAPUR",
            "SONBHADRA",
            "SULTANPUR",
            "SURAT",
            "SURENDRANAGAR",
            "TAPI",
            "UNNAO",
            "VADODARA",
            "VALSAD",
            "VARANASI",
            "WARDHA",
            "WASHIM",
            "YAVATMAL"};
    String stringToPassInSQL = "", location = "";
    private Button submitButton;
    private EditText farmAreaEdTxt;
    private Spinner farmLocation;
    private ProgressBar progressBar;

    public static ArrayList<String> getSeason() {

        final String WINTER = "Winter";
        final String KHARIF = "Kharif";
        final String RABI = "Rabi";
        final String AUTUMN = "Autumn";
        final String SUMMER = "Summer";
        final String WHOLE_YEAR = "Whole Year";
        Calendar calendar = Calendar.getInstance();

        int month = calendar.MONTH;
        Log.d("Raghav", "" + month);

        ArrayList<String> seasons = new ArrayList<>();

        seasons.add(WHOLE_YEAR);
        if (month == 0) {
            seasons.add(RABI);
            seasons.add(WINTER);
        } else if (month == 1) {
            seasons.add(RABI);
            seasons.add(WINTER);
        } else if (month == 2) {
            seasons.add(KHARIF);
            seasons.add(RABI);
        } else if (month == 3) {
            seasons.add(SUMMER);
        } else if (month == 4) {
            seasons.add(SUMMER);
        } else if (month == 5) {
            seasons.add(SUMMER);
        } else if (month == 6) {
            seasons.add(KHARIF);
        } else if (month == 7) {
            seasons.add(KHARIF);
        } else if (month == 8) {
            seasons.add(KHARIF);
        } else if (month == 9) {
            seasons.add(KHARIF);
            seasons.add(AUTUMN);
        } else if (month == 10) {
            seasons.add(RABI);
            seasons.add(AUTUMN);
        } else {
            seasons.add(WINTER);
            seasons.add(RABI);
        }
        return seasons;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = (Button) findViewById(R.id.submit);
        farmAreaEdTxt = (EditText) findViewById(R.id.farm_area);
        farmLocation = (Spinner) findViewById(R.id.farm_location);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        farmLocation.setAdapter(dataAdapter);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> cropsGrown = getSeason();

                stringToPassInSQL = "";

                for (int i = 0; i < cropsGrown.size(); i++) {
                    if (i == cropsGrown.size() - 1) {
                        stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\');";
                    } else
                        stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\', "; //"\' OR Season LIKE ";
                }

                final int farmArea = Integer.parseInt(farmAreaEdTxt.getText().toString());
                location = farmLocation.getSelectedItem().toString();
                final String sqlInput = "SELECT * FROM `farm` WHERE District LIKE " + "\'" + location + "\'" + " AND Season IN (" + stringToPassInSQL;

                Log.d("Raghav", sqlInput);
                new QueryTask() {

                    @Override
                    protected void onPreExecute() {
                        progressBar.setVisibility(View.VISIBLE);
                    }


                    @Override
                    protected void onPostExecute(String stringResponse) {
                        try {

                            JSONArray jsonArray = new JSONArray(stringResponse);
                            String[] value = {"Wheat", "Maize", "Sugarcane"};
                            ArrayList<Crop> crop = new ArrayList<Crop>();
                            int i = 0;
                            while (i < jsonArray.length() && i < 3) {
                                crop.add(i, new Crop());
                                crop.get(i).cropName = value[i];//jsonArray.getJSONObject(i).getString("Crop");
                                crop.get(i).seedCost = jsonArray.getJSONObject(i).getInt("SeedCost");
                                crop.get(i).fertilizerCost = jsonArray.getJSONObject(i).getInt("Fertilizer");
                                crop.get(i).irrigationCost = jsonArray.getJSONObject(i).getInt("Irrigation");
                                crop.get(i).animalLabourCost = jsonArray.getJSONObject(i).getInt("AnimalLabour");
                                crop.get(i).manualLabourCost = jsonArray.getJSONObject(i).getInt("LabourCost");
                                crop.get(i).sellingPrice = jsonArray.getJSONObject(i).getInt("SellingPrice");
                                crop.get(i).costPrice = jsonArray.getJSONObject(i).getInt("CostPrice");
                                crop.get(i).totalDepreciation = jsonArray.getJSONObject(i).getInt("Depreciation");
                                crop.get(i).totalRent = jsonArray.getJSONObject(i).getInt("RentValue");
                                crop.get(i).totalInterest = jsonArray.getJSONObject(i).getInt("InterestOnCapital");
                                crop.get(i).insecticides = jsonArray.getJSONObject(i).getInt("Insecticides");
                                i++;
                            }
                            Intent intent = new Intent(getApplicationContext(), FarmDetailActivity.class);
                            intent.putExtra("Area", farmAreaEdTxt.getText().toString());
                            intent.putExtra("Crops", crop);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }.execute(sqlInput);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, PollutionActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
