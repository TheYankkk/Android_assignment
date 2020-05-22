package com.example.justeat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {


    public ResultFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    public void showResult(int id) {
        int images[] = {R.drawable.item1, R.drawable.item5, R.drawable.item6};
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);
        imageView.setImageResource(images[id]);
    }

}