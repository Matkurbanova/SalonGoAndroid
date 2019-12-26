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



import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.MasterService;

import kg.salongo.android.R;
import kg.salongo.android.View.MasterServiceFragment;


public class ServiceMasterAdapter extends RecyclerView.Adapter<ServiceMasterAdapter.MasterServiceHV> {
    private List<MasterService> masterServiceList = new ArrayList<>();
    private Context context;
    private MasterServiceFragment masterServiceFragment;
    public ServiceMasterAdapter(Context context, MasterServiceFragment masterServiceFragment) {
        this.context = context;
        this.masterServiceFragment = masterServiceFragment;
    }

    public void setMasterService(List<MasterService> masterServices) {
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
        holder.textViewNameMaster.setText(masterService.getNameMaster());
        holder.nameofService.setText(masterService.getNameofService());
        holder.workExperienceYear.setText(masterService.getExperienceYear());
        holder.StatusFree.setText(masterService.getStatusFree());
        holder.StatusBusy.setText(masterService.getStatusBusy());






    }

    @Override
    public int getItemCount() {
        return masterServiceList.size();
    }

    public class MasterServiceHV extends RecyclerView.ViewHolder {
        TextView textViewNameMaster ;
        TextView nameofService;
        TextView workExperienceYear;
        ImageView imageMaster;
        TextView StatusFree;
        TextView StatusBusy;
        public MasterServiceHV(@NonNull View itemView) {
            super(itemView);
            textViewNameMaster = itemView.findViewById(R.id.textViewNameMaster);
        imageMaster=itemView.findViewById(R.id.imageMaster);
        StatusBusy=itemView.findViewById(R.id.StatusBusy);
        StatusFree=itemView.findViewById(R.id.StatusFree);
        nameofService=itemView.findViewById(R.id.NameOfService);
        workExperienceYear=itemView.findViewById(R.id.WorkExperienceYear);
        nameofService=itemView.findViewById(R.id.NameOfService);


        }
    }
}