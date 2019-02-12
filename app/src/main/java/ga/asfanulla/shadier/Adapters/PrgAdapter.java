package ga.asfanulla.shadier.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ga.asfanulla.shadier.R;

public class PrgAdapter extends RecyclerView.Adapter<PrgAdapter.MyViewHolder>{

    private Context context;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private String key;

    // private ArrayList<HashMap<String ,String>> plist;

    public PrgAdapter(Context context, String key){
        super();
        this.context = context;
        this.key = key;
        //this.plist = plist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LikeButton thup;
        private ImageView comm, shar,media_image;
        private TextView name, vname, desc, pDate;

        public MyViewHolder(View view) {
            super(view);

            if(key.equals("pr")) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((FoldingCell) view).toggle(false);
                        registerToggle(getAdapterPosition());
                    }
                });
            }

        }
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    @NonNull
    @Override
    public PrgAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        if(key.equals("pr")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pr_crd, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ins_card, parent, false);
        }
        return new  MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrgAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
