package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.HISTORYOFAIRFORCEPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.behaviors.FabBehaviour;
import ibmmobileappbuilder.behaviors.SelectionBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.Constants;
import ibmmobileappbuilder.util.ViewHolder;
import java.util.List;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDS;
import ibmmobileappbuilder.mvp.view.CrudListView;
import ibmmobileappbuilder.ds.CrudDatasource;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "HISTORYOFAIRFORCEFragment" listing
 */
public class HISTORYOFAIRFORCEFragment extends ListGridFragment<HISTORYOFAIRFORCEDSItem> implements CrudListView<HISTORYOFAIRFORCEDSItem> {

    private CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource;

    // "Add" button
    private FabBehaviour fabBehavior;

    public static HISTORYOFAIRFORCEFragment newInstance(Bundle args) {
        HISTORYOFAIRFORCEFragment fr = new HISTORYOFAIRFORCEFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(new HISTORYOFAIRFORCEPresenter(
            (CrudDatasource) getDatasource(),
            this
        ));
        // Multiple selection
        SelectionBehavior<HISTORYOFAIRFORCEDSItem> selectionBehavior = new SelectionBehavior<>(
            this,
            R.string.remove_items,
            R.drawable.ic_delete_alpha);

        selectionBehavior.setCallback(new SelectionBehavior.Callback<HISTORYOFAIRFORCEDSItem>() {
            @Override
            public void onSelected(List<HISTORYOFAIRFORCEDSItem> selectedItems) {
                getPresenter().deleteItems(selectedItems);
            }
        });
        addBehavior(selectionBehavior);
        // FAB button
        fabBehavior = new FabBehaviour(this, R.drawable.ic_add_white, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().addForm();
            }
        });
        addBehavior(fabBehavior);
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
        return R.layout.historyofairforce_item;
    }

    @Override
    protected Datasource<HISTORYOFAIRFORCEDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = HISTORYOFAIRFORCEDS.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(HISTORYOFAIRFORCEDSItem item, View view, int position) {
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.history != null){
            title.setText(item.history);
            
        }
    }

    @Override
    protected void itemClicked(final HISTORYOFAIRFORCEDSItem item, final int position) {
        fabBehavior.hide(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                getPresenter().detail(item, position);
            }
        });
    }

    @Override
    public void showDetail(HISTORYOFAIRFORCEDSItem item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), HISTORYOFAIRFORCEDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

    @Override
    public void showAdd() {
        startActivityForResult(generateIntentToAddOrUpdateItem(null,
                        0,
                        getActivity(),
                        HISTORYOFAIRFORCEDSItemFormActivity.class
                ), Constants.MODE_CREATE
        );
    }

    @Override
    public void showEdit(HISTORYOFAIRFORCEDSItem item, int position) {
    startActivityForResult(
                generateIntentToAddOrUpdateItem(item,
                        position,
                        getActivity(),
                        HISTORYOFAIRFORCEDSItemFormActivity.class
                ), Constants.MODE_EDIT
        );
    }
}

