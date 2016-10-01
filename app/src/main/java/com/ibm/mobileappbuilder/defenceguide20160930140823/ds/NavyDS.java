

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
 * "NavyDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class NavyDS extends AppNowDatasource<NavyDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private NavyDSService service;

    public static NavyDS getInstance(SearchOptions searchOptions){
        return new NavyDS(searchOptions);
    }

    private NavyDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = NavyDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<NavyDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<NavyDSItem>>() {
                @Override
                public void onSuccess(List<NavyDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new NavyDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getNavyDSItemById(id, new Callback<NavyDSItem>() {
                @Override
                public void success(NavyDSItem result, Response response) {
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
    public void getItems(final Listener<List<NavyDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<NavyDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryNavyDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<NavyDSItem>>() {
            @Override
            public void success(List<NavyDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"post", "qualification", "selectionProcess", "role", "websiteForApplication", "furtherpromotions", "examsToBeWritten"};
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
    public void create(NavyDSItem item, Listener<NavyDSItem> listener) {
                          service.getServiceProxy().createNavyDSItem(item, callbackFor(listener));
          }

    private Callback<NavyDSItem> callbackFor(final Listener<NavyDSItem> listener) {
      return new Callback<NavyDSItem>() {
          @Override
          public void success(NavyDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(NavyDSItem item, Listener<NavyDSItem> listener) {
                          service.getServiceProxy().updateNavyDSItem(item.getIdentifiableId(), item, callbackFor(listener));
          }

    @Override
    public void deleteItem(NavyDSItem item, final Listener<NavyDSItem> listener) {
                service.getServiceProxy().deleteNavyDSItemById(item.getIdentifiableId(), new Callback<NavyDSItem>() {
            @Override
            public void success(NavyDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<NavyDSItem> items, final Listener<NavyDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<NavyDSItem>>() {
            @Override
            public void success(List<NavyDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<NavyDSItem> items){
        List<String> ids = new ArrayList<>();
        for(NavyDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

