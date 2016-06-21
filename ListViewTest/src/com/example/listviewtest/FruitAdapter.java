package com.example.listviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {
	
	private int resourceId;

	public FruitAdapter(Context context, int textViewResourceId, List<Fruit> fruitList) {
		super(context, textViewResourceId, fruitList);
		resourceId = textViewResourceId;
	}
	


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit fruit = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());
		
		return view;
	}

}
