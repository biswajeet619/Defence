
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSItem;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.mvp.view.DetailView;

public class JoinAirForceDetailPresenter extends BasePresenter implements DetailCrudPresenter<AirForceDSItem>,
      Datasource.Listener<AirForceDSItem> {

    private final CrudDatasource<AirForceDSItem> datasource;
    private final DetailView view;

    public JoinAirForceDetailPresenter(CrudDatasource<AirForceDSItem> datasource, DetailView view){
        this.datasource = datasource;
        this.view = view;
    }

    @Override
    public void deleteItem(AirForceDSItem item) {
        datasource.deleteItem(item, this);
    }

    @Override
    public void editForm(AirForceDSItem item) {
        view.navigateToEditForm();
    }

    @Override
    public void onSuccess(AirForceDSItem item) {
                view.showMessage(R.string.item_deleted, true);
        view.close(true);
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic, true);
    }
}

