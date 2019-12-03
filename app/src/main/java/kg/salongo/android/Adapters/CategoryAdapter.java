package kg.salongo.android.Adapters;

import android.content.Context;
import android.media.Image;
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
import java.util.jar.Attributes;

import kg.salongo.android.Data.Category;
import kg.salongo.android.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categoryList = new ArrayList<>();
    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
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
        Category category = categoryList.get(position);
        holder.name.setText(category.getName());

        if (!category.getImage().isEmpty())
            Picasso.get()
                    .load(category.getImage())
                    .into(holder.image);

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
