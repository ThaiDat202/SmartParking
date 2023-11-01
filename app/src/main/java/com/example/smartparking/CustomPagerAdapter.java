package com.example.smartparking;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public class CustomPagerAdapter extends FragmentStateAdapter {
    public CustomPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new UndischargeFragment(); // Thay thế bằng lớp Fragment của bạn
        } else {
            return new DischargeFragment(); // Thay thế bằng lớp Fragment của bạn
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Số lượng tab, trong trường hợp này, là 2
    }
}
