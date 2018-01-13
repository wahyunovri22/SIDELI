package creative.can.com.suratpengantar.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import creative.can.com.suratpengantar.Model.ModelReadSurat;
import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.Model.SuratMenungguDiketahui;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cia on 13/12/17.
 */

public class SuratMasukRW extends RecyclerView.Adapter<SuratMasukRW.SuratHolder> {

    private List<SuratMenungguDiketahui> dataModels;
    private Context context;

    public SuratMasukRW( Context context, List<SuratMenungguDiketahui> dataModels) {
        this.dataModels = dataModels;
        this.context = context;
    }
    @Override
    public SuratHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_waiting,parent,false);
        SuratHolder holder = new SuratHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(SuratHolder holder, int position) {
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

    public class SuratHolder extends RecyclerView.ViewHolder {

        TextView nik,nama,alamat,surat,tanggal,status;
        SuratMenungguDiketahui dm;
        public SuratHolder(View itemView) {
            super(itemView);

            nik = (TextView)itemView.findViewById(R.id.txt_nik);
            nama = (TextView)itemView.findViewById(R.id.txt_nama);
            alamat = (TextView)itemView.findViewById(R.id.txt_alamat);
            surat = (TextView)itemView.findViewById(R.id.txt_surat);
            tanggal = (TextView)itemView.findViewById(R.id.txt_tanggal);
            status = (TextView)itemView.findViewById(R.id.txt_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final CharSequence[] dialogItem = {"Detail", "OK"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Pilihan");
                    builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String mNik = dm.getPERID();
                            String mStatus = "WAITING_KADES";
                            switch(i){
                                case 0 :

                                    break;
                                case 1 :
                                    ApiRequest ap3 = RetrofitConfig.getRetrofit().create(ApiRequest.class);
                                    Call<ResponseModel> send3 = ap3.postSuratMasuk(mNik, mStatus);
                                    send3.enqueue(new Callback<ResponseModel>() {
                                        @Override
                                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                            Log.d("RETRO", "response : " + response.body().toString());
                                            String kode = response.body().getKode();
                                            String pesan = response.body().getPesan();

                                            if (kode.equals("1")){
                                                Toast.makeText(context, pesan, Toast.LENGTH_SHORT).show();
                                            }else {
                                                Toast.makeText(context, pesan, Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                                            Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                                            Log.d("RETRO", "Falure : " + t.getMessage());
                                        }
                                    });
                                    break;
                            }
                        }
                    });
                    builder.create().show();
                }
            });
        }
    }
}
