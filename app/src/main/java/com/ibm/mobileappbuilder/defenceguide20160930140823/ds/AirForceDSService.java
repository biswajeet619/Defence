
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "AirForceDSService" REST Service implementation
 */
public class AirForceDSService extends RestService<AirForceDSServiceRest>{

    public static AirForceDSService getInstance(){
          return new AirForceDSService();
    }

    private AirForceDSService() {
        super(AirForceDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "bT9IWAGw";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ee79e011cb3e03009e924d",
                path,
                "apikey=bT9IWAGw");
    }

}

