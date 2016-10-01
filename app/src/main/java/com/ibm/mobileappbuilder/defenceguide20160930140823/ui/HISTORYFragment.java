

package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * HISTORYFragment menu fragment.
 */
public class HISTORYFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public HISTORYFragment(){
        super();
    }

    // Factory method
    public static HISTORYFragment newInstance(Bundle args) {
        HISTORYFragment fragment = new HISTORYFragment();

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
            .setLabel("HISTORY OF AIRFORCE")
            .setIcon(R.drawable.png_defaultmenuicon)
            .setAction(new StartActivityAction(HISTORYOFAIRFORCEActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("HISTORY OF NAVY")
            .setIcon(R.drawable.png_defaultmenuicon)
            .setAction(new StartActivityAction(HISTORYOFNAVYActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("HISTORY OF ARMY")
            .setIcon(R.drawable.png_defaultmenuicon)
            .setAction(new StartActivityAction(HISTORYOFARMYActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public int getItemLayout() {
        return R.layout.history_item;
    }
}

