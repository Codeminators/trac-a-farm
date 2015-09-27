package com.android.tracafarm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class StartFarmActivity extends AppCompatActivity {

    ArrayList<Crop> crops;
    Calendar c;
    int year;
    int month;
    int day;
    Button sowedMaize;
    Button sowed;
    TextView multiTextView;
    TextView multiTextViewMaize;
    CardView cardViewWheat;
    CardView cardViewSugarcane;
    CardView cardViewMaize;
    StepsView stepViewWheat;
    StepsView stepViewMaize;
    String[] value = {"1", "2", "3", "4", "5", "6", "7", "8"};
    int[] date = new int[1];
    int[] dateMaize = new int[1];
    @Override
    protected void onResume() {
        super.onResume();
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_YEAR);
        final Wheat wheat = new Wheat();
        final Maize maize = new Maize();
        Log.d("DAY = ", day + "");
        if(day < wheat.getSowingNormalDayStart()) {
            int daysLeft = wheat.getSowingNormalDayStart() - day;
            multiTextView.setText(daysLeft + " Days Left to Start Sowing. \nPrepare the field.");
        }
        else if(day >= wheat.getSowingNormalDayStart() && day <= wheat.getSowingNormalDayEnd()) {
            int daysLeft = wheat.getSowingNormalDayEnd() - day;
            multiTextView.setText("Sowing Period: " + wheat.dayStart + "/" + wheat.getSowingNormalMonth() + "/15 - "
                    + wheat.dayEnd + "/" + wheat.getSowingNormalMonth() + "/15 - ");
            int midDay = wheat.getSowingNormalDayStart() + ((wheat.getSowingNormalDayEnd() - wheat.getSowingNormalDayStart()) / 2);
            if (day >= midDay)
                cardViewWheat.setCardBackgroundColor(Color.parseColor("#FF0000"));
            else if (day <= midDay)
                cardViewWheat.setCardBackgroundColor(Color.parseColor("#FFFF00"));
            else
                cardViewWheat.setCardBackgroundColor(Color.parseColor("#00FF00"));

//        else if(day >= wheat.getSowingNormalDayStart() && day <= wheat.getSowingNormalDayEnd()) {
//            int daysLeft = wheat.getSowingNormalDayEnd() - day;
//            multiTextView.setText("Sowing Period: " + wheat.dayStart + "/" + wheat.getSowingNormalMonth() + "/15 - "
//                    + wheat.dayEnd + "/" + wheat.getSowingNormalMonth() + "/15 - ");
//            int midDay = wheat.getSowingNormalDayStart() + ((wheat.getSowingLateDayEnd() - wheat.getSowingNormalDayStart())/2);
//            if(day > midDay)
//                cardViewWheat.setCardBackgroundColor(Color.parseColor("#FF0000"));
//            else if (day < midDay)
//                cardViewWheat.setCardBackgroundColor(Color.parseColor("#FFFF00"));
//            else
//                cardViewWheat.setCardBackgroundColor(Color.parseColor("#00FF00"));
            sowed = (Button) findViewById(R.id.button_wheat);
            sowed.setVisibility(View.VISIBLE);
            sowed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // stepViewWheat.setLabels(value).setCompletedPosition(1).drawView();
                    date[0] = c.get(Calendar.DAY_OF_YEAR);
                    multiTextView.setText("Add Fertilizers");
                    sowed.setText("Add");
                    sowed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sowed.setVisibility(View.GONE);
//                            stepViewWheat.setLabels(value).setCompletedPosition(2).drawView();
                            cardViewWheat.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                            boolean rains = false;
                            if (rains) {
                                multiTextView.setText("It will rain in " + wheat.getFirstIrrigation() + "days you may not irrigate your field");
                            }
                            int daysLeft = date[0] + wheat.getFirstIrrigation() - day;
                            multiTextView.setText(daysLeft + "Days left for the first Irrigation");
                        }
                    });

                }
            });
        }

        else if(day >= date[0] && day <= date[0] + wheat.getFirstIrrigation()) {
            boolean rains = false;
//            stepViewWheat.setLabels(value).setCompletedPosition(3).drawView();
            if(rains) {
                multiTextView.setText("It will rain in " + wheat.getFirstIrrigation() + "days you may not irrigate your field");
            }

            int daysLeft = date[0] + wheat.getFirstIrrigation() - day;
            multiTextView.setText(daysLeft + "Days left for the first Irrigation");
        }
        else if(day == date[0] + wheat.getPesticides()) {
            multiTextView.setText("Add Pesticides");
//            stepViewWheat.setLabels(value).setCompletedPosition(3).drawView();
        }

        else if(day >= date[0] + wheat.getFirstIrrigation() && day <= date[0] + wheat.getSecondIrrigation()) {
            boolean rains = false;
//            stepViewWheat.setLabels(value).setCompletedPosition(4).drawView();
            if(rains) {
                int x = wheat.getSecondIrrigation() - wheat.getFirstIrrigation();
                multiTextView.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = wheat.getSecondIrrigation() - wheat.getFirstIrrigation();
            multiTextView.setText(daysLeft + "Days left for the second Irrigation");
        }

        else if(day >= date[0] + wheat.getSecondIrrigation() && day <= date[0] + wheat.getThirdIrrigation()) {
            boolean rains = false;
//            stepViewWheat.setLabels(value).setCompletedPosition(5).drawView();

            if(rains) {
                int x = wheat.getThirdIrrigation() - wheat.getSecondIrrigation();
                multiTextView.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = wheat.getThirdIrrigation() - wheat.getSecondIrrigation();
            multiTextView.setText(daysLeft + "Days left for the Third Irrigation");
        }

        else if(day >= date[0] + wheat.getThirdIrrigation() && day <= date[0] + wheat.getFourthIrrigation()) {
            boolean rains = false;
//            stepViewWheat.setLabels(value).setCompletedPosition(6).drawView();
            if(rains) {
                int x = wheat.getFourthIrrigation() - wheat.getThirdIrrigation();
                multiTextView.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = wheat.getFourthIrrigation() - wheat.getThirdIrrigation();
            multiTextView.setText(daysLeft + "Days left for the Fourth Irrigation");
        }

        else if(day >= date[0] + wheat.getHarvest()) {
//            stepViewWheat.setLabels(value).setCompletedPosition(7).drawView();
            multiTextView.setText("Hooray You Can Harvest your Wheat!");
        }


        //MAIZE

        sowedMaize = (Button) findViewById(R.id.button_maize);

        if(day < maize.getSowingNormalDayStart()) {
            int daysLeft = maize.getSowingNormalDayStart() - day;
            multiTextViewMaize.setText(daysLeft + " Days Left to Start Sowing. \nPrepare the field.");
        }
        else if(day >= maize.getSowingNormalDayStart() && day <= maize.getSowingNormalDayEnd()) {
            int daysLeft = maize.getSowingNormalDayEnd() - day;
            multiTextViewMaize.setText("Sowing Period: " + maize.dayStart + "/" + maize.getSowingNormalMonthStart() + "/15 - "
                    + maize.dayEnd + "/" + maize.getSowingNormalMonthEnd() + "/15 - ");
            int midDay = maize.getSowingNormalDayStart() + ((maize.getSowingNormalDayEnd() - maize.getSowingNormalDayStart()) / 2);
            if (day >= midDay)
                cardViewMaize.setCardBackgroundColor(Color.parseColor("#FF0000"));
            else if (day <= midDay)
                cardViewMaize.setCardBackgroundColor(Color.parseColor("#FFFF00"));
            else
                cardViewMaize.setCardBackgroundColor(Color.parseColor("#00FF00"));
            sowedMaize.setVisibility(View.VISIBLE);
            sowedMaize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    stepViewMaize.setLabels(value).setCompletedPosition(1).drawView();
                    date[0] = c.get(Calendar.DAY_OF_YEAR);
                    multiTextViewMaize.setText("Add Fertilizers");
                    sowedMaize.setText("Added");
                    sowedMaize.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            stepViewMaize.setLabels(value).setCompletedPosition(2).drawView();
                            sowedMaize.setVisibility(View.GONE);
                            cardViewMaize.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                            boolean rains = false;
                            if(rains) {
                                multiTextViewMaize.setText("It will rain in " + maize.getFirstIrrigation() + " days you may not irrigate your field");
                            }
                            int daysLeft = date[0] + maize.getFirstIrrigation() - day;
                            multiTextViewMaize.setText(daysLeft + " Days left for the first Irrigation");
                        }
                    });
                }
            });

        }
        else if(day >= date[0] && day <= date[0] + maize.getFirstIrrigation()) {
//            stepViewMaize.setLabels(value).setCompletedPosition(3).drawView();
            boolean rains = false;
            if(rains) {
                multiTextViewMaize.setText("It will rain in " + maize.getFirstIrrigation() + "days you may not irrigate your field");
            }
            int daysLeft = date[0] + maize.getFirstIrrigation() - day;
            multiTextViewMaize.setText(daysLeft + "Days left for the first Irrigation");
        }
        else if(day == date[0] + maize.getPesticides()) {
//            stepViewMaize.setLabels(value).setCompletedPosition(3).drawView();
            multiTextViewMaize.setText("Add Pesticides");
        }

        else if(day >= date[0] + maize.getFirstIrrigation() && day <= date[0] + maize.getSecondIrrigation()) {
//            stepViewMaize.setLabels(value).setCompletedPosition(4).drawView();
            boolean rains = false;
            if(rains) {
                int x = maize.getSecondIrrigation() - maize.getFirstIrrigation();
                multiTextViewMaize.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = maize.getSecondIrrigation() - maize.getFirstIrrigation();
            multiTextViewMaize.setText(daysLeft + "Days left for the second Irrigation");
        }

        else if(day >= date[0] + maize.getSecondIrrigation() && day <= date[0] + maize.getThirdIrrigation()) {
            boolean rains = false;
//            stepViewMaize.setLabels(value).setCompletedPosition(5).drawView();
            if(rains) {
                int x = maize.getThirdIrrigation() - maize.getSecondIrrigation();
                multiTextViewMaize.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = maize.getThirdIrrigation() - maize.getSecondIrrigation();
            multiTextViewMaize.setText(daysLeft + "Days left for the Third Irrigation");
        }

        else if(day >= date[0] + maize.getThirdIrrigation() && day <= date[0] + maize.getFourthIrrigation()) {
            boolean rains = false;
//            stepViewMaize.setLabels(value).setCompletedPosition(6).drawView();
            if(rains) {
                int x = maize.getFourthIrrigation() - maize.getThirdIrrigation();
                multiTextViewMaize.setText("It will rain in " + x + "days you may not irrigate your field");
            }
            int daysLeft = maize.getFourthIrrigation() - maize.getThirdIrrigation();
            multiTextViewMaize.setText(daysLeft + "Days left for the Fourth Irrigation");
        }

        else if(day >= date[0] + maize.getHarvest()) {
//            stepViewMaize.setLabels(value).setCompletedPosition(7).drawView();
            multiTextViewMaize.setText("Hooray You Can Harvest your maize!");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_farm);
        Intent intent = getIntent();
        crops = (ArrayList<Crop>) intent.getSerializableExtra("Crops");
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_YEAR);
        date = new int[1];
        cardViewWheat = (CardView) findViewById(R.id.wheat);
        cardViewSugarcane = (CardView) findViewById(R.id.sugarcane);
        cardViewMaize = (CardView) findViewById(R.id.maize);
        cardViewMaize.setVisibility(View.GONE);
        cardViewSugarcane.setVisibility(View.GONE);
        cardViewWheat.setVisibility(View.GONE);

        Log.d("farm detail =", crops.get(0).cropName);
        for(int i = 0; i < 3; i++){
            if(crops.get(i).cropName.equalsIgnoreCase("Wheat")) {
                cardViewWheat.setVisibility(View.VISIBLE);
                final Wheat wheat = new Wheat();
                multiTextView = (TextView) cardViewWheat.findViewById(R.id.textView_wheat);
                stepViewWheat = (StepsView) cardViewWheat.findViewById(R.id.stepsView_wheat);
                sowed = (Button) findViewById(R.id.button_wheat);
                sowed.setVisibility(View.GONE);

            }
            if(crops.get(i).cropName.equalsIgnoreCase("Maize")) {
                cardViewMaize.setVisibility(View.VISIBLE);
                final Maize maize = new Maize();
                multiTextViewMaize = (TextView) cardViewMaize.findViewById(R.id.textView_maize);
                stepViewMaize = (StepsView) cardViewMaize.findViewById(R.id.stepsView_maize);
                sowedMaize = (Button) findViewById(R.id.button_maize);
                sowedMaize.setVisibility(View.GONE);

            }
//            if(crops.get(i).cropName.equalsIgnoreCase("Wheat")) {
//                cardViewWheat.setVisibility(View.VISIBLE);
//            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_farm, menu);
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
