package edu.mobidev.labcustomadapters;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FOODNAME = "foodname";

    // declarations
    RecyclerView rvFood;
    ArrayList<Food> listFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize all views
        rvFood = (RecyclerView) findViewById(R.id.rv_food);

        // initialize data to be placed in adapter
        // soon, this will come from a data source like a database or file
        listFood = new ArrayList<>();
        listFood.add(new Food("Apple", R.drawable.apple));
        listFood.add(new Food("Bacon", R.drawable.bacon));
        listFood.add(new Food("Chinese Food", R.drawable.chinese_food));
        listFood.add(new Food("Doughnut", R.drawable.doughnut));
        listFood.add(new Food("Eggplant", R.drawable.eggplant));
        listFood.add(new Food("Fish", R.drawable.fish));
        listFood.add(new Food("Gingerbread Man", R.drawable.gingerbread_man));
        listFood.add(new Food("Hamburger", R.drawable.hamburger));
        listFood.add(new Food("Ice cream", R.drawable.ice_cream));
        listFood.add(new Food("Jelly", R.drawable.jelly));
        listFood.add(new Food("Kebab", R.drawable.kebab));
        listFood.add(new Food("Lobster", R.drawable.lobster));
        listFood.add(new Food("Mushroom", R.drawable.mushroom));
        listFood.add(new Food("Nachos", R.drawable.nachos));
        listFood.add(new Food("Olive Oil", R.drawable.olive_oil));
        listFood.add(new Food("Peach", R.drawable.peach));
        listFood.add(new Food("Rice", R.drawable.rice));
        listFood.add(new Food("Salad", R.drawable.salad));
        listFood.add(new Food("Tomato", R.drawable.tomato));
        listFood.add(new Food("Vinegar", R.drawable.vinegar));
        listFood.add(new Food("Watermelon", R.drawable.watermelon));
        listFood.add(new Food("Yogurt", R.drawable.yogurt));

        // Create the adapter
        FoodAdapter foodAdapter = new FoodAdapter(listFood);
        foodAdapter.setmOnItemClickListener(new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
//                TextDialog td = new TextDialog();
                TextDialog td = TextDialog.newInstance(food.getName());
                td.show(getSupportFragmentManager(), TextDialog.class.getSimpleName());
            }
        });

        rvFood.setAdapter(foodAdapter);
        rvFood.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        ));
    }


}
