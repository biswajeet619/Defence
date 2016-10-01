
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

public interface ArmyDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/armyDS")
	void queryArmyDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<ArmyDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/armyDS/{id}")
	void getArmyDSItemById(@Path("id") String id, Callback<ArmyDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/armyDS/{id}")
  void deleteArmyDSItemById(@Path("id") String id, Callback<ArmyDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/armyDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<ArmyDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/armyDS")
  void createArmyDSItem(@Body ArmyDSItem item, Callback<ArmyDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/armyDS/{id}")
  void updateArmyDSItem(@Path("id") String id, @Body ArmyDSItem item, Callback<ArmyDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/armyDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}

