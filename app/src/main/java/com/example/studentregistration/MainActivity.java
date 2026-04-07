package com.example.studentregistration;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        AutoCompleteTextView actvCourse = findViewById(R.id.actvCourse);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        TextView tvDisplay = findViewById(R.id.tvDisplay);

        // Setup AutoComplete Suggestions
        String[] courses = {"Computer Science", "Information Technology", "Business Admin", "Mechanical Engineering", "Nursing"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        actvCourse.setAdapter(adapter);
        actvCourse.setThreshold(1); // Start suggesting after 1 character

        // Button Click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String course = actvCourse.getText().toString();

                // Get selected Gender
                int selectedId = rgGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedId != -1) {
                    RadioButton rb = findViewById(selectedId);
                    gender = rb.getText().toString();
                }

                // Validation
                if (name.isEmpty() || age.isEmpty() || gender.isEmpty() || course.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Display Information
                    String result = "Registered Info:\n" +
                            "Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Gender: " + gender + "\n" +
                            "Course: " + course;

                    tvDisplay.setText(result);
                    Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}