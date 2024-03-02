package com.example.seniorcapstone;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("keyname",username);
                startActivity(intent);

            }
        });
    }
}
