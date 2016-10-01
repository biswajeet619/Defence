
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

public interface HISTORYOFNAVYDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS")
	void queryHISTORYOFNAVYDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<HISTORYOFNAVYDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS/{id}")
	void getHISTORYOFNAVYDSItemById(@Path("id") String id, Callback<HISTORYOFNAVYDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS/{id}")
  void deleteHISTORYOFNAVYDSItemById(@Path("id") String id, Callback<HISTORYOFNAVYDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<HISTORYOFNAVYDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS")
  void createHISTORYOFNAVYDSItem(@Body HISTORYOFNAVYDSItem item, Callback<HISTORYOFNAVYDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS/{id}")
  void updateHISTORYOFNAVYDSItem(@Path("id") String id, @Body HISTORYOFNAVYDSItem item, Callback<HISTORYOFNAVYDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS")
    void createHISTORYOFNAVYDSItem(
        @Part("data") HISTORYOFNAVYDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFNAVYDSItem> cb);
    
    @Multipart
    @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFNAVYDS/{id}")
    void updateHISTORYOFNAVYDSItem(
        @Path("id") String id,
        @Part("data") HISTORYOFNAVYDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFNAVYDSItem> cb);
}

