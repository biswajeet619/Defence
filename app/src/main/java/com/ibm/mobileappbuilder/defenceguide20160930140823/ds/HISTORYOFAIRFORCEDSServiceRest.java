
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

public interface HISTORYOFAIRFORCEDSServiceRest{

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS")
	void queryHISTORYOFAIRFORCEDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<HISTORYOFAIRFORCEDSItem>> cb);

	@GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS/{id}")
	void getHISTORYOFAIRFORCEDSItemById(@Path("id") String id, Callback<HISTORYOFAIRFORCEDSItem> cb);

	@DELETE("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS/{id}")
  void deleteHISTORYOFAIRFORCEDSItemById(@Path("id") String id, Callback<HISTORYOFAIRFORCEDSItem> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<HISTORYOFAIRFORCEDSItem>> cb);

  @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS")
  void createHISTORYOFAIRFORCEDSItem(@Body HISTORYOFAIRFORCEDSItem item, Callback<HISTORYOFAIRFORCEDSItem> cb);

  @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS/{id}")
  void updateHISTORYOFAIRFORCEDSItem(@Path("id") String id, @Body HISTORYOFAIRFORCEDSItem item, Callback<HISTORYOFAIRFORCEDSItem> cb);

  @GET("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS")
    void createHISTORYOFAIRFORCEDSItem(
        @Part("data") HISTORYOFAIRFORCEDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFAIRFORCEDSItem> cb);
    
    @Multipart
    @PUT("/app/57ee79e011cb3e03009e924d/r/hISTORYOFAIRFORCEDS/{id}")
    void updateHISTORYOFAIRFORCEDSItem(
        @Path("id") String id,
        @Part("data") HISTORYOFAIRFORCEDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<HISTORYOFAIRFORCEDSItem> cb);
}

