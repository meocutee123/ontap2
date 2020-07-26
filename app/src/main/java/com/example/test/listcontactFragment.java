package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.controller.Icontroller;
import com.example.test.model.contact;

import java.util.List;


public class listcontactFragment extends Fragment  {

    Toolbar toolbar;
    RecyclerView recyclerView;

    NavController navController;
    Icontroller controller;

    List<contact> contactList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listcontact, container, false);
        
        addview(view);
        getdata();
        addevent();
        return view;
    }

    private void addview(View view) {

        toolbar = view.findViewById(R.id.tbds);
        toolbar.inflateMenu(R.menu.my_menu);
        recyclerView = view.findViewById(R.id.listds);
        recyclerView.setLayoutManager(new LinearLayoutManager(listcontactFragment.this.getActivity()));

        navController = NavHostFragment.findNavController(listcontactFragment.this);
        controller = ((MainActivity)getActivity()).controller;
    }

    private void getdata() {
        contactList = controller.getAllcontact();
        ContactAdapter adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);
    }

    private void addevent() {


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Bundle data = new Bundle();
                data.putInt("kt", 0);
                data.putInt("id", contactList.size()+1);
                navController.navigate(R.id.action_listcontactFragment_to_editFragment,data);
                return true;
            }
        });

    }

    private class ContactViewHolder extends RecyclerView.ViewHolder
    {

        //khai bao cac bien trong 1 thanh phan viewholder(phan tu lap di lap lai) cua adapter
        TextView txtten, txtbir, txtphone;
        ImageView imvedit;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.txtname);
            txtbir = itemView.findViewById(R.id.txtbir);
            txtphone = itemView.findViewById(R.id.txtphone);
            imvedit  = itemView.findViewById(R.id.imvedit);
            //anh xa cac bien vao itemView (View duoc tao rieng cho viewholder)--

            //bat cac su kien co cac thanh phan (neu co)--

        }

        public void bind(contact p)
        {
            //truyen du lieu vao cac thanh phan trong viewholder tu list trong adater--

            txtten.setText(p.getName());
            txtbir.setText(p.getBir());
            txtphone.setText(p.getPhone());

        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>
    {
        List<contact> listContact;
        //danh sach cac phan tu can truyen vao viewholder

        public ContactAdapter(List<contact> listContact) {
            this.listContact = listContact;
        }


        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact, parent, false);
            //lay view tu thu muc Res (product) de gan vao cho cac viewholder
            return new ContactViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
            holder.bind(listContact.get(position));
            //goi ham bind da viet ben viewholder truyen du lieu vao tung viewholder
            holder.imvedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle data = new Bundle();
                    data.putInt("kt", 1);
                    data.putInt("id", contactList.get(position).getID());
                    data.putString("ten", contactList.get(position).getName());
                    data.putString("bir", contactList.get(position).getBir());
                    data.putString("phone", contactList.get(position).getPhone());
                    data.putString("address", contactList.get(position).getAddress());
                    navController.navigate(R.id.action_listcontactFragment_to_editFragment,data);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listContact.size();
        }
    }
}