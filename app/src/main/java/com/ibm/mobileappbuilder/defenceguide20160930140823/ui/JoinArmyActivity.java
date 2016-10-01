

package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * JoinArmyActivity list activity
 */
public class JoinArmyActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.joinArmyActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return JoinArmyFragment.class;
    }

}

