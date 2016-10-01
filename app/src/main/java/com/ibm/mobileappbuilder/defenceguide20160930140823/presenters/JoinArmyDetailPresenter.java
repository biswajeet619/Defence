
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.ArmyDSItem;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.mvp.view.DetailView;

public class JoinArmyDetailPresenter extends BasePresenter implements DetailCrudPresenter<ArmyDSItem>,
      Datasource.Listener<ArmyDSItem> {

    private final CrudDatasource<ArmyDSItem> datasource;
    private final DetailView view;

    public JoinArmyDetailPresenter(CrudDatasource<ArmyDSItem> datasource, DetailView view){
        this.datasource = datasource;
        this.view = view;
    }

    @Override
    public void deleteItem(ArmyDSItem item) {
        datasource.deleteItem(item, this);
    }

    @Override
    public void editForm(ArmyDSItem item) {
        view.navigateToEditForm();
    }

    @Override
    public void onSuccess(ArmyDSItem item) {
                view.showMessage(R.string.item_deleted, true);
        view.close(true);
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic, true);
    }
}

