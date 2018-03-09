package com.example.mobileapp.fragmentpb4;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private Context context;
    private Button btn;
    private MessageListener listener;


    private static final String TAG = FragmentOne.class.getSimpleName();
    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne getInstance(String msg){
        FragmentOne fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString("msg",msg);
        fragmentOne.setArguments(bundle);
        return fragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e(TAG, "Fragment: onCreateView called");
        String msg = getArguments().getString("msg");
        //Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        btn = v.findViewById(R.id.sendBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getMessage("from fragment one");
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (MessageListener) context;
        Log.e(TAG, "Fragment: onAttach called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Fragment: onCreate called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "Fragment: onActivityCreated called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "Fragment: onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "Fragment: onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "Fragment: onPause called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "Fragment: onDetach called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "Fragment: onDestroy called");
    }


    public interface MessageListener{
        void getMessage(String msg);
    }
}
