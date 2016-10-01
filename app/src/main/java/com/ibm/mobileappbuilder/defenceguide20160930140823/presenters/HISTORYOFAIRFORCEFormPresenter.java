
package com.ibm.mobileappbuilder.defenceguide20160930140823.presenters;

import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BaseFormPresenter;
import ibmmobileappbuilder.mvp.view.FormView;

public class HISTORYOFAIRFORCEFormPresenter extends BaseFormPresenter<HISTORYOFAIRFORCEDSItem> {

    private final CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource;

    public HISTORYOFAIRFORCEFormPresenter(CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource, FormView<HISTORYOFAIRFORCEDSItem> view){
        super(view);
        this.datasource = datasource;
    }

    @Override
    public void deleteItem(HISTORYOFAIRFORCEDSItem item) {
        datasource.deleteItem(item, new OnItemDeletedListener());
    }

    @Override
    public void save(HISTORYOFAIRFORCEDSItem item) {
        // validate
        if (validate(item)){
            datasource.updateItem(item, new OnItemUpdatedListener());
        } else {
            view.showMessage(R.string.correct_errors, false);
        }
    }

    @Override
    public void create(HISTORYOFAIRFORCEDSItem item) {
        // validate
        if (validate(item)){
            datasource.create(item, new OnItemCreatedListener());
        } else {
            view.showMessage(R.string.correct_errors, false);
        }
    }

    private class OnItemDeletedListener extends ShowingErrorOnFailureListener {
        @Override
        public void onSuccess(HISTORYOFAIRFORCEDSItem  item) {
                        view.showMessage(R.string.item_deleted, true);
            view.close(true);
        }
    }

    private class OnItemUpdatedListener extends ShowingErrorOnFailureListener {
        @Override
        public void onSuccess(HISTORYOFAIRFORCEDSItem item) {
                        view.setItem(item);
            view.showMessage(R.string.item_updated, true);
            view.close(true);
        }
    }

    private class OnItemCreatedListener extends ShowingErrorOnFailureListener {
        @Override
        public void onSuccess(HISTORYOFAIRFORCEDSItem item) {
                        view.setItem(item);
            view.showMessage(R.string.item_created, true);
            view.close(true);
        }
    }

    private abstract class ShowingErrorOnFailureListener implements Datasource.Listener<HISTORYOFAIRFORCEDSItem > {
        @Override
        public void onFailure(Exception e) {
            view.showMessage(R.string.error_data_generic, true);
        }
    }

}

