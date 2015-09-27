package com.android.tracafarm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FarmDetailActivity extends AppCompatActivity {

    String area;
    ArrayList<Crop> crops;
    private GridView gridView;
    private Button submitButton;
    private RadioGroup radioGroup;
    private TextView areaText;
    private Adapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_detail);
        Intent intent = getIntent();
        area = intent.getStringExtra("Area");
        crops = (ArrayList<Crop>) intent.getSerializableExtra("Crops");

        gridView = (GridView) findViewById(R.id.grid_view);
        areaText = (TextView) findViewById(R.id.areaText);
        areaText.setText("Scale : 1 unit = " + Float.parseFloat(area) / 25.0 + " Hectare");
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        final ArrayList<String> cropList = new ArrayList<>();
        for (int i = 0; i < crops.size(); i++) {
            cropList.add(i, crops.get(i).cropName);
        }

        for (int i = 0; i < cropList.size(); i++) {
            final RadioButton button = new RadioButton(this);
            button.setId(i);
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setPadding(80, 40, 0, 10);
            button.setTextSize(25);
            button.setButtonDrawable(R.drawable.bbuton_primary_rounded);
            button.setText(cropList.get(i));
            button.setTextColor(Color.parseColor("#bdbdbd"));
            final int j = i;
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buttonView.isChecked()) {
                        switch (j) {
                            case 0:
                                button.setTextColor(Color.parseColor("#FF0000"));
                                break;
                            case 1:
                                button.setTextColor(Color.parseColor("#00FF00"));
                                break;
                            case 2:
                                button.setTextColor(Color.parseColor("#0000FF"));
                                break;
                        }
                    } else {
                        button.setTextColor(Color.parseColor("#bdbdbd"));
                    }
                }
            });
            radioGroup.addView(button);
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FarmDetailActivity.this, StartFarmActivity.class));
            }
        });

        relativeLayout.addView(radioGroup);
        ArrayList<String> cropsGrown = MainActivity.getSeason();
        gridAdapter = new Adapter(FarmDetailActivity.this);
        gridView.setAdapter(gridAdapter);
        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    gridView.requestFocusFromTouch();
//                         gridView.getFocusedChild().setBackgroundColor(Color.parseColor("#000000"));

                    gridView.setSelection(gridView.pointToPosition((int) event.getX(), (int) event.getY()));
                    if (gridView.getSelectedItemPosition() != -1 && gridView.getChildAt(gridView.getSelectedItemPosition()).getTag() == null) {
                        switch (radioGroup.getCheckedRadioButtonId()) {
                            case 0:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#FF0000"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(0);
                                break;
                            case 1:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#00FF00"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(1);
                                break;
                            case 2:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#0000FF"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(2);
                                break;
                        }

                    }

                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    gridView.clearFocus();

                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_farm_detail, menu);
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

    public class Adapter extends BaseAdapter {

        Context c;

        public Adapter(Context context) {
            this.c = context;
        }

        @Override
        public int getCount() {
            return 25;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            View v = convertView;
            if (convertView == null) {
                v = layoutInflater.inflate(R.layout.grid_item, null);
            }
            return v;
        }
    }
}
