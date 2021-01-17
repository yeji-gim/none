package org.yechtown.mymemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.HashSet;

import static android.widget.Toast.*;

public class NoteEditorActivity extends AppCompatActivity {

    int NoteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = (EditText) findViewById((R.id.editText));

        Intent intent = getIntent();

        NoteId = intent.getIntExtra("NoteId", -1);

        if(NoteId != -1){
            editText.setText(MainActivity.notes.get(NoteId));
        } else{
            MainActivity.notes.add("");
            NoteId = MainActivity.notes.size() -1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.notes.set(NoteId, String.valueOf(charSequence));
                MainActivity.arrayAdapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("org.yechtown.mymemo", getApplicationContext().MODE_PRIVATE);

                HashSet<String> set = new HashSet(MainActivity.notes);

                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ImageButton cloud = (ImageButton)findViewById(R.id.cloudybt);
        ImageButton sunny = (ImageButton)findViewById(R.id.sunnybt);
        ImageButton rainy = (ImageButton)findViewById(R.id.rainybt);
        ImageButton snowy = (ImageButton)findViewById(R.id.snowybt);

        cloud.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Drawable highlight = getResources().getDrawable( R.drawable.shape3);
                cloud.setBackground(highlight);
            }
        });

        sunny.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Drawable highlight = getResources().getDrawable( R.drawable.shape3);
                sunny.setBackground(highlight);
            }
        });

        rainy.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Drawable highlight = getResources().getDrawable( R.drawable.shape3);
                rainy.setBackground(highlight);
            }
        });

        snowy.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Drawable highlight = getResources().getDrawable( R.drawable.shape3);
                snowy.setBackground(highlight);
            }
        });
    }



}

