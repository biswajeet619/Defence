
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "HISTORYOFAIRFORCEDSService" REST Service implementation
 */
public class HISTORYOFAIRFORCEDSService extends RestService<HISTORYOFAIRFORCEDSServiceRest>{

    public static HISTORYOFAIRFORCEDSService getInstance(){
          return new HISTORYOFAIRFORCEDSService();
    }

    private HISTORYOFAIRFORCEDSService() {
        super(HISTORYOFAIRFORCEDSServiceRest.class);

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

