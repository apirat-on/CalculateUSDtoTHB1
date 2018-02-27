package apirat.krirk.ac.th.calculateusdtothb1.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import apirat.krirk.ac.th.calculateusdtothb1.MainActivity;
import apirat.krirk.ac.th.calculateusdtothb1.R;

/**
 * Created by playn on 2/27/2018.
 */

public class CalculateFragment extends Fragment{


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolber
        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
//        Exchange Controller
        Button button = getView().findViewById(R.id.btnExt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = getView().findViewById(R.id.edtmoney);
                String moneyString = editText.getText().toString().trim();

                if (moneyString.isEmpty()){
                    Toast.makeText(getActivity(), "Please Fill USD money", Toast.LENGTH_SHORT).show();
                }else {
                    double moneyADouble = Double.parseDouble(moneyString);
                    double answerADouble = moneyADouble * 33;

                    String answeString = Double.toString(answerADouble);

                    Toast.makeText(getActivity(), "Your" + moneyString + "USD.==>" + answeString + "THB.",
                            Toast.LENGTH_SHORT).show();

                    editText.setText("");
                }
            }
        });


    }// Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.feagment_calculate, container, false);
        return view;
    }
    }
