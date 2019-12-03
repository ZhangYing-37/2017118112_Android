package com.hstc.edu.recyclerviewtest2;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();


                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);//菜单资源对象
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());//运行菜单

                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    int position=holder.getAdapterPosition();
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                Fruit orange=new Fruit("orange",R.drawable.orange_pic);
                                mFruitList.add(position,orange);
                                notifyItemInserted(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "add orange successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.del:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "del successfully.", Toast.LENGTH_SHORT).show();
                                }
                            case R.id.change:
                                Fruit grape=new Fruit("grape",R.drawable.grape_pic);
                                mFruitList.set(position,grape);
                                notifyItemChanged(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "change the grape successfully.", Toast.LENGTH_SHORT).show();
                                }
                        }
                        return false;
                    }
                });

                //弹出式菜单的菜单的关闭事件
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {

                    }
                });
                popupMenu.show();

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}