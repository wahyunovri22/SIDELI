package creative.can.com.suratpengantar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import creative.can.com.suratpengantar.Model.ModelReadSurat;
import creative.can.com.suratpengantar.Model.SuratMenungguDiketahui;
import creative.can.com.suratpengantar.R;

/**
 * Created by cia on 14/12/2017.
 */

public class DitolakAdapter extends RecyclerView.Adapter<DitolakAdapter.DitolakHolder>{


    private List<SuratMenungguDiketahui> dataModels;
    private Context context;

    public DitolakAdapter( Context context, List<SuratMenungguDiketahui> dataModels) {
        this.dataModels = dataModels;
        this.context = context;
    }
    @Override
    public DitolakHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_waiting,parent,false);
        DitolakHolder holder = new DitolakHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(DitolakHolder holder, int position) {
        SuratMenungguDiketahui data = dataModels.get(position);
        holder.nik.setText(dataModels.get(position).getNIK());
        holder.nama.setText(dataModels.get(position).getPERNAMAWARGA());
        holder.alamat.setText(dataModels.get(position).getPERALAMAT());
        holder.surat.setText(dataModels.get(position).getSNAMA());
        holder.tanggal.setText(dataModels.get(position).getPERCREATEDAT());
        holder.status.setText(dataModels.get(position).getPERSTATUS());
        holder.dm = data;
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class DitolakHolder extends RecyclerView.ViewHolder{

        TextView nik,nama,alamat,rt,rw,surat,keperluan,tanggal,status;
        SuratMenungguDiketahui dm;

        public DitolakHolder(View itemView) {
            super(itemView);

            nik = (TextView)itemView.findViewById(R.id.txt_nik);
            nama = (TextView)itemView.findViewById(R.id.txt_nama);
            alamat = (TextView)itemView.findViewById(R.id.txt_alamat);
            rt = (TextView)itemView.findViewById(R.id.txt_rt);
            rw = (TextView)itemView.findViewById(R.id.txt_rw);
            surat = (TextView)itemView.findViewById(R.id.txt_surat);
            keperluan = (TextView)itemView.findViewById(R.id.txt_keperluan);
            tanggal = (TextView)itemView.findViewById(R.id.txt_tanggal);
            status = (TextView)itemView.findViewById(R.id.txt_status);
        }
    }
}
