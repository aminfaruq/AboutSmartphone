package id.co.aminfaruq.aboutsmartphone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailHp extends AppCompatActivity {

    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtJudulDetal)
    TextView txtJudulDetal;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hp);
        ButterKnife.bind(this);

        Glide.with(this).load(getIntent().getIntExtra("gambar",0)).into(imgDetail);
        txtJudulDetal.setText(getIntent().getStringExtra("judul"));
        txtDetail.setText(getIntent().getStringExtra("isi"));
    }
}
