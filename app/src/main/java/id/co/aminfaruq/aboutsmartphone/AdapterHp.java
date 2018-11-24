package id.co.aminfaruq.aboutsmartphone;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterHp extends RecyclerView.Adapter<AdapterHp.ViewHolder> {
    Context context;
    String[] judul,isi;
    int[]gambar;

    public AdapterHp(Context context, String[] judul, String[] isi, int[] gambar) {
        this.context = context;
        this.judul = judul;
        this.isi = isi;
        this.gambar = gambar;
    }

    @NonNull
    @Override
    public AdapterHp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_hp,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHp.ViewHolder viewHolder, final int i) {
        viewHolder.judul.setText(judul[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.gambar);

        viewHolder.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailHp.class);
                intent.putExtra("gambar",gambar[i]);
                intent.putExtra("judul",judul[i]);
                intent.putExtra("isi",isi[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnReview;
        TextView judul;
        ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txtJudul);
            gambar = itemView.findViewById(R.id.imgHp);
            btnReview = itemView.findViewById(R.id.btnReview);
        }
    }
}
