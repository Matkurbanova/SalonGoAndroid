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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.PersonalKabinet;
import kg.salongo.android.R;

public class PersonalKabinetAdapter extends RecyclerView.Adapter<PersonalKabinetAdapter.PersonalKabinetVH> {
    private List<PersonalKabinet> personalKabinetList = new ArrayList<>();
    private Context context;

    public PersonalKabinetAdapter(Context context) {
        this.context = context;
    }

    public void setPersonalKabinet(List<PersonalKabinet> personalKabinets) {
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
        holder.textViewSalonName.setText(personalKabinet.getNameSalon());
        holder.textViewSubCatygoryName.setText(personalKabinet.getNameSubCategory());
        holder.textViewaddress.setText(personalKabinet.getAddress());
        holder.textViewWorkTime.setText(personalKabinet.getWorkTime());
        holder.textClose.setText(personalKabinet.getClose());


        if (!personalKabinet.getImage().isEmpty())
            Picasso.get()
                    .load(personalKabinet.getImage())
                    .into(holder.imageViewLogo);
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

        TextView textViewSalonName;
        TextView textViewSubCatygoryName;
        TextView textViewaddress;
        TextView textViewWorkTime;
        ImageView imageViewLogo;
        Button buttonprice;
        TextView textClose;
        ImageView imageViewShere;
        ImageView imageViewDelete;

        public PersonalKabinetVH(@NonNull View itemView) {
            super(itemView);

            textViewSalonName=itemView.findViewById(R.id.textViewNameMaster);
            textViewSubCatygoryName=itemView.findViewById(R.id.textViewNameSubcat);
            textViewaddress=itemView.findViewById(R.id.textViewAddress);
            textViewWorkTime=itemView.findViewById(R.id.textViewWorkTime);
            imageViewLogo=itemView.findViewById(R.id.imageViewServiceLogo);
            buttonprice=itemView.findViewById(R.id.button);
            textClose=itemView.findViewById(R.id.textClose);
            imageViewShere=itemView.findViewById(R.id.imageViewshere);
            imageViewDelete=itemView.findViewById(R.id.imageViewDelete);

        }
    }
}
