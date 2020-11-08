package ziemansoft.ziemapp.chatterflowtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ziemansoft.ziemapp.chatterflowtest.adapter.UsersAdapter;
import ziemansoft.ziemapp.chatterflowtest.pojo.UserId;
import ziemansoft.ziemapp.chatterflowtest.view.EditTaskActivity;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<UserId> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UsersAdapter();
        db = FirebaseFirestore.getInstance();

//        UserId userId = new UserId("John", "Zieman", "21", "Male");
//        UserId userId1 = new UserId("John", "Zieman", "21", "Male");
//        UserId userId2 = new UserId("John", "Zieman", "21", "Male");
//        list.add(userId);
//        list.add(userId1);
//        list.add(userId2);
//        adapter.setUsers(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


//        db = FirebaseFirestore.getInstance();
//        Map<String, Object> user = new HashMap<>();
//        user.put("UserName", "John");
//        user.put("Age", "19");
//        user.put("UserName", "John");
//        user.put("Age", "19");
//        db.collection("users").add(user);

//        db.collection("users").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful()){
//                            QuerySnapshot snapshots = task.getResult();
//                            if(snapshots!=null){
//                                for(QueryDocumentSnapshot snap:snapshots){
//                                    Map<String, Object> getUser = snap.getData();
//                                    Log.i("Info", getUser.get("UserName").toString());
//                                    Log.i("Info", getUser.get("Age").toString());
//                                }
//                            }
//                        }else {
//                        }
//                    }
//                });
//        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if(error!=null){
//                    Log.w("ErrorMessage", error.toString());
//                }
//                if(value!=null){
//                    for(QueryDocumentSnapshot snap:value){
//                                    Map<String, Object> getUser = snap.getData();
//                                    Log.i("Info", getUser.get("UserName").toString());
//                                    Log.i("Info", getUser.get("Age").toString());
//                    }
//                }
//            }
//        });

//        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if (error != null) {
//                    Log.w("ErrorMessage", error.toString());
//                }
//                if (value != null) {
//                    List<UserId> userIds = value.toObjects(UserId.class);
//                    adapter.setUsers(userIds);
//                }
//            }
//        });
//        UserId userId = new UserId("John", "Zieman", "21", "Male");
//        db.collection("users").add(userId);
    }


    public void addTask(View view) {
        Intent intent = new Intent(this, EditTaskActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null){
                    Log.i("ErrorMessage", error.getMessage());
                    return;
                }
                if(value!=null){
                    list = value.toObjects(UserId.class);
                    adapter.setUsers(list);
                }
            }
        });
    }
}