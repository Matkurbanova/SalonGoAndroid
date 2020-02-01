package kg.salongo.android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.salongo.android.Data.Promo;
import kg.salongo.android.R;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoVH> {

    private List<Promo> promoList = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;
    private boolean isUserPromo;

    public PromoAdapter(Context context, boolean isUserPromo) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.isUserPromo = isUserPromo;
    }

    public void setPromoList(List<Promo> promo) {
        promoList.clear();
        promoList.addAll(promo);
        notifyDataSetChanged();
    }

    private void sharePromo(String url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(share, context.getString(R.string.share_promo)));
    }

    @NonNull
    @Override
    public PromoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_aksii, parent, false);
        return new PromoVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.PromoVH holder, final int position) {
        final Promo promo = promoList.get(position);
        holder.textViewName.setText(promo.getTextViewName());
        holder.textViewNewPrice.setText("" + promo.getNewPrice());
        holder.textViewOldPrice.setPaintFlags(holder.textViewOldPrice.getPaintFlags() |
                Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textViewProductInfo.setText(promo.getPromoDescription());
        if (isUserPromo)
            holder.imageViewDelete.setVisibility(View.VISIBLE);
        else
            holder.imageViewDelete.setVisibility(View.GONE);

        holder.promoShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharePromo(promo.getLinks());
            }
        });
    }

    @Override
    public int getItemCount() {
        return promoList.size();

    }

    public class PromoVH extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewOldPrice;
        private TextView textViewNewPrice;
        private TextView textViewProductInfo;
        private ImageView promoShare;
        private ImageView Liked;
        private ImageView imageViewDelete;
        public PromoVH(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewOldPrice = itemView.findViewById(R.id.OldPrice);
            textViewNewPrice = itemView.findViewById(R.id.NewPrice);
            textViewProductInfo = itemView.findViewById(R.id.PromoInfo);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
            promoShare = itemView.findViewById(R.id.promoShare);
        }
    }


}