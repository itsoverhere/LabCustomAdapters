package edu.mobidev.labcustomadapters;

import android.app.AlarmManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 11/10/2016.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    ArrayList<Food> listFood;

    public FoodAdapter(ArrayList<Food> listFood){
        this.listFood = listFood;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food currentFood = listFood.get(position);
        holder.tvFood.setText(currentFood.getName());
        holder.ivFood.setImageResource(currentFood.getIcon());

        // here, we are assigning an object to the container -- in this case, the currentFood object
        holder.container.setTag(R.id.item_food, currentFood);
        // technically, we can just use holder.container.setTag(currentFood) because we are only assigning one object to it
        // but if we make the holder.container assigned to many data, we can use tags
        // check res>values>tag.xml
        // we use it later in

        // how will we handle events when the user clicks on a list item?
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    Food f = (Food) v.getTag(R.id.item_food);
                    mOnItemClickListener.onItemClick(f);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFood;
        TextView tvFood;
        View container;

        public FoodViewHolder(View itemView) {
            super(itemView);
            ivFood = (ImageView) itemView.findViewById(R.id.iv_food);
            tvFood = (TextView) itemView.findViewById(R.id.tv_food);
            container = itemView.findViewById(R.id.container);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(Food food);
    }

}
