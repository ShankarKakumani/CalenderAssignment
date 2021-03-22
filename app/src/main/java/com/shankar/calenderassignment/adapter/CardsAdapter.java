package com.shankar.calenderassignment.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shankar.calenderassignment.R;
import com.shankar.calenderassignment.databinding.ItemCardBinding;
import com.shankar.calenderassignment.ui.MainActivityViewModel;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    MainActivityViewModel mainActivityViewModel;
    public CardsAdapter(MainActivityViewModel mainActivityViewModel)
    {
        this.mainActivityViewModel = mainActivityViewModel;
    }
    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CardsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {

        holder.itemCardBinding.setModel(mainActivityViewModel.lecList.getValue().get(position));
    }

    @Override
    public int getItemCount() {
        return mainActivityViewModel.lecList.getValue().size();
    }

    public static class CardsViewHolder extends RecyclerView.ViewHolder {

        ItemCardBinding itemCardBinding;

        public CardsViewHolder(ItemCardBinding itemCardBinding) {
            super(itemCardBinding.getRoot());
            this.itemCardBinding = itemCardBinding;
        }
    }
}
