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

        TextView nameSalon;
        TextView nameSubCategory;
        TextView address;
        TextView workTime;
        ImageView image;
        Button price;
        TextView close;
        ImageView imageViewShere;
        ImageView imageViewDelete;

        public PersonalKabinetVH(@NonNull View itemView) {
            super(itemView);
            nameSalon=itemView.findViewById(R.id.textViewNameMAster);
            nameSubCategory=itemView.findViewById(R.id.textViewNameSubcat);
            address=itemView.findViewById(R.id.textViewAddress);
            workTime=itemView.findViewById(R.id.textViewWorkTime);
            image=itemView.findViewById(R.id.imageViewServiceLogo);
            price=itemView.findViewById(R.id.button);
            close=itemView.findViewById(R.id.textClose);
            imageViewShere=itemView.findViewById(R.id.imageViewshere);
            imageViewDelete=itemView.findViewById(R.id.imageViewDelete);

        }
    }
}
