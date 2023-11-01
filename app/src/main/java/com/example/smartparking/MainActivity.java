package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.smartparking.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TicketFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId(); // Get the ID of the selected item

            if (itemId == R.id.ticket) {
                replaceFragment(new InformationPayFragment()); // Replace with the actual fragment you want to display
            } else if (itemId == R.id.qr) {
                replaceFragment(new QrFragment()); // Replace with the actual fragment
            } else if (itemId == R.id.search) {
                replaceFragment(new SearchFragment()); // Replace with the actual fragment
            }

            return  true;
        });



    }



    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }



}