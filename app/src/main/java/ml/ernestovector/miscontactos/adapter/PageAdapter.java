package ml.ernestovector.miscontactos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> fragments;

    //Metodo Constructor
    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    //Mostrar el fragment actual
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //Cantidad de fragments
    @Override
    public int getCount() {
        return fragments.size();
    }
}
