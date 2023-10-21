package com.example.carsales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public List<Car> data;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add(new Car(R.drawable.no_image, "Toyota", "Corolla", 2022, " Просторный седан с отличной экономичностью расхода топлива и надежным двигателем", "$20,000"));
        data.add(new Car(R.drawable.no_image, "BMW", "X5", 2023, "Мощный и стильный внедорожник с роскошным интерьером и передовыми технологиями", "$65,000"));
        data.add(new Car(R.drawable.no_image, "Tesla", "Model 3", 2022, "Электрический седан с высокой скоростью зарядки и передовой системой автопилота", "$40,000"));
        data.add(new Car(R.drawable.no_image, "Mercedes-Benz", "E-Class", 2023, "Лидер в классе комфорта и элегантности, сочетающий в себе роскошь и производительность", "$55,000"));
        data.add(new Car(R.drawable.no_image, "Ford", "Mustang", 2022, "Легендарный мускул-кар с высокой производительностью и агрессивным дизайном", "$35,000"));
        data.add(new Car(R.drawable.no_image, "Honda", "Civic", 2023, "Надежный и экономичный седан с просторным салоном и удобной посадкой", "$22,000"));
        data.add(new Car(R.drawable.no_image, "Audi", "A4", 2022, "Компактный и роскошный седан с высоким уровнем комфорта и передовыми технологиями", "$42,000"));
        data.add(new Car(R.drawable.no_image, "Chevrolet", "Silverado", 2023, "Мощный пикап с большой грузоподъемностью и универсальной функциональностью", "$30,000"));
        data.add(new Car(R.drawable.no_image, "Nissan", "Rogue", 2022, "Современный кроссовер с просторным интерьером и удобным вождением", "$25,000"));
        data.add(new Car(R.drawable.no_image, "Porsche", "911", 2023, "Изысканный спортивный автомобиль с выдающейся динамикой и элегантным дизайном", "$100,000"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }
}