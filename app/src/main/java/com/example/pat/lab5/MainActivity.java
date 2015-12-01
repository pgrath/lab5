package com.example.pat.lab5;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void arrayInfo(View view)
        throws java.io.IOException
    {
        //set up edittext and textview
        TextView tv1 = (TextView) findViewById(R.id.textView);
        EditText et1 = (EditText) findViewById(R.id.etInput);
        EditText etO = (EditText) findViewById(R.id.editTextOut);
        int[] grades = new int[100];
        int count = 0;
        int i=0;
        int medianMark = 0;
        double gMe = 1.0;
        double median;
        String file;
        //set up array obj to use
        ArrayUtil sorter = new ArrayUtil();
        //Get assetmanager to read files
        AssetManager assetManager = getAssets();



        //set up outfile for writing


        file = et1.getText().toString();



            Scanner fileScn = new Scanner(assetManager.open(file));
            //read from file into array
            while(fileScn.hasNext()){
                grades[count] = fileScn.nextInt();
                gMe *= grades[count];
                count++;
            }
            fileScn.close();


        sorter.sort(grades, count);

        File outputFile = new File(getExternalFilesDir(null),etO.getText().toString());
        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

                while (i<=count-1){
                    tv1.append(grades[i]+"\n");
                    pw.println(grades[i]);
                    i++;
                }


        tv1.append("Max is" + grades[count-1] + "\n");
        /*
        int small = grades[0];
        int index = 0;
        for (int x = 0; i < grades.length; x++){
            if (grades[i] < small)
            {
                small = grades[i];
                index = i;
            }}
            */

        tv1.append("Min is" + grades[0] +"\n");


        tv1.append("G mean is: "+ Double.toString(Math.pow(gMe, 1.0 / (double) count)) +"\n");

       

        //get median

        //even number of grades
        if (count % 2 == 0){
            medianMark = count / 2 ;
            median = (grades[medianMark] + grades[medianMark-1]) / 2.0;
        }
        //odd number of grades
        else{
            median = grades[((count-1)/2)];}

        tv1.append("Median is: "+ median);


        pw.close();
    }
}
