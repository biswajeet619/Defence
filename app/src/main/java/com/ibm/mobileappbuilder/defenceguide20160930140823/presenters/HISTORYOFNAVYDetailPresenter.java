
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDSItem;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.mvp.view.DetailView;

public class HISTORYOFNAVYDetailPresenter extends BasePresenter implements DetailCrudPresenter<HISTORYOFNAVYDSItem>,
      Datasource.Listener<HISTORYOFNAVYDSItem> {

    private final CrudDatasource<HISTORYOFNAVYDSItem> datasource;
    private final DetailView view;

    public HISTORYOFNAVYDetailPresenter(CrudDatasource<HISTORYOFNAVYDSItem> datasource, DetailView view){
        this.datasource = datasource;
        this.view = view;
    }

    @Override
    public void deleteItem(HISTORYOFNAVYDSItem item) {
        datasource.deleteItem(item, this);
    }

    @Override
    public void editForm(HISTORYOFNAVYDSItem item) {
        view.navigateToEditForm();
    }

    @Override
    public void onSuccess(HISTORYOFNAVYDSItem item) {
                view.showMessage(R.string.item_deleted, true);
        view.close(true);
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic, true);
    }
}

