package qqvdk2.Ex2.conversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button dot;
    private ImageButton del;
    private TextView view1;
    private TextView view2;
    private Spinner ctr1;
    private Spinner ctr2;
    private double val1 = Double.NaN;
    private double val2;
    String[] countries  = {
            "USD",
            "VND",
            "EUR",
            "JPY"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ctr1.setAdapter(adapter);
        ctr2.setAdapter(adapter);
        ctr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                trans();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                trans();
            }
        });
        ctr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                trans();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                trans();
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "0");
                trans();
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "1");
                trans();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "2");
                trans();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "3");
                trans();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "4");
                trans();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "5");
                trans();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "6");
                trans();
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "7");
                trans();
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "8");
                trans();
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + "9");
                trans();
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText(view1.getText().toString() + ".");
                trans();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view1.getText().length() >0){
                    CharSequence temp = view1.getText().toString();
                    view1.setText(temp.subSequence(0,temp.length() - 1));
                    trans();
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    view1.setText(null);
                    view2.setText(null);
                }
            }
        });


    }
    private void setupViews(){
        zero = findViewById(R.id.button0);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        dot = findViewById(R.id.buttondot);
        del = findViewById(R.id.buttondel);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        ctr1 = findViewById(R.id.spinner1);
        ctr2 = findViewById(R.id.spinner2);
    }

    private void trans(){
        if(!Double.isNaN(val1)){
            val1 = Double.parseDouble(view1.getText().toString());
            switch (ctr1.getSelectedItemPosition()){
                case 0:
                    val2 = val1;
                    break;
                case 1:
                    val2 = val1 / 22770;
                    break;
                case 2:
                    val2 = val1 * 1.23;
                    break;
                case 3:
                    val2 = val1 / 107.65;
                    break;
                default:
                    val2 = val1;
            }

            switch (ctr2.getSelectedItemPosition()){
                case 0:
                    val2 = val2;
                    break;
                case 1:
                    val2 = val2 * 22770;
                    break;
                case 2:
                    val2 = val2 / 1.23;
                    break;
                case 3:
                    val2 = val2 * 107.65;
                    break;
                default:
                    val2 = val2;
            }

            view2.setText(String.valueOf(val2));

        }
        else {
            val1 = Double.parseDouble(view1.getText().toString());
            view2.setText(null);
        }
    }
}
