package ga.asfanulla.shadier.Frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ga.asfanulla.shadier.Adapters.PrgAdapter;
import ga.asfanulla.shadier.R;

public class Prog_Frag extends Fragment{

    private View view;
    private PrgAdapter mAdapter;
    private RecyclerView recyclerView;

    public Prog_Frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.pr_frag, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        init();

        return view;
    }

    private void init(){
        mAdapter = new PrgAdapter(getContext(),"pr");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
