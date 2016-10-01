
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

public interface AirForceDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/airForceDS")
	void queryAirForceDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<AirForceDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/airForceDS/{id}")
	void getAirForceDSItemById(@Path("id") String id, Callback<AirForceDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/airForceDS/{id}")
  void deleteAirForceDSItemById(@Path("id") String id, Callback<AirForceDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/airForceDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<AirForceDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/airForceDS")
  void createAirForceDSItem(@Body AirForceDSItem item, Callback<AirForceDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/airForceDS/{id}")
  void updateAirForceDSItem(@Path("id") String id, @Body AirForceDSItem item, Callback<AirForceDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/airForceDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}

