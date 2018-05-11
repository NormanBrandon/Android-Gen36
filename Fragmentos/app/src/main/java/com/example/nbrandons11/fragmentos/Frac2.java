package com.example.nbrandons11.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Frac2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frac2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frac2 extends Fragment {

    TextView tv;

    String textoGuardado;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View vista;
    private OnFragmentInteractionListener mListener;
    Button b1,b2,b3,b4,b5;

    public Frac2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frac2.
     */
    // TODO: Rename and change types and number of parameters
    public static Frac2 newInstance(String param1, String param2) {
        Frac2 fragment = new Frac2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frac2, container, false);

        if(savedInstanceState==null){

        }else {//restaurar el texto

            textoGuardado = savedInstanceState.getString("texto");
            tv=(TextView) v.findViewById(R.id.texto);
            tv.setText("tu gfa");

        }



        initUI(v);

        return v;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private void initUI(View v){

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            b1.setText("Me puchaste we");

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                b2.setText("Me puchaste we");
            }
        });
    }
    public void cambiarTexto(String texto){
        this.textoGuardado =texto;//almacenar en la variable cualquier cambio, del texto

        tv.setText(texto);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {//guardar el texto

        super.onSaveInstanceState(outState);
        outState.putString("texto", textoGuardado);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
