

package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ibmmobileappbuilder.ui.BaseDetailActivity;

/**
 * JoinAirForceDetailActivity detail activity
 */
public class JoinAirForceDetailActivity extends BaseDetailActivity {
  
  	@Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return JoinAirForceDetailFragment.class;
    }
}


