
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.ListCrudPresenter;
import ibmmobileappbuilder.mvp.view.CrudListView;

public class JoinAirForcePresenter extends BasePresenter implements ListCrudPresenter<AirForceDSItem>,
      Datasource.Listener<AirForceDSItem>{

    private final CrudDatasource<AirForceDSItem> crudDatasource;
    private final CrudListView<AirForceDSItem> view;

    public JoinAirForcePresenter(CrudDatasource<AirForceDSItem> crudDatasource,
                                         CrudListView<AirForceDSItem> view) {
       this.crudDatasource = crudDatasource;
       this.view = view;
    }

    @Override
    public void deleteItem(AirForceDSItem item) {
        crudDatasource.deleteItem(item, this);
    }

    @Override
    public void deleteItems(List<AirForceDSItem> items) {
        crudDatasource.deleteItems(items, this);
    }

    @Override
    public void addForm() {
        view.showAdd();
    }

    @Override
    public void editForm(AirForceDSItem item, int position) {
        view.showEdit(item, position);
    }

    @Override
    public void detail(AirForceDSItem item, int position) {
        view.showDetail(item, position);
    }

    @Override
    public void onSuccess(AirForceDSItem item) {
                view.showMessage(R.string.items_deleted);
        view.refresh();
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic);
    }

}

