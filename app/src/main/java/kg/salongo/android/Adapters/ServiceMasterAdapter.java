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
import kg.salongo.android.Data.Service;
import kg.salongo.android.R;
import kg.salongo.android.View.MasterServiceFragment;
import kg.salongo.android.View.ServiceFragment;

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




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MasterServiceHV extends RecyclerView.ViewHolder {
        TextView textViewNameMaster ;
        TextView textViewSubCatygoryName;
        TextView textViewaddress;
        TextView textViewWorkTime;
        ImageView imageViewLogo;
        Button buttonprice;
        TextView textClose;
        public MasterServiceHV(@NonNull View itemView) {
            super(itemView);
        }
    }
}