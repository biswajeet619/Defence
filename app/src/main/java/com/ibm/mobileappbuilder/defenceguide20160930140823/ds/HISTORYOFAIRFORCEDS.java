

package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "HISTORYOFAIRFORCEDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class HISTORYOFAIRFORCEDS extends AppNowDatasource<HISTORYOFAIRFORCEDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private HISTORYOFAIRFORCEDSService service;

    public static HISTORYOFAIRFORCEDS getInstance(SearchOptions searchOptions){
        return new HISTORYOFAIRFORCEDS(searchOptions);
    }

    private HISTORYOFAIRFORCEDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = HISTORYOFAIRFORCEDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<HISTORYOFAIRFORCEDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<HISTORYOFAIRFORCEDSItem>>() {
                @Override
                public void onSuccess(List<HISTORYOFAIRFORCEDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new HISTORYOFAIRFORCEDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getHISTORYOFAIRFORCEDSItemById(id, new Callback<HISTORYOFAIRFORCEDSItem>() {
                @Override
                public void success(HISTORYOFAIRFORCEDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<HISTORYOFAIRFORCEDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<HISTORYOFAIRFORCEDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryHISTORYOFAIRFORCEDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<HISTORYOFAIRFORCEDSItem>>() {
            @Override
            public void success(List<HISTORYOFAIRFORCEDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"history"};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(HISTORYOFAIRFORCEDSItem item, Listener<HISTORYOFAIRFORCEDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().createHISTORYOFAIRFORCEDSItem(item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createHISTORYOFAIRFORCEDSItem(item, callbackFor(listener));
        
    }

    private Callback<HISTORYOFAIRFORCEDSItem> callbackFor(final Listener<HISTORYOFAIRFORCEDSItem> listener) {
      return new Callback<HISTORYOFAIRFORCEDSItem>() {
          @Override
          public void success(HISTORYOFAIRFORCEDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(HISTORYOFAIRFORCEDSItem item, Listener<HISTORYOFAIRFORCEDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().updateHISTORYOFAIRFORCEDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateHISTORYOFAIRFORCEDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(HISTORYOFAIRFORCEDSItem item, final Listener<HISTORYOFAIRFORCEDSItem> listener) {
                service.getServiceProxy().deleteHISTORYOFAIRFORCEDSItemById(item.getIdentifiableId(), new Callback<HISTORYOFAIRFORCEDSItem>() {
            @Override
            public void success(HISTORYOFAIRFORCEDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<HISTORYOFAIRFORCEDSItem> items, final Listener<HISTORYOFAIRFORCEDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<HISTORYOFAIRFORCEDSItem>>() {
            @Override
            public void success(List<HISTORYOFAIRFORCEDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<HISTORYOFAIRFORCEDSItem> items){
        List<String> ids = new ArrayList<>();
        for(HISTORYOFAIRFORCEDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

