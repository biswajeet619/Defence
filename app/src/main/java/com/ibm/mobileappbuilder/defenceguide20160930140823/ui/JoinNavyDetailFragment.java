
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.OpenUriAction;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.NavyDS;

public class JoinNavyDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<NavyDSItem> implements ShareBehavior.ShareListener  {

    private Datasource<NavyDSItem> datasource;
    public static JoinNavyDetailFragment newInstance(Bundle args){
        JoinNavyDetailFragment fr = new JoinNavyDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public JoinNavyDetailFragment(){
        super();
    }

    @Override
    public Datasource<NavyDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = NavyDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.joinnavydetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final NavyDSItem item, View view) {
        if (item.post != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.post);
            
        }
        if (item.qualification != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.qualification);
            
        }
        if (item.percentageRequired != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(StringUtils.doubleToString(item.percentageRequired, true));
            
        }
        if (item.selectionProcess != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.selectionProcess);
            
        }
        if (item.role != null){
            
            TextView view4 = (TextView) view.findViewById(R.id.view4);
            view4.setText(item.role);
            
        }
        if (item.websiteForApplication != null){
            
            TextView view5 = (TextView) view.findViewById(R.id.view5);
            view5.setText(item.websiteForApplication);
            bindAction(view5, new OpenUriAction(
            new ActivityIntentLauncher()
            , item.websiteForApplication));
        }
        if (item.furtherpromotions != null){
            
            TextView view6 = (TextView) view.findViewById(R.id.view6);
            view6.setText(item.furtherpromotions);
            
        }
        if (item.examsToBeWritten != null){
            
            TextView view7 = (TextView) view.findViewById(R.id.view7);
            view7.setText(item.examsToBeWritten);
            
        }
    }

    @Override
    protected void onShow(NavyDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        NavyDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.post != null ? item.post : "" ) + "\n" +
                    (item.qualification != null ? item.qualification : "" ) + "\n" +
                    (item.percentageRequired != null ? StringUtils.doubleToString(item.percentageRequired, true) : "" ) + "\n" +
                    (item.selectionProcess != null ? item.selectionProcess : "" ) + "\n" +
                    (item.role != null ? item.role : "" ) + "\n" +
                    (item.websiteForApplication != null ? item.websiteForApplication : "" ) + "\n" +
                    (item.furtherpromotions != null ? item.furtherpromotions : "" ) + "\n" +
                    (item.examsToBeWritten != null ? item.examsToBeWritten : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

