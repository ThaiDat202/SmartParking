package com.example.smartparking;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinner);

        List<String> items = new ArrayList<>();
        items.add("Tất Cả");
        items.add("Mới Nhất");
        items.add("Uy Tín");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Xử lý khi một mục được chọn
                String selectedText = items.get(position);
                // Hiển thị các TextView hoặc thực hiện các tác vụ khác dựa trên sự lựa chọn này
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Xử lý khi không có mục nào được chọn (tùy chọn)
            }
        });
        //SearchView searchView = rootView.findViewById(R.id.searchView);
        //searchView.setQuery("Tìm kiếm nhà xe", false);

        SearchView searchView = rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Xử lý tìm kiếm ở đây, ví dụ tìm kiếm cơ sở dữ liệu và hiển thị kết quả
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý thay đổi văn bản trong ô tìm kiếm ở đây (nếu cần)
                if (newText.isEmpty()) {
                    searchView.setQueryHint("Tìm kiếm ở đây");
                } else {
                    searchView.setQueryHint(null); // Xóa văn bản dự phòng khi có văn bản mới
                }
                return true;
            }
        });





        return rootView;
        //return inflater.inflate(R.layout.fragment_search, container, false);



    }
}