package kg.salongo.android.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.KabinetMaster;
import kg.salongo.android.Data.MasterProfile;

public class KabinetMasterAdapter extends RecyclerView.Adapter<KabinetMasterAdapter.KabinetMasterVH> {
    private List<KabinetMaster> kabinetMasterList = new ArrayList<>();
    private Context context;
    public KabinetMasterAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public KabinetMasterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull KabinetMasterVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class KabinetMasterVH extends RecyclerView.ViewHolder {
        public KabinetMasterVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
