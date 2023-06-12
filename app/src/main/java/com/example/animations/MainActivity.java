package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvText;
    RadioGroup rgAnim;
    RadioButton radioButton;
    Button btnStart;
    Animation translateAnim,rotateAnim,alphaAnim,scaleAnim;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText=findViewById(R.id.tvText);
        rgAnim = findViewById(R.id.rgAnim);
        btnStart=findViewById(R.id.btnStart);
        //listView=findViewById(R.id.lvItems);
        translateAnim= AnimationUtils.loadAnimation(this,R.anim.translate);
        rotateAnim=AnimationUtils.loadAnimation(this,R.anim.rotate);
        alphaAnim=AnimationUtils.loadAnimation(this,R.anim.alpha);
        scaleAnim=AnimationUtils.loadAnimation(this,R.anim.scale);

//        ArrayList<String> itemsList=new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            itemsList.add("item: "+i);
//        }
//        ArrayAdapter arrayAdapter=new ArrayAdapter<>(this,R.layout.items_list,itemsList);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               int sel=listView.getSelectedItemPosition();
//               Toast.makeText(getApplicationContext(), "Item selected: "+(i+1), Toast.LENGTH_SHORT).show();
//            }
//        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=rgAnim.getCheckedRadioButtonId();
                radioButton=findViewById(selectedId);
                if (radioButton == null) {
                    // No radio button selected
                    Toast.makeText(getApplicationContext(), "Please select an animation", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(radioButton.getText().equals("move"))
                {
                    tvText.startAnimation(translateAnim);
                }
                else if(radioButton.getText().equals("rotate"))
                {
                    tvText.startAnimation(rotateAnim);
                }
                else if(radioButton.getText().equals("alpha"))
                {
                    tvText.startAnimation(alphaAnim);
                }
                else if(radioButton.getText().equals("scale"))
                {
                    tvText.startAnimation(scaleAnim);
                }
            }
        });
    }
}