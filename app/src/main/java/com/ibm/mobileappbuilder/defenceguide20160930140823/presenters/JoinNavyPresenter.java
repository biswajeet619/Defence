
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.ListCrudPresenter;
import ibmmobileappbuilder.mvp.view.CrudListView;

public class JoinNavyPresenter extends BasePresenter implements ListCrudPresenter<NavyDSItem>,
      Datasource.Listener<NavyDSItem>{

    private final CrudDatasource<NavyDSItem> crudDatasource;
    private final CrudListView<NavyDSItem> view;

    public JoinNavyPresenter(CrudDatasource<NavyDSItem> crudDatasource,
                                         CrudListView<NavyDSItem> view) {
       this.crudDatasource = crudDatasource;
       this.view = view;
    }

    @Override
    public void deleteItem(NavyDSItem item) {
        crudDatasource.deleteItem(item, this);
    }

    @Override
    public void deleteItems(List<NavyDSItem> items) {
        crudDatasource.deleteItems(items, this);
    }

    @Override
    public void addForm() {
        view.showAdd();
    }

    @Override
    public void editForm(NavyDSItem item, int position) {
        view.showEdit(item, position);
    }

    @Override
    public void detail(NavyDSItem item, int position) {
        view.showDetail(item, position);
    }

    @Override
    public void onSuccess(NavyDSItem item) {
                view.showMessage(R.string.items_deleted);
        view.refresh();
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic);
    }

}

