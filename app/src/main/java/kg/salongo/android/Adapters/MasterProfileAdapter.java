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

import kg.salongo.android.Data.MasterProfile;
import kg.salongo.android.R;

public class MasterProfileAdapter extends RecyclerView.Adapter<MasterProfileAdapter.MasterProfileVH> {
    private List<MasterProfile> masterProfileList = new ArrayList<>();
    private Context context;

    public MasterProfileAdapter(Context context) {
        this.context = context;
    }

    public void setMasterProfiles(List<MasterProfile> masterProfiles) {
        masterProfileList.clear();
        masterProfileList.addAll(masterProfiles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MasterProfileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_master_profile, parent, false);
        return new MasterProfileVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MasterProfileVH holder, int position) {
        MasterProfile masterProfile = masterProfileList.get(position);
        holder.textViewNameService.setText(masterProfile.getDescription());


        if (!masterProfile.getImage().isEmpty())
            Picasso.get()
                    .load(masterProfile.getImage())
                    .into(holder.imageViewService);


    }


    @Override
    public int getItemCount() {
        return masterProfileList.size();
    }

    public class MasterProfileVH extends RecyclerView.ViewHolder {
        TextView textViewNameService;
        ImageView imageViewService;

        public MasterProfileVH(@NonNull View itemView) {
            super(itemView);
            textViewNameService = itemView.findViewById(R.id.textViewNameCategory);
            imageViewService = itemView.findViewById(R.id.imageViewCategory);

        }
    }
}
