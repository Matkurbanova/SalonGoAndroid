package kg.salongo.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.Category;
import kg.salongo.android.R;
import kg.salongo.android.View.CategoryFragment;
import kg.salongo.android.api.ApiRequests;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categoryList = new ArrayList<>();
    private Context context;
    private CategoryFragment categoryFragment;

    public CategoryAdapter(Context context, CategoryFragment categoryFragment) {
        this.context = context;
        this.categoryFragment=categoryFragment;
    }
        public void setCategoryList (List<Category> categoryes) {
            categoryList.clear();

                categoryList.addAll(categoryes);
            notifyDataSetChanged();
        }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
       final Category category = categoryList.get(position);
        holder.name.setText(category.getNameCategory());

        if (!category.getImage().isEmpty())
            Picasso.get()
                    .load(ApiRequests.IMAGES + category.getImage())
                    .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryFragment.categoryClicked(category);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageViewService);
            name=itemView.findViewById(R.id.textViewService);
        }
    }
}
