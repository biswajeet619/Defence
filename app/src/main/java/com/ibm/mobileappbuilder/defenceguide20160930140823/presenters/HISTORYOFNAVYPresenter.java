
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.ListCrudPresenter;
import ibmmobileappbuilder.mvp.view.CrudListView;

public class HISTORYOFNAVYPresenter extends BasePresenter implements ListCrudPresenter<HISTORYOFNAVYDSItem>,
      Datasource.Listener<HISTORYOFNAVYDSItem>{

    private final CrudDatasource<HISTORYOFNAVYDSItem> crudDatasource;
    private final CrudListView<HISTORYOFNAVYDSItem> view;

    public HISTORYOFNAVYPresenter(CrudDatasource<HISTORYOFNAVYDSItem> crudDatasource,
                                         CrudListView<HISTORYOFNAVYDSItem> view) {
       this.crudDatasource = crudDatasource;
       this.view = view;
    }

    @Override
    public void deleteItem(HISTORYOFNAVYDSItem item) {
        crudDatasource.deleteItem(item, this);
    }

    @Override
    public void deleteItems(List<HISTORYOFNAVYDSItem> items) {
        crudDatasource.deleteItems(items, this);
    }

    @Override
    public void addForm() {
        view.showAdd();
    }

    @Override
    public void editForm(HISTORYOFNAVYDSItem item, int position) {
        view.showEdit(item, position);
    }

    @Override
    public void detail(HISTORYOFNAVYDSItem item, int position) {
        view.showDetail(item, position);
    }

    @Override
    public void onSuccess(HISTORYOFNAVYDSItem item) {
                view.showMessage(R.string.items_deleted);
        view.refresh();
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic);
    }

}

