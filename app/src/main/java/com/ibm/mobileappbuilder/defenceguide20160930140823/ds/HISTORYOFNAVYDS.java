

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
 * "HISTORYOFNAVYDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class HISTORYOFNAVYDS extends AppNowDatasource<HISTORYOFNAVYDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private HISTORYOFNAVYDSService service;

    public static HISTORYOFNAVYDS getInstance(SearchOptions searchOptions){
        return new HISTORYOFNAVYDS(searchOptions);
    }

    private HISTORYOFNAVYDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = HISTORYOFNAVYDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<HISTORYOFNAVYDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<HISTORYOFNAVYDSItem>>() {
                @Override
                public void onSuccess(List<HISTORYOFNAVYDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new HISTORYOFNAVYDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getHISTORYOFNAVYDSItemById(id, new Callback<HISTORYOFNAVYDSItem>() {
                @Override
                public void success(HISTORYOFNAVYDSItem result, Response response) {
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
    public void getItems(final Listener<List<HISTORYOFNAVYDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<HISTORYOFNAVYDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryHISTORYOFNAVYDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<HISTORYOFNAVYDSItem>>() {
            @Override
            public void success(List<HISTORYOFNAVYDSItem> result, Response response) {
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
    public void create(HISTORYOFNAVYDSItem item, Listener<HISTORYOFNAVYDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().createHISTORYOFNAVYDSItem(item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createHISTORYOFNAVYDSItem(item, callbackFor(listener));
        
    }

    private Callback<HISTORYOFNAVYDSItem> callbackFor(final Listener<HISTORYOFNAVYDSItem> listener) {
      return new Callback<HISTORYOFNAVYDSItem>() {
          @Override
          public void success(HISTORYOFNAVYDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(HISTORYOFNAVYDSItem item, Listener<HISTORYOFNAVYDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().updateHISTORYOFNAVYDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateHISTORYOFNAVYDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(HISTORYOFNAVYDSItem item, final Listener<HISTORYOFNAVYDSItem> listener) {
                service.getServiceProxy().deleteHISTORYOFNAVYDSItemById(item.getIdentifiableId(), new Callback<HISTORYOFNAVYDSItem>() {
            @Override
            public void success(HISTORYOFNAVYDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<HISTORYOFNAVYDSItem> items, final Listener<HISTORYOFNAVYDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<HISTORYOFNAVYDSItem>>() {
            @Override
            public void success(List<HISTORYOFNAVYDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<HISTORYOFNAVYDSItem> items){
        List<String> ids = new ArrayList<>();
        for(HISTORYOFNAVYDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

