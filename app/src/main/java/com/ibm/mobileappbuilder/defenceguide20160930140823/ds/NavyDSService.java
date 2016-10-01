
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "NavyDSService" REST Service implementation
 */
public class NavyDSService extends RestService<NavyDSServiceRest>{

    public static NavyDSService getInstance(){
          return new NavyDSService();
    }

    private NavyDSService() {
        super(NavyDSServiceRest.class);

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

