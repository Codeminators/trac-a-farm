package com.android.tracafarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText farmAreaEdTxt;
    private Spinner farmLocation;
    private ProgressBar progressBar;

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
