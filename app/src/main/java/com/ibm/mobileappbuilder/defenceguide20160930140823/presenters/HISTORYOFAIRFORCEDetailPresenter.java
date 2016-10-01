
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSItem;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.mvp.view.DetailView;

public class HISTORYOFAIRFORCEDetailPresenter extends BasePresenter implements DetailCrudPresenter<HISTORYOFAIRFORCEDSItem>,
      Datasource.Listener<HISTORYOFAIRFORCEDSItem> {

    private final CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource;
    private final DetailView view;

    public HISTORYOFAIRFORCEDetailPresenter(CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource, DetailView view){
        this.datasource = datasource;
        this.view = view;
    }

    @Override
    public void deleteItem(HISTORYOFAIRFORCEDSItem item) {
        datasource.deleteItem(item, this);
    }

    @Override
    public void editForm(HISTORYOFAIRFORCEDSItem item) {
        view.navigateToEditForm();
    }

    @Override
    public void onSuccess(HISTORYOFAIRFORCEDSItem item) {
                view.showMessage(R.string.item_deleted, true);
        view.close(true);
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic, true);
    }
}

