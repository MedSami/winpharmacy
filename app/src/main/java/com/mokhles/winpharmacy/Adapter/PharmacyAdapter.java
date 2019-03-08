package com.mokhles.winpharmacy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mokhles.winpharmacy.DemandeConseil;
import com.mokhles.winpharmacy.Model.DataModel;
import com.mokhles.winpharmacy.R;

import java.util.List;
import java.util.Locale;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    String btnClicked,idUtilisateur,idPharmacien;

    public PharmacyAdapter(List<DataModel> items, Context ctx,String btnClicked,String idUtilisateur) {
        this.items = items;
        this.ctx=ctx;
        this.btnClicked=btnClicked;
        this.idUtilisateur=idUtilisateur;

    }

    @Override
    public PharmacyAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_pharmacies,viewGroup,false);

        PharmacyAdapter.ActorViewHolder Actionview = new PharmacyAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(PharmacyAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        idPharmacien=dm.getId_pharmacien();
        holder.txtPharmacy.setText(" "+dm.getNom());
        holder.txtCoordonnee.setText(" "+dm.getTel()+", ("+dm.getType()+")");
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtPharmacy,txtCoordonnee;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtPharmacy =  itemView.findViewById(R.id.txtPharmacy);
            txtCoordonnee =  itemView.findViewById(R.id.txtCoordonnee);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        if(btnClicked.equals("localiser")) {
                            /*Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                    Uri.parse("http://maps.google.com/maps?saddr=35.6658971,10.0921316&daddr=" + dm.getLatitude() + "," + dm.getLongitude()));
                            ctx.startActivity(intent);*/
                            String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=" + dm.getLatitude() + "," + dm.getLongitude());
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                            intent.setPackage("com.google.android.apps.maps");
                            ctx.startActivity(intent);

                        }
                    if(btnClicked.equals("conseil")) {
                        Intent intent = new Intent(ctx, DemandeConseil.class);
                        intent.putExtra("idUtilisateur",idUtilisateur);
                        intent.putExtra("idPharmacien",idPharmacien);
                        ctx.startActivity(intent);
                    }
                }
            });

        }
    }


}