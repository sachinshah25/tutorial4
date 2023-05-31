package com.example.image;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.image.databinding.ActivityTutorial4Binding;

import java.util.ArrayList;
import java.util.List;

public class Tutorial_4_Activity extends AppCompatActivity {

    // Tutorial Four (4)
    ActivityTutorial4Binding binding; // For Using Binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch("image/*");
            }
        });
    }
    ActivityResultLauncher<String> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> result) {
            ArrayList<String> arrayList=new ArrayList<>();
            for (int i=0;i<result.size(); i++){
                Uri uri=result.get(i);
                arrayList.add(uri.toString());
            }
            GridLayoutManager gridLayoutManager=new GridLayoutManager(Tutorial_4_Activity.this,2);
            binding.imageRecyclerView.setLayoutManager(gridLayoutManager);

            modelClass modelClass=new modelClass(arrayList,Tutorial_4_Activity.this);
            binding.imageRecyclerView.setAdapter(modelClass);
            Toast.makeText(Tutorial_4_Activity.this, ""+arrayList.size(), Toast.LENGTH_SHORT).show();
            // Let's run
            // Thanks For Watching 
        }
    });
}