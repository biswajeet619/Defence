
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDSItem;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.mvp.view.DetailView;

public class HISTORYOFARMYDetailPresenter extends BasePresenter implements DetailCrudPresenter<HISTORYOFARMYDSItem>,
      Datasource.Listener<HISTORYOFARMYDSItem> {

    private final CrudDatasource<HISTORYOFARMYDSItem> datasource;
    private final DetailView view;

    public HISTORYOFARMYDetailPresenter(CrudDatasource<HISTORYOFARMYDSItem> datasource, DetailView view){
        this.datasource = datasource;
        this.view = view;
    }

    @Override
    public void deleteItem(HISTORYOFARMYDSItem item) {
        datasource.deleteItem(item, this);
    }

    @Override
    public void editForm(HISTORYOFARMYDSItem item) {
        view.navigateToEditForm();
    }

    @Override
    public void onSuccess(HISTORYOFARMYDSItem item) {
                view.showMessage(R.string.item_deleted, true);
        view.close(true);
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic, true);
    }
}

