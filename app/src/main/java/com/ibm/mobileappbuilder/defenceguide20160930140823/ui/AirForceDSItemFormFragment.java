
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.JoinAirForceFormPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ui.FormFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.views.TextWatcherAdapter;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDS;

public class AirForceDSItemFormFragment extends FormFragment<AirForceDSItem> {

    private CrudDatasource<AirForceDSItem> datasource;

    public static AirForceDSItemFormFragment newInstance(Bundle args){
        AirForceDSItemFormFragment fr = new AirForceDSItemFormFragment();
        fr.setArguments(args);

        return fr;
    }

    public AirForceDSItemFormFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // the presenter for this view
        setPresenter(new JoinAirForceFormPresenter(
                (CrudDatasource) getDatasource(),
                this));

            }

    @Override
    protected AirForceDSItem newItem() {
        return new AirForceDSItem();
    }

    private AirForceDSService getRestService(){
        return AirForceDSService.getInstance();
    }

    @Override
    protected int getLayout() {
        return R.layout.joinairforce_form;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final AirForceDSItem item, View view) {
        
        bindString(R.id.airforceds_post, item.post, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.post = s.toString();
            }
        });
        
        
        bindString(R.id.airforceds_qualification, item.qualification, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.qualification = s.toString();
            }
        });
        
        
        bindString(R.id.airforceds_examstobewritten, item.examstobewritten, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.examstobewritten = s.toString();
            }
        });
        
        
        bindDouble(R.id.airforceds_percentagerequired, item.percentagerequired, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.percentagerequired = StringUtils.parseDouble(s.toString());
            }
        });
        
        
        bindString(R.id.airforceds_role, item.role, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.role = s.toString();
            }
        });
        
        
        bindString(R.id.airforceds_selectionprocess, item.selectionprocess, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.selectionprocess = s.toString();
            }
        });
        
        
        bindString(R.id.airforceds_furtherpromotions, item.furtherpromotions, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.furtherpromotions = s.toString();
            }
        });
        
        
        bindString(R.id.airforceds_websiteforapplication, item.websiteForApplication, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.websiteForApplication = s.toString();
            }
        });
        
        
        bindLong(R.id.airforceds_askexpert, item.askExpert, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.askExpert = StringUtils.parseLong(s.toString());
            }
        });
        
    }

    @Override
    public Datasource<AirForceDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = AirForceDS.getInstance(new SearchOptions());
        return datasource;
    }
}

