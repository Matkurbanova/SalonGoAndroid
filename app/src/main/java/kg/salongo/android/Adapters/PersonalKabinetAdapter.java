package kg.salongo.android.Adapters;

import android.content.Context;
import android.content.Intent;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Data.PersonalKabinet;
import kg.salongo.android.R;
import kg.salongo.android.View.PersonalKabinetFragment;

public class PersonalKabinetAdapter extends RecyclerView.Adapter<PersonalKabinetAdapter.PersonalKabinetVH> {
    private List<PersonalKabinet> personalKabinetList = new ArrayList<>();
    private Context context;

    public PersonalKabinetAdapter(Context context, PersonalKabinetFragment personalKabinetFragment) {
        this.context = context;
    }

    public void setPersonalKabinetList(List<PersonalKabinet> personalKabinets) {
        personalKabinetList.clear();
        personalKabinetList.addAll(personalKabinets);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonalKabinetAdapter.PersonalKabinetVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_personalkabinet, parent, false);
        return new PersonalKabinetVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PersonalKabinetVH holder, int position) {

        final PersonalKabinet personalKabinet = personalKabinetList.get(position);
//        holder.nameSalon.setText(personalKabinet.getNameSalon());
//        holder.nameSubCategory.setText(personalKabinet.getNameSubCategory());
//        holder.address.setText(personalKabinet.getAddress());
//        holder.workTime.setText(personalKabinet.getWorkTime());
//        holder.close.setText(personalKabinet.getClose());

//
//        if (!personalKabinet.getImage().isEmpty())
//            Picasso.get()
//                    .load(personalKabinet.getImage())
//                    .into(holder.image);
        holder.imageViewShere.setOnClickListener(v -> {
            sharePersonal(personalKabinet.getLinks());
        });

    }


    @Override
    public int getItemCount() {
        return personalKabinetList.size();
    }

    private void sharePersonal(String url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(share, context.getString(R.string.share)));
    }


    public class PersonalKabinetVH extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewNameMAster)
        TextView nameSalon;
        @BindView(R.id.textViewNameSubcat)
        TextView nameSubCategory;
        @BindView(R.id.textViewAddress)
        TextView address;
        @BindView(R.id.textViewWorkTime)
        TextView workTime;
        @BindView(R.id.imageViewServiceLogo)
        ImageView image;
        @BindView(R.id.button)
        Button price;
        @BindView(R.id.textClose)
        TextView close;
        @BindView(R.id.imageViewshere)
        ImageView imageViewShere;
        @BindView(R.id.imageViewDelete)
        ImageView imageViewDelete;

        public PersonalKabinetVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
