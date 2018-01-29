package com.yo.quadraticequationsolver;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText avalue   = (EditText)findViewById(R.id.avalue);
        final EditText bvalue   = (EditText)findViewById(R.id.bvalue);
        final EditText cvalue   = (EditText)findViewById(R.id.cvalue);
        avalue.setText("1");
        bvalue.setText("0");
        cvalue.setText("0");
        Button  calc = (Button)findViewById(R.id.button);

        calc.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        double aval = Double.parseDouble(avalue.getText().toString());
                        double bval = Double.parseDouble(bvalue.getText().toString());
                        double cval = Double.parseDouble(cvalue.getText().toString());
                        calculate(aval, bval, cval);
                    }
                }
        );
        calc.setBackgroundColor(Color.parseColor("#6f88a5"));

    }

    public void calculate(double a, double b, double c) {
        TextView root = (TextView) findViewById(R.id.roots);
        TextView vertex = (TextView) findViewById(R.id.vertex);
        TextView factored = (TextView) findViewById(R.id.factored);
        if (b*b - 4*a*c < 0)  {
            root.setText("There are no roots.");
            vertex.setText("");
            factored.setText("");
        } else {
            double xval1 = ((-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a));
            double xval2 = ((-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a));
            if (xval1 == xval2) {
                root.setText("Your root is: " + xval1);
            } else {
                root.setText("Your roots are :" + xval1 + " and " + xval2);
            }
            factored.setText("Factored form: \n f(x) = " + a + "(x-" + xval1 + ")(x-" + xval2+")");
        }
        double xVertex = -b/(2*a);
        double yVertex = a*Math.pow(xVertex, 2) + b * xVertex + c;
        vertex.setText("Vertex form: \n f(x) =" + a + "(x-" + xVertex + ")^2 +" + yVertex);


    }

}
