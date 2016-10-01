

package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * ChooseYourPathFragment menu fragment.
 */
public class ChooseYourPathFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public ChooseYourPathFragment(){
        super();
    }

    // Factory method
    public static ChooseYourPathFragment newInstance(Bundle args) {
        ChooseYourPathFragment fragment = new ChooseYourPathFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Join AirForce")
            .setIcon(R.drawable.jpg_indianairforce449)
            .setAction(new StartActivityAction(JoinAirForceActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Join Navy")
            .setIcon(R.drawable.jpg_insteg1584)
            .setAction(new StartActivityAction(JoinNavyActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Join Army")
            .setIcon(R.drawable.jpg_vijaydiwas391)
            .setAction(new StartActivityAction(JoinArmyActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.chooseyourpath_item;
    }
}

