
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.JoinNavyFormPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ui.FormFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.views.TextWatcherAdapter;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDS;

public class NavyDSItemFormFragment extends FormFragment<NavyDSItem> {

    private CrudDatasource<NavyDSItem> datasource;

    public static NavyDSItemFormFragment newInstance(Bundle args){
        NavyDSItemFormFragment fr = new NavyDSItemFormFragment();
        fr.setArguments(args);

        return fr;
    }

    public NavyDSItemFormFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // the presenter for this view
        setPresenter(new JoinNavyFormPresenter(
                (CrudDatasource) getDatasource(),
                this));

            }

    @Override
    protected NavyDSItem newItem() {
        return new NavyDSItem();
    }

    private NavyDSService getRestService(){
        return NavyDSService.getInstance();
    }

    @Override
    protected int getLayout() {
        return R.layout.joinnavy_form;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final NavyDSItem item, View view) {
        
        bindString(R.id.navyds_post, item.post, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.post = s.toString();
            }
        });
        
        
        bindString(R.id.navyds_qualification, item.qualification, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.qualification = s.toString();
            }
        });
        
        
        bindDouble(R.id.navyds_percentagerequired, item.percentageRequired, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.percentageRequired = StringUtils.parseDouble(s.toString());
            }
        });
        
        
        bindString(R.id.navyds_selectionprocess, item.selectionProcess, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.selectionProcess = s.toString();
            }
        });
        
        
        bindString(R.id.navyds_role, item.role, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.role = s.toString();
            }
        });
        
        
        bindString(R.id.navyds_websiteforapplication, item.websiteForApplication, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.websiteForApplication = s.toString();
            }
        });
        
        
        bindString(R.id.navyds_furtherpromotions, item.furtherpromotions, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.furtherpromotions = s.toString();
            }
        });
        
        
        bindString(R.id.navyds_examstobewritten, item.examsToBeWritten, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.examsToBeWritten = s.toString();
            }
        });
        
    }

    @Override
    public Datasource<NavyDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = NavyDS.getInstance(new SearchOptions());
        return datasource;
    }
}

