package kg.salongo.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.Service;
import kg.salongo.android.R;
import kg.salongo.android.View.ServiceFragment;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHV> {
    private List<Service> serviceList = new ArrayList<>();
    private Context context;
    private ServiceFragment serviceFragment;

    public ServiceAdapter(Context context, ServiceFragment serviceFragment) {
        this.context = context;
        this.serviceFragment = serviceFragment;
    }

    public void setServiceList(List<Service> services) {
        serviceList.clear();
        serviceList.addAll(services);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceHV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_service, parent, false);
        return new ServiceHV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceHV holder, int position) {
        final Service service = serviceList.get(position);
        holder.textViewSalonName.setText(service.getNameSalon());
        holder.textViewSubCatygoryName.setText(service.getNameSubCategory());
        holder.textViewaddress.setText(service.getAddress());
        holder.textViewWorkTime.setText(service.getWorkTime());
        holder.textClose.setText(service.getClose());


        if (!service.getImage().isEmpty())
            Picasso.get()
                    .load(service.getImage())
                    .into(holder.imageViewLogo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceFragment.serviceClicked(service);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ServiceHV extends RecyclerView.ViewHolder {
        TextView textViewSalonName;
        TextView textViewSubCatygoryName;
        TextView textViewaddress;
        TextView textViewWorkTime;
        ImageView imageViewLogo;
        Button buttonprice;
        TextView textClose;

        public ServiceHV(@NonNull View itemView) {
            super(itemView);
            textViewSalonName = itemView.findViewById(R.id.textViewNameMAster);
            textViewSubCatygoryName = itemView.findViewById(R.id.textViewNameSubcat);
            textViewaddress = itemView.findViewById(R.id.textViewAddress);
            textViewWorkTime = itemView.findViewById(R.id.textViewWorkTime);
            imageViewLogo = itemView.findViewById(R.id.imageViewServiceLogo);
            buttonprice = itemView.findViewById(R.id.button);
            textClose = itemView.findViewById(R.id.textClose);

        }
    }
}
