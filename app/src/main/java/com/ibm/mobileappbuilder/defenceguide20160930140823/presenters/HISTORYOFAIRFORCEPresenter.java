
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.ListCrudPresenter;
import ibmmobileappbuilder.mvp.view.CrudListView;

public class HISTORYOFAIRFORCEPresenter extends BasePresenter implements ListCrudPresenter<HISTORYOFAIRFORCEDSItem>,
      Datasource.Listener<HISTORYOFAIRFORCEDSItem>{

    private final CrudDatasource<HISTORYOFAIRFORCEDSItem> crudDatasource;
    private final CrudListView<HISTORYOFAIRFORCEDSItem> view;

    public HISTORYOFAIRFORCEPresenter(CrudDatasource<HISTORYOFAIRFORCEDSItem> crudDatasource,
                                         CrudListView<HISTORYOFAIRFORCEDSItem> view) {
       this.crudDatasource = crudDatasource;
       this.view = view;
    }

    @Override
    public void deleteItem(HISTORYOFAIRFORCEDSItem item) {
        crudDatasource.deleteItem(item, this);
    }

    @Override
    public void deleteItems(List<HISTORYOFAIRFORCEDSItem> items) {
        crudDatasource.deleteItems(items, this);
    }

    @Override
    public void addForm() {
        view.showAdd();
    }

    @Override
    public void editForm(HISTORYOFAIRFORCEDSItem item, int position) {
        view.showEdit(item, position);
    }

    @Override
    public void detail(HISTORYOFAIRFORCEDSItem item, int position) {
        view.showDetail(item, position);
    }

    @Override
    public void onSuccess(HISTORYOFAIRFORCEDSItem item) {
                view.showMessage(R.string.items_deleted);
        view.refresh();
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic);
    }

}

