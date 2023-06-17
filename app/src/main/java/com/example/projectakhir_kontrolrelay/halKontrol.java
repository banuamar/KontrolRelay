package com.example.projectakhir_kontrolrelay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class halKontrol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_kontrol);

        final Button on1 = (Button) findViewById(R.id.on1);
        final Button off1 = (Button) findViewById(R.id.off1);

        final Button on2 = (Button) findViewById(R.id.on2);
        final Button off2 = (Button) findViewById(R.id.off2);

        final Button on3 = (Button) findViewById(R.id.on3);
        final Button off3 = (Button) findViewById(R.id.off3);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refLampu1 = database.getReference("STATUS_LAMPU1");
        DatabaseReference refLampu2 = database.getReference("STATUS_LAMPU2");
        DatabaseReference refLampu3 = database.getReference("STATUS_LAMPU3");

        refLampu1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                final Long message = snapshot.getValue(Long.class);
                    if(message==0){
                        off1.setVisibility(View.GONE);
                        on1.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        off1.setVisibility(View.VISIBLE);
                        on1.setVisibility(View.GONE);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        refLampu2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    final Long message = snapshot.getValue(Long.class);
                    if(message==0){
                        off2.setVisibility(View.GONE);
                        on2.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        off2.setVisibility(View.VISIBLE);
                        on2.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        refLampu3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    final Long message = snapshot.getValue(Long.class);
                    if(message==0){
                        off3.setVisibility(View.GONE);
                        on3.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        off3.setVisibility(View.VISIBLE);
                        on3.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU1");
                myref.setValue(1);
            }
        });
        off1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU1");
                myref.setValue(0);
            }
        });

        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU2");
                myref.setValue(1);
            }
        });
        off2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU2");
                myref.setValue(0);
            }
        });

        on3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU3");
                myref.setValue(1);
            }
        });
        off3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU3");
                myref.setValue(0);
            }
        });
    }
}