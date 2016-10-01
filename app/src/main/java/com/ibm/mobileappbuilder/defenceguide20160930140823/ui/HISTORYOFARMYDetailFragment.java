
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.HISTORYOFARMYDetailPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.behaviors.FabBehaviour;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.Constants;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import java.net.URL;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFARMYDS;

public class HISTORYOFARMYDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<HISTORYOFARMYDSItem> implements ShareBehavior.ShareListener  {

    private CrudDatasource<HISTORYOFARMYDSItem> datasource;
    public static HISTORYOFARMYDetailFragment newInstance(Bundle args){
        HISTORYOFARMYDetailFragment fr = new HISTORYOFARMYDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public HISTORYOFARMYDetailFragment(){
        super();
    }

    @Override
    public Datasource<HISTORYOFARMYDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = HISTORYOFARMYDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        // the presenter for this view
        setPresenter(new HISTORYOFARMYDetailPresenter(
                (CrudDatasource) getDatasource(),
                this));
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.historyofarmydetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final HISTORYOFARMYDSItem item, View view) {
        if (item.history != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.history);
            
        }
        
        ImageView view1 = (ImageView) view.findViewById(R.id.view1);
        URL view1Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.picture);
        if(view1Media != null){
          ImageLoader imageLoader = new PicassoImageLoader(view1.getContext());
          imageLoader.load(imageLoaderRequest()
                                   .withPath(view1Media.toExternalForm())
                                   .withTargetView(view1)
                                   .fit()
                                   .build()
                    );
        	
        } else {
          view1.setImageDrawable(null);
        }
    }

    @Override
    protected void onShow(HISTORYOFARMYDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.delete_menu, menu);

        MenuItem item = menu.findItem(R.id.action_delete);
        ColorUtils.tintIcon(item, R.color.textBarColor, getActivity());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_delete){
            ((DetailCrudPresenter<HISTORYOFARMYDSItem>) getPresenter()).deleteItem(getItem());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onShare() {
        HISTORYOFARMYDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.history != null ? item.history : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

