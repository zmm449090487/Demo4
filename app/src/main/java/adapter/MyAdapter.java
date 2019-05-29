package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.demo3.R;

import java.util.ArrayList;
import java.util.List;

import bean.ResultsBean;
import bean.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ResultsBean> list;

    public MyAdapter(Context context, ArrayList<ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_item_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ResultsBean resultsBean = list.get(i);
        Glide.with(context).load(list.get(i).getUrl()).into(viewHolder.img);
        viewHolder.title.setText(list.get(i).getDesc());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnClick(resultsBean,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<ResultsBean> resultsBeans) {
        if (list != null){
            list.clear();
            list.addAll(resultsBeans);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick{
        void OnClick(ResultsBean resultsBean,int position);
    }
}
