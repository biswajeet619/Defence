
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
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.HISTORYOFAIRFORCEDetailPresenter;
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
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.HISTORYOFAIRFORCEDS;

public class HISTORYOFAIRFORCEDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<HISTORYOFAIRFORCEDSItem> implements ShareBehavior.ShareListener  {

    private CrudDatasource<HISTORYOFAIRFORCEDSItem> datasource;
    public static HISTORYOFAIRFORCEDetailFragment newInstance(Bundle args){
        HISTORYOFAIRFORCEDetailFragment fr = new HISTORYOFAIRFORCEDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public HISTORYOFAIRFORCEDetailFragment(){
        super();
    }

    @Override
    public Datasource<HISTORYOFAIRFORCEDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = HISTORYOFAIRFORCEDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        // the presenter for this view
        setPresenter(new HISTORYOFAIRFORCEDetailPresenter(
                (CrudDatasource) getDatasource(),
                this));
        // Edit button
        addBehavior(new FabBehaviour(this, R.drawable.ic_edit_white, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DetailCrudPresenter<HISTORYOFAIRFORCEDSItem>) getPresenter()).editForm(getItem());
            }
        }));
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.historyofairforcedetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final HISTORYOFAIRFORCEDSItem item, View view) {
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
    protected void onShow(HISTORYOFAIRFORCEDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }

    @Override
    public void navigateToEditForm() {
        Bundle args = new Bundle();

        args.putInt(Constants.ITEMPOS, 0);
        args.putParcelable(Constants.CONTENT, getItem());
        args.putInt(Constants.MODE, Constants.MODE_EDIT);

        Intent intent = new Intent(getActivity(), HISTORYOFAIRFORCEDSItemFormActivity.class);
        intent.putExtras(args);
        startActivityForResult(intent, Constants.MODE_EDIT);
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
            ((DetailCrudPresenter<HISTORYOFAIRFORCEDSItem>) getPresenter()).deleteItem(getItem());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onShare() {
        HISTORYOFAIRFORCEDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.history != null ? item.history : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

