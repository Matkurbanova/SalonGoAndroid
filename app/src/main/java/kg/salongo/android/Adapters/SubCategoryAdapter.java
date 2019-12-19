package kg.salongo.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.R;
import kg.salongo.android.View.SubCategoryFragment;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryVH> {
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private Context context;
    private SubCategoryFragment subCategoryFragment;

    public SubCategoryAdapter(Context context, SubCategoryFragment subCategoryFragment) {
        this.context = context;
        this.subCategoryFragment=subCategoryFragment;
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
         final SubCategory subCategory = subCategoryList.get(position);
        holder.textViewNameSubCategory.setText(subCategory.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subCategoryFragment.subCategoryClicked(subCategory);
            }
        });
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
