

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
 * "AirForceDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class AirForceDS extends AppNowDatasource<AirForceDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private AirForceDSService service;

    public static AirForceDS getInstance(SearchOptions searchOptions){
        return new AirForceDS(searchOptions);
    }

    private AirForceDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = AirForceDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<AirForceDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<AirForceDSItem>>() {
                @Override
                public void onSuccess(List<AirForceDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new AirForceDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getAirForceDSItemById(id, new Callback<AirForceDSItem>() {
                @Override
                public void success(AirForceDSItem result, Response response) {
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
    public void getItems(final Listener<List<AirForceDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<AirForceDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryAirForceDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<AirForceDSItem>>() {
            @Override
            public void success(List<AirForceDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"post", "qualification", "examstobewritten", "role", "selectionprocess", "furtherpromotions", "websiteForApplication"};
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
    public void create(AirForceDSItem item, Listener<AirForceDSItem> listener) {
                          service.getServiceProxy().createAirForceDSItem(item, callbackFor(listener));
          }

    private Callback<AirForceDSItem> callbackFor(final Listener<AirForceDSItem> listener) {
      return new Callback<AirForceDSItem>() {
          @Override
          public void success(AirForceDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(AirForceDSItem item, Listener<AirForceDSItem> listener) {
                          service.getServiceProxy().updateAirForceDSItem(item.getIdentifiableId(), item, callbackFor(listener));
          }

    @Override
    public void deleteItem(AirForceDSItem item, final Listener<AirForceDSItem> listener) {
                service.getServiceProxy().deleteAirForceDSItemById(item.getIdentifiableId(), new Callback<AirForceDSItem>() {
            @Override
            public void success(AirForceDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<AirForceDSItem> items, final Listener<AirForceDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<AirForceDSItem>>() {
            @Override
            public void success(List<AirForceDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<AirForceDSItem> items){
        List<String> ids = new ArrayList<>();
        for(AirForceDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

