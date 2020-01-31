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

import kg.salongo.android.Data.KabinetMaster;
import kg.salongo.android.R;

public class KabinetMasterAdapter extends RecyclerView.Adapter<KabinetMasterAdapter.KabinetMasterVH> {
    private List<KabinetMaster> kabinetMasterList = new ArrayList<>();
    private Context context;

    public KabinetMasterAdapter(Context context) {
        this.context = context;
    }

    public void setMasterProfiles(List<KabinetMaster> kabinetMasters) {
        kabinetMasterList.clear();
        kabinetMasterList.addAll(kabinetMasters);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KabinetMasterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_kabinet_master, parent, false);
        return new KabinetMasterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KabinetMasterVH holder, int position) {
        KabinetMaster kabinetMaster = kabinetMasterList.get(position);
        holder.textViewNameService.setText(kabinetMaster.getNameService());


        if (!kabinetMaster.getImage().isEmpty())
            Picasso.get()
                    .load(kabinetMaster.getImage())
                    .into(holder.imageViewService);


    }

    @Override
    public int getItemCount() {
        return kabinetMasterList.size();
    }

    public class KabinetMasterVH extends RecyclerView.ViewHolder {
        TextView textViewNameService;
        ImageView imageViewService;

        public KabinetMasterVH(@NonNull View itemView) {
            super(itemView);
            textViewNameService = itemView.findViewById(R.id.textViewNameCategory);
            imageViewService = itemView.findViewById(R.id.imageViewCategory);

        }
    }
}
