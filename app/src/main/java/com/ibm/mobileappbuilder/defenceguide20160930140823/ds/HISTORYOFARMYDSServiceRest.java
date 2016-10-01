
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
import retrofit.mime.TypedByteArray;
import retrofit.http.Part;
import retrofit.http.Multipart;

public interface HISTORYOFARMYDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS")
	void queryHISTORYOFARMYDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<HISTORYOFARMYDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS/{id}")
	void getHISTORYOFARMYDSItemById(@Path("id") String id, Callback<HISTORYOFARMYDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS/{id}")
  void deleteHISTORYOFARMYDSItemById(@Path("id") String id, Callback<HISTORYOFARMYDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<HISTORYOFARMYDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS")
  void createHISTORYOFARMYDSItem(@Body HISTORYOFARMYDSItem item, Callback<HISTORYOFARMYDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS/{id}")
  void updateHISTORYOFARMYDSItem(@Path("id") String id, @Body HISTORYOFARMYDSItem item, Callback<HISTORYOFARMYDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS")
    void createHISTORYOFARMYDSItem(
        @Part("data") HISTORYOFARMYDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFARMYDSItem> cb);
    
    @Multipart
    @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFARMYDS/{id}")
    void updateHISTORYOFARMYDSItem(
        @Path("id") String id,
        @Part("data") HISTORYOFARMYDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFARMYDSItem> cb);
}

