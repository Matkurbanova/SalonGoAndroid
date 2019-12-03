package kg.salongo.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.R;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryVH> {
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private Context context;

    public SubCategoryAdapter(Context context) {
        this.context = context;
    }

    public void setSubCategoryList(List<SubCategory> subCategories) {
        subCategoryList.clear();
        subCategoryList.addAll(subCategories);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubCategoryAdapter.SubCategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_subcategory, parent, false);
        return new SubCategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryAdapter.SubCategoryVH holder, int position) {
        SubCategory subCategory = subCategoryList.get(position);
        holder.textViewNameSubCategory.setText(subCategory.getName());


    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }

    public class SubCategoryVH extends RecyclerView.ViewHolder {
        TextView textViewNameSubCategory;

        public SubCategoryVH(@NonNull View itemView) {
            super(itemView);
            textViewNameSubCategory = itemView.findViewById(R.id.textViewNameSubCategory);
        }
    }
}
