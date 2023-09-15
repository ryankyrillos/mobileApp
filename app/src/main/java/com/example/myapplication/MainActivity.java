package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Model.Restaurant;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    List<Restaurant> restaurantList; //declare
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btAdd.setOnClickListener(v-> add_restaurant());
        restaurantList = new ArrayList<>(); // initialize
    }

    public void add_restaurant(){

        String name = binding.name.getText().toString();
        String address = binding.address.getText().toString();

        boolean onTable = binding.onTable.isChecked();
        boolean delivery = binding.delivery.isChecked();
        boolean takeAway = binding.takeaway.isChecked();

        //variables check conditions
        if ((name.equals("") || address.equals(""))){
            Toast.makeText(this,"name/address cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!onTable && !delivery && !takeAway){
            Toast.makeText(this,"check at least one option", Toast.LENGTH_SHORT).show();
            return;
        }

        Restaurant restaurant = new Restaurant(name,address);
        restaurant.setDelivery(delivery);
        restaurant.setOnTable(onTable);
        restaurant.setTakeAway(takeAway);

        //Toast.makeText(this,"Restaurant added", Toast.LENGTH_SHORT).show();
        // context this means the activity itself

        binding.name.setText("");
        binding.address.setText("");
        binding.onTable.setChecked(false);
        binding.delivery.setChecked(false);
        binding.takeaway.setChecked(false);
        binding.name.requestFocus();  //set the cursor on the name field

        restaurantList.add(restaurant);

        //Snack bar more like a toast but can be modified
        Snackbar.make(this,binding.getRoot(), "Restaurant added, Total:" + restaurantList.size(),Snackbar.LENGTH_SHORT).show();


        //android kills the mainActivity when we rotate the screen
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.option1) {
            Snackbar.make(binding.getRoot(),"option1 slected", Snackbar.LENGTH_SHORT);
        }
        if (item.getItemId()==R.id.option2) {
            Snackbar.make(binding.getRoot(),"option1 slected", Snackbar.LENGTH_SHORT);
        }
        return true;
    }
}
