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

import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.Data.MoreService;
import kg.salongo.android.R;
import kg.salongo.android.View.MoreSalonFragment;
import kg.salongo.android.View.MoreServiceFragment;

public class MoreServiceAdapter extends RecyclerView.Adapter<MoreServiceAdapter.MoreServiceVH> {

    private List<MoreService> moreServiceList = new ArrayList<>();
    private Context context;
    private MoreServiceFragment moreServiceFragment;

    public MoreServiceAdapter(Context context) {
        this.context = context;
    }

    public void setPersonalKabinets(List<MoreService> moreServices) {
        moreServiceList.clear();
        moreServiceList.addAll(moreServices);
        notifyDataSetChanged();
    }

    public void setMoreServiceFragment(MoreServiceFragment moreServiceFragment) {
        this.moreServiceFragment = moreServiceFragment;
    }

    @NonNull
    @Override
    public MoreServiceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_more_service, parent, false);
        return new MoreServiceVH(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MoreServiceVH holder, int position) {


        MoreService moreService = moreServiceList.get(position);
        holder.textViewNameService.setText(moreService.getNameService());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreServiceFragment.moreServiceClicked(moreService);
            }
        });


        if (!moreService.getImageService().isEmpty())
            Picasso.get()
                    .load(moreService.getImageService())
                    .into(holder.imageViewService);


    }


    @Override
    public int getItemCount() {
        return moreServiceList.size();
    }

    public class MoreServiceVH extends RecyclerView.ViewHolder {
        TextView textViewNameService;
        ImageView imageViewService;

        public MoreServiceVH(@NonNull View itemView) {
            super(itemView);
            textViewNameService = itemView.findViewById(R.id.textViewService);
            imageViewService = itemView.findViewById(R.id.imageViewService);


        }
    }
}
