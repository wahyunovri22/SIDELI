package creative.can.com.suratpengantar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import creative.can.com.suratpengantar.Activity.DetailNewsDuaActivity;
import creative.can.com.suratpengantar.Model.DataModel;
import creative.can.com.suratpengantar.R;

/**
 * Created by cia on 12/12/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<DataModel> dataModels;
    private Context context;

    public NewsAdapter( Context context, List<DataModel> dataModels) {
        this.dataModels = dataModels;
        this.context = context;
    }
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news,parent,false);
        NewsHolder holder = new NewsHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        DataModel data = dataModels.get(position);
        holder.txtTanggal.setText(dataModels.get(position).getNTANGGAL());
        holder.txtCeated.setText(dataModels.get(position).getNISINEWS());
        holder.dm = data;
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{

        TextView txtTanggal,txtCeated;
        DataModel dm;
        public NewsHolder(View itemView) {
            super(itemView);

            txtTanggal = (TextView)itemView.findViewById(R.id.txt_detail_tanggal);
            txtCeated = (TextView)itemView.findViewById(R.id.txt_detail_news);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailNewsDuaActivity.class);
                    intent.putExtra("tanggal", dm.getNTANGGAL());
                    intent.putExtra("pembuat", dm.getNCREATEDBY());
                    intent.putExtra("isi", dm.getNISINEWS());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
