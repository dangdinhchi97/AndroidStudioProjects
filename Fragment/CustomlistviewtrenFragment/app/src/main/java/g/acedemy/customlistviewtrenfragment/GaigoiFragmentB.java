package g.acedemy.customlistviewtrenfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class GaigoiFragmentB extends Fragment {
    ListView lvb;
    ListView lv_main;
    GaigoiAdapter adapter;
    ArrayList<Gaigoi> object;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.gaigoifragmentb,container,false);

        object=new ArrayList<>();
        object.add(new Gaigoi(false,"Tran thu Tam",19,R.drawable.gg1));
        object.add(new Gaigoi(false,"Tran thu Tam",19,R.drawable.gg1));
        object.add(new Gaigoi(false,"Tran thu Tam",19,R.drawable.gg1));
        lvb= (ListView)view. findViewById(R.id.lvb);

        adapter=new GaigoiAdapter(getActivity(),R.layout.gaigoiform,object);
        lvb.setAdapter(adapter);
        return view;
    }
}
