package com.example.test;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.controller.Icontroller;
import com.example.test.model.contact;


public class editFragment extends Fragment {

    Toolbar toolbar;
    EditText edtid,edtname, edtphone, edtbir, edtaddress;
    Button btnadd;
    
    NavController navController;
    contact contact;
    Icontroller controller;
    int id, kt;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        addview(view);
        getdata();
        addevent();
        
        return view;
    }

    private void addview(View view) {
        toolbar = view.findViewById(R.id.tbds);

        edtname = view.findViewById(R.id.edtname);
        edtid = view.findViewById(R.id.edtid);
        edtbir = view.findViewById(R.id.edtbir);
        edtphone = view.findViewById(R.id.edtbir);
        edtaddress = view.findViewById(R.id.edtaddress);
        btnadd = view.findViewById(R.id.btnadd);

        navController = NavHostFragment.findNavController(editFragment.this);
        controller = ((MainActivity)getActivity()).controller;
    }

    private void getdata() {
        Bundle data = getArguments();
        kt =  data.getInt("kt");
        id = data.getInt("id");
        if(kt == 0){
            edtid.setText(String.valueOf(id));
        }else
        {
            edtid.setText(String.valueOf(id));
            edtname.setText(data.getString("ten"));
            edtbir.setText(data.getString("bir"));
            edtphone.setText(data.getString("phone"));
            edtaddress.setText(data.getString("address"));
        }
    }


    private void addevent() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_editFragment_to_listcontactFragment);
            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact = new contact(id, edtname.getText().toString(), edtbir.getText().toString(), edtphone.getText().toString(), edtphone.getText().toString());

                if(kt == 0){
                    controller.add(contact);
                }else
                {
                    controller.edit(id ,contact);
                }

            }
        });
    }
}