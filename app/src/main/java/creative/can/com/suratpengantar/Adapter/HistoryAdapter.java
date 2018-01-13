package creative.can.com.suratpengantar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import creative.can.com.suratpengantar.Model.SuratMenungguDiketahui;
import creative.can.com.suratpengantar.R;

/**
 * Created by cia on 28/12/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder>  {

    private List<SuratMenungguDiketahui> dataModels;
    private Context context;

    public HistoryAdapter( Context context, List<SuratMenungguDiketahui> dataModels) {
        this.dataModels = dataModels;
        this.context = context;
    }
    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder{

        TextView nik,nama,alamat,surat,tanggal;
        SuratMenungguDiketahui dm;
        public HistoryHolder(View itemView) {
            super(itemView);
            nik = (TextView)itemView.findViewById(R.id.txt_nik);
            nama = (TextView)itemView.findViewById(R.id.txt_nama);
            alamat = (TextView)itemView.findViewById(R.id.txt_alamat);
            surat = (TextView)itemView.findViewById(R.id.txt_surat);
            tanggal = (TextView)itemView.findViewById(R.id.txt_tanggal);
        }
    }
}
