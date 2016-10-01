

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
 * "ArmyDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class ArmyDS extends AppNowDatasource<ArmyDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private ArmyDSService service;

    public static ArmyDS getInstance(SearchOptions searchOptions){
        return new ArmyDS(searchOptions);
    }

    private ArmyDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = ArmyDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<ArmyDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<ArmyDSItem>>() {
                @Override
                public void onSuccess(List<ArmyDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new ArmyDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getArmyDSItemById(id, new Callback<ArmyDSItem>() {
                @Override
                public void success(ArmyDSItem result, Response response) {
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
    public void getItems(final Listener<List<ArmyDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<ArmyDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryArmyDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<ArmyDSItem>>() {
            @Override
            public void success(List<ArmyDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"post", "qualification", "role", "selectionprocess", "websiteForApplication", "furtherpromotions", "examToBeWritten"};
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
    public void create(ArmyDSItem item, Listener<ArmyDSItem> listener) {
                          service.getServiceProxy().createArmyDSItem(item, callbackFor(listener));
          }

    private Callback<ArmyDSItem> callbackFor(final Listener<ArmyDSItem> listener) {
      return new Callback<ArmyDSItem>() {
          @Override
          public void success(ArmyDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(ArmyDSItem item, Listener<ArmyDSItem> listener) {
                          service.getServiceProxy().updateArmyDSItem(item.getIdentifiableId(), item, callbackFor(listener));
          }

    @Override
    public void deleteItem(ArmyDSItem item, final Listener<ArmyDSItem> listener) {
                service.getServiceProxy().deleteArmyDSItemById(item.getIdentifiableId(), new Callback<ArmyDSItem>() {
            @Override
            public void success(ArmyDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<ArmyDSItem> items, final Listener<ArmyDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<ArmyDSItem>>() {
            @Override
            public void success(List<ArmyDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<ArmyDSItem> items){
        List<String> ids = new ArrayList<>();
        for(ArmyDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

