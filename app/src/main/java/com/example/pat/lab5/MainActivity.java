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

import java.io.IOException;
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

    public void arrayInfo(View view){
        //set up edittext and textview
        TextView tv1 = (TextView) findViewById(R.id.textView);
        EditText et1 = (EditText) findViewById(R.id.etInput);
        int[] grades = new int[1024];
        int count = 0;
        String file;
        //set up array obj to use
        ArrayUtil sorter = new ArrayUtil();
        //Get assetmanager to read files
        AssetManager assetManager = getAssets();

        file = et1.getText().toString();

        try {

            Scanner fileScn = new Scanner(assetManager.open(file));
            //read from file into array
            while(fileScn.hasNext()){
                grades[count] = fileScn.nextInt();
                count++;
            }
            fileScn.close();
        } catch (IOException e) {
            e.printStackTrace();
            tv1.append("IO Error!!");
        }


        sorter.sort(grades, grades.length);
        for(int i=0; i<=grades.length;){
            tv1.append(grades[i]+"\n");

        }


    }
}
