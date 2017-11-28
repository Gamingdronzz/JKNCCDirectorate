package com.jknccdirectorate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.jknccdirectorate.Activity.MainActivity;
import com.jknccdirectorate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AimFragment extends Fragment {

    Animation animationTranslate1, animationTranslate2, animationTranslate3;
    LinearLayout layout1, layout2, layout3;

    public AimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aim, container, false);
        layout1 = (LinearLayout) view.findViewById(R.id.aim1);
        layout2 = (LinearLayout) view.findViewById(R.id.aim2);
        layout3 = (LinearLayout) view.findViewById(R.id.aim3);
        layout1.setVisibility(View.INVISIBLE);
        layout2.setVisibility(View.INVISIBLE);
        layout3.setVisibility(View.INVISIBLE);
        setupAnimations(view);

        return view;
    }

    private void setupAnimations(View view) {
        animationTranslate1 = AnimationUtils.loadAnimation(view.getContext(), R.anim.move);
        animationTranslate2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.move);
        animationTranslate3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.move);
        animationTranslate1.reset();
        animationTranslate2.reset();
        animationTranslate3.reset();
        layout1.setVisibility(View.VISIBLE);

        layout1.startAnimation(animationTranslate1);
        animationTranslate1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout2.setVisibility(View.VISIBLE);

                layout2.startAnimation(animationTranslate2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animationTranslate2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout3.setVisibility(View.VISIBLE);
                layout3.startAnimation(animationTranslate3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.aim));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }
}
