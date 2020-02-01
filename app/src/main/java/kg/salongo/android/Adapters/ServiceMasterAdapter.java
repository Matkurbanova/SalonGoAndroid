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

import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.Service;
import kg.salongo.android.R;
import kg.salongo.android.View.MasterServiceFragment;
import kg.salongo.android.View.ServiceFragment;
import kg.salongo.android.api.ApiRequests;

public class ServiceMasterAdapter extends RecyclerView.Adapter<ServiceMasterAdapter.MasterServiceHV> {
    private List<MasterService> masterServiceList = new ArrayList<>();
    private Context context;
    private MasterServiceFragment masterServiceFragment;

    public ServiceMasterAdapter(Context context, MasterServiceFragment masterServiceFragment) {
        this.context = context;
        this.masterServiceFragment = masterServiceFragment;
    }

    public void setMasterServiceFragmentList(List<MasterService> masterServices) {
        masterServiceList.clear();
        masterServiceList.addAll(masterServices);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceMasterAdapter.MasterServiceHV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_servicemaster, parent, false);
        return new ServiceMasterAdapter.MasterServiceHV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceMasterAdapter.MasterServiceHV holder, int position) {
        final MasterService masterService = masterServiceList.get(position);
        holder.NameMaster.setText(masterService.getName());
        holder.nameofService.setText(masterService.getDescription());
        holder.experienceYear.setText(masterService.getExperienceYear());
        holder.textViewTellMaster.setText(masterService.getPhone());
        if (!masterService.getImage().isEmpty())
            Picasso.get()
                    .load(ApiRequests.IMAGES + masterService.getImage())
                    .into(holder.imageMaster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masterServiceFragment.masterServiceClicked(masterService);
            }
        });

    }

    @Override
    public int getItemCount() {
        return masterServiceList.size();
    }

    public class MasterServiceHV extends RecyclerView.ViewHolder {
        TextView NameMaster;
        TextView nameofService;
        TextView experienceYear;
        ImageView imageMaster;
        TextView textViewTellMaster;
        TextView statusBusy;

        public MasterServiceHV(@NonNull View itemView) {
            super(itemView);
            NameMaster = itemView.findViewById(R.id.textViewNameMaster);
            nameofService = itemView.findViewById(R.id.NameOfService);
            experienceYear = itemView.findViewById(R.id.WorkExperienceYear);
            imageMaster = itemView.findViewById(R.id.imageMaster);
            statusBusy = itemView.findViewById(R.id.StatusBusy);
            textViewTellMaster = itemView.findViewById(R.id.textViewTellMaster);
        }
    }
}