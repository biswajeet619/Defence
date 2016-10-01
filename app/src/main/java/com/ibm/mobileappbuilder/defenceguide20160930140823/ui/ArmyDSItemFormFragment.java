
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.ArmyDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.ArmyDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.JoinArmyFormPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ui.FormFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.views.TextWatcherAdapter;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.ArmyDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.ArmyDS;

public class ArmyDSItemFormFragment extends FormFragment<ArmyDSItem> {

    private CrudDatasource<ArmyDSItem> datasource;

    public static ArmyDSItemFormFragment newInstance(Bundle args){
        ArmyDSItemFormFragment fr = new ArmyDSItemFormFragment();
        fr.setArguments(args);

        return fr;
    }

    public ArmyDSItemFormFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // the presenter for this view
        setPresenter(new JoinArmyFormPresenter(
                (CrudDatasource) getDatasource(),
                this));

            }

    @Override
    protected ArmyDSItem newItem() {
        return new ArmyDSItem();
    }

    private ArmyDSService getRestService(){
        return ArmyDSService.getInstance();
    }

    @Override
    protected int getLayout() {
        return R.layout.joinarmy_form;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final ArmyDSItem item, View view) {
        
        bindString(R.id.armyds_post, item.post, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.post = s.toString();
            }
        });
        
        
        bindString(R.id.armyds_qualification, item.qualification, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.qualification = s.toString();
            }
        });
        
        
        bindDouble(R.id.armyds_percentagerequired, item.percentagerequired, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.percentagerequired = StringUtils.parseDouble(s.toString());
            }
        });
        
        
        bindString(R.id.armyds_role, item.role, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.role = s.toString();
            }
        });
        
        
        bindString(R.id.armyds_selectionprocess, item.selectionprocess, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.selectionprocess = s.toString();
            }
        });
        
        
        bindString(R.id.armyds_websiteforapplication, item.websiteForApplication, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.websiteForApplication = s.toString();
            }
        });
        
        
        bindString(R.id.armyds_furtherpromotions, item.furtherpromotions, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.furtherpromotions = s.toString();
            }
        });
        
        
        bindString(R.id.armyds_examtobewritten, item.examToBeWritten, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.examToBeWritten = s.toString();
            }
        });
        
    }

    @Override
    public Datasource<ArmyDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = ArmyDS.getInstance(new SearchOptions());
        return datasource;
    }
}

