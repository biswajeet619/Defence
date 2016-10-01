
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;

public interface NavyDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/navyDS")
	void queryNavyDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<NavyDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/navyDS/{id}")
	void getNavyDSItemById(@Path("id") String id, Callback<NavyDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/navyDS/{id}")
  void deleteNavyDSItemById(@Path("id") String id, Callback<NavyDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/navyDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<NavyDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/navyDS")
  void createNavyDSItem(@Body NavyDSItem item, Callback<NavyDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/navyDS/{id}")
  void updateNavyDSItem(@Path("id") String id, @Body NavyDSItem item, Callback<NavyDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/navyDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}

