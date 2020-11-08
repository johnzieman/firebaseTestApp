package ziemansoft.ziemapp.chatterflowtest.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import ziemansoft.ziemapp.chatterflowtest.R;
import ziemansoft.ziemapp.chatterflowtest.pojo.UserId;

public class EditTaskActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextAge;
    private EditText editTextSex;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        init();
    }



    private void init(){
        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextLastName = findViewById(R.id.editTextTextPersonName2);
        editTextAge = findViewById(R.id.editTextTextPersonName3);
        editTextSex = findViewById(R.id.editTextTextPersonName4);
        db = FirebaseFirestore.getInstance();
    }

    public void AddTask(View view) {
        if(editTextName.getText().toString().isEmpty() || editTextLastName.getText().toString().isEmpty() || editTextAge.getText().toString().isEmpty() || editTextSex.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
        }else{
            String name = editTextName.getText().toString().trim();
            String lastname = editTextLastName.getText().toString().trim();
            int age = Integer.parseInt(editTextAge.getText().toString().trim());
            String sex = editTextSex.getText().toString().trim();
            addNewTask(name, lastname, age, sex);
        }
    }

    private void addNewTask(String name, String lastname, int age, String sex){
        UserId userId = new UserId(name, lastname, age, sex);
        db.collection("users").add(userId).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(EditTaskActivity.this, "Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditTaskActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}