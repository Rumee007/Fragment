package com.example.mobileapp.fragmentpb4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    private TextView msgTV;

    public FragmentTwo() {
        // Required empty public constructor
    }

    public static FragmentTwo getInstance(String msg) {
        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        fragmentTwo.setArguments(bundle);
        return fragmentTwo;
    }

    public static FragmentTwo getInstance() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        String twoMsg = getArguments().getString("msg");
        Toast.makeText(getContext(), twoMsg, Toast.LENGTH_SHORT).show();
        msgTV = v.findViewById(R.id.showMsg);
        try {
            String msg = getArguments().getString("msg");
            msgTV.setText(msg);
        } catch (NullPointerException e) {

        }
        return v;
    }
}
