package id.co.aminfaruq.aboutsmartphone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myRecycleview)
    RecyclerView myRecycleview;
    String[] judul,detail;
    int[] gambar = {R.drawable.hpsatu,R.drawable.hpdua,R.drawable.hptiga,R.drawable.hpempat,R.drawable.hplima,R.drawable.hpenam,R.drawable.hptujuh,R.drawable.hpdelapan,R.drawable.hpsembilan,R.drawable.hpsepuluh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        judul = getResources().getStringArray(R.array.namaHp);
        detail = getResources().getStringArray(R.array.spekHp);

        AdapterHp adapterHp = new AdapterHp(this,judul,detail,gambar);

        myRecycleview.setHasFixedSize(true);
        myRecycleview.setLayoutManager(new LinearLayoutManager(this));
        myRecycleview.setAdapter(adapterHp);
    }
}
