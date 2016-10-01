package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "HISTORYOFARMYFragment" listing
 */
public class HISTORYOFARMYFragment extends ListGridFragment<HISTORYOFARMYDSItem>  {

    private Datasource<HISTORYOFARMYDSItem> datasource;


    public static HISTORYOFARMYFragment newInstance(Bundle args) {
        HISTORYOFARMYFragment fr = new HISTORYOFARMYFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected SearchOptions getSearchOptions() {
      SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
      return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.historyofarmy_item;
    }

    @Override
    protected Datasource<HISTORYOFARMYDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = HISTORYOFARMYDS.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(HISTORYOFARMYDSItem item, View view, int position) {
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.history != null){
            title.setText(item.history);
            
        }
    }


    @Override
    public void showDetail(HISTORYOFARMYDSItem item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), HISTORYOFARMYDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

