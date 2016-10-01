

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
 * "HISTORYOFARMYDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class HISTORYOFARMYDS extends AppNowDatasource<HISTORYOFARMYDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private HISTORYOFARMYDSService service;

    public static HISTORYOFARMYDS getInstance(SearchOptions searchOptions){
        return new HISTORYOFARMYDS(searchOptions);
    }

    private HISTORYOFARMYDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = HISTORYOFARMYDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<HISTORYOFARMYDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<HISTORYOFARMYDSItem>>() {
                @Override
                public void onSuccess(List<HISTORYOFARMYDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new HISTORYOFARMYDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getHISTORYOFARMYDSItemById(id, new Callback<HISTORYOFARMYDSItem>() {
                @Override
                public void success(HISTORYOFARMYDSItem result, Response response) {
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
    public void getItems(final Listener<List<HISTORYOFARMYDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<HISTORYOFARMYDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryHISTORYOFARMYDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<HISTORYOFARMYDSItem>>() {
            @Override
            public void success(List<HISTORYOFARMYDSItem> result, Response response) {
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
    public void create(HISTORYOFARMYDSItem item, Listener<HISTORYOFARMYDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().createHISTORYOFARMYDSItem(item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createHISTORYOFARMYDSItem(item, callbackFor(listener));
        
    }

    private Callback<HISTORYOFARMYDSItem> callbackFor(final Listener<HISTORYOFARMYDSItem> listener) {
      return new Callback<HISTORYOFARMYDSItem>() {
          @Override
          public void success(HISTORYOFARMYDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(HISTORYOFARMYDSItem item, Listener<HISTORYOFARMYDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().updateHISTORYOFARMYDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateHISTORYOFARMYDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(HISTORYOFARMYDSItem item, final Listener<HISTORYOFARMYDSItem> listener) {
                service.getServiceProxy().deleteHISTORYOFARMYDSItemById(item.getIdentifiableId(), new Callback<HISTORYOFARMYDSItem>() {
            @Override
            public void success(HISTORYOFARMYDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<HISTORYOFARMYDSItem> items, final Listener<HISTORYOFARMYDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<HISTORYOFARMYDSItem>>() {
            @Override
            public void success(List<HISTORYOFARMYDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<HISTORYOFARMYDSItem> items){
        List<String> ids = new ArrayList<>();
        for(HISTORYOFARMYDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

