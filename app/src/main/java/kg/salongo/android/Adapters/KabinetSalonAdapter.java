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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.R;

public class KabinetSalonAdapter extends RecyclerView.Adapter<KabinetSalonAdapter.KabinetSalonVH> {

    private List<KabinetSalon> kabinetSalonList = new ArrayList<>();
    private Context context;

    public KabinetSalonAdapter(Context context) {
        this.context = context;
    }

    public void setPersonalKabinets(List<KabinetSalon> kabinetSalons) {
        kabinetSalonList.clear();
        kabinetSalonList.addAll(kabinetSalons);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KabinetSalonAdapter.KabinetSalonVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_kabinet_salona, parent, false);
        return new KabinetSalonVH(view);


    }

    @Override
    public void onBindViewHolder(@NonNull KabinetSalonAdapter.KabinetSalonVH holder, int position) {


        KabinetSalon kabinetSalon = kabinetSalonList.get(position);
        holder.textViewNameService.setText(kabinetSalon.getNameService());


        if (!kabinetSalon.getImageService().isEmpty())
            Picasso.get()
                    .load(kabinetSalon.getImageService())
                    .into(holder.imageViewService);


    }


    @Override
    public int getItemCount() {
        return kabinetSalonList.size();
    }

    public class KabinetSalonVH extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewService)
        TextView textViewNameService;
        @BindView(R.id.imageViewService)
        ImageView imageViewService;

        public KabinetSalonVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
