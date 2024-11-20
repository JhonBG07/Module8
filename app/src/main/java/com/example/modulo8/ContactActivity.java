package com.example.modulo8;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Executors;

public class ContactActivity extends AppCompatActivity {

    Button button;
    EditText name, subject, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        subject = findViewById(R.id.subject);
        name = findViewById(R.id.editTextText);
        body = findViewById(R.id.editTextTextMultiLine);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    try {
                        SendEmail.sendEmail("receiver-email@gmail.com", name.getText().toString()+" pregunta: "+ subject.getText().toString(), body.getText().toString());
                    } catch (Exception e) {
                        Log.e("Error sending mail", "Error:", e);
                    }
                });
                Toast.makeText(getApplicationContext(), "Correo enviado exitosamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}