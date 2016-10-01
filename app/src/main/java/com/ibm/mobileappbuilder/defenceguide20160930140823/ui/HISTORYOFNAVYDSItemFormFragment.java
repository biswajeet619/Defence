
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.HISTORYOFNAVYFormPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ui.FormFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.views.ImagePicker;
import ibmmobileappbuilder.views.TextWatcherAdapter;
import java.io.IOException;
import java.io.File;

import static android.net.Uri.fromFile;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFNAVYDS;

public class HISTORYOFNAVYDSItemFormFragment extends FormFragment<HISTORYOFNAVYDSItem> {

    private CrudDatasource<HISTORYOFNAVYDSItem> datasource;

    public static HISTORYOFNAVYDSItemFormFragment newInstance(Bundle args){
        HISTORYOFNAVYDSItemFormFragment fr = new HISTORYOFNAVYDSItemFormFragment();
        fr.setArguments(args);

        return fr;
    }

    public HISTORYOFNAVYDSItemFormFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // the presenter for this view
        setPresenter(new HISTORYOFNAVYFormPresenter(
                (CrudDatasource) getDatasource(),
                this));

            }

    @Override
    protected HISTORYOFNAVYDSItem newItem() {
        return new HISTORYOFNAVYDSItem();
    }

    private HISTORYOFNAVYDSService getRestService(){
        return HISTORYOFNAVYDSService.getInstance();
    }

    @Override
    protected int getLayout() {
        return R.layout.historyofnavy_form;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final HISTORYOFNAVYDSItem item, View view) {
        
        bindString(R.id.historyofnavyds_history, item.history, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.history = s.toString();
            }
        });
        
        
        bindImage(R.id.historyofnavyds_picture,
            item.picture != null ?
                getRestService().getImageUrl(item.picture) : null,
            0,
            new ImagePicker.Callback(){
                @Override
                public void imageRemoved(){
                    item.picture = null;
                    item.pictureUri = null;
                    ((ImagePicker) getView().findViewById(R.id.historyofnavyds_picture)).clear();
                }
            }
        );
        
    }

    @Override
    public Datasource<HISTORYOFNAVYDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = HISTORYOFNAVYDS.getInstance(new SearchOptions());
        return datasource;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            ImagePicker picker = null;
            Uri imageUri = null;
            HISTORYOFNAVYDSItem item = getItem();

            if((requestCode & ImagePicker.GALLERY_REQUEST_CODE) == ImagePicker.GALLERY_REQUEST_CODE) {
              imageUri = data.getData();
              switch (requestCode - ImagePicker.GALLERY_REQUEST_CODE) {
                        
                        case 0:   // picture field
                            item.pictureUri = imageUri;
                            item.picture = "cid:picture";
                            picker = (ImagePicker) getView().findViewById(R.id.historyofnavyds_picture);
                            break;
                        
                default:
                  return;
              }

              picker.setImageUri(imageUri);
            } else if((requestCode & ImagePicker.CAPTURE_REQUEST_CODE) == ImagePicker.CAPTURE_REQUEST_CODE) {
				      switch (requestCode - ImagePicker.CAPTURE_REQUEST_CODE) {
                        
                        case 0:   // picture field
                            picker = (ImagePicker) getView().findViewById(R.id.historyofnavyds_picture);
                            imageUri = fromFile(picker.getImageFile());
                        		item.pictureUri = imageUri;
                            item.picture = "cid:picture";
                            break;
                        
                default:
                  return;
              }
              picker.setImageUri(imageUri);
            }
        }
    }
}

