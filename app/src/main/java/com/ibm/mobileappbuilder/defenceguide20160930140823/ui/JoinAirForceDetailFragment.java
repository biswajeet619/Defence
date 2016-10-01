
package com.ibm.mobileappbuilder.defenceguide20160930140823.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSService;
import com.ibm.mobileappbuilder.defenceguide20160930140823.presenters.JoinAirForceDetailPresenter;
import com.ibm.mobileappbuilder.defenceguide20160930140823.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.OpenUriAction;
import ibmmobileappbuilder.behaviors.FabBehaviour;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.mvp.presenter.DetailCrudPresenter;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.Constants;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDSItem;
import com.ibm.mobileappbuilder.defenceguide20160930140823.ds.AirForceDS;

public class JoinAirForceDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<AirForceDSItem> implements ShareBehavior.ShareListener  {

    private CrudDatasource<AirForceDSItem> datasource;
    public static JoinAirForceDetailFragment newInstance(Bundle args){
        JoinAirForceDetailFragment fr = new JoinAirForceDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public JoinAirForceDetailFragment(){
        super();
    }

    @Override
    public Datasource<AirForceDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = AirForceDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        // the presenter for this view
        setPresenter(new JoinAirForceDetailPresenter(
                (CrudDatasource) getDatasource(),
                this));
        // Edit button
        addBehavior(new FabBehaviour(this, R.drawable.ic_edit_white, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DetailCrudPresenter<AirForceDSItem>) getPresenter()).editForm(getItem());
            }
        }));
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.joinairforcedetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final AirForceDSItem item, View view) {
        if (item.qualification != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.qualification);
            
        }
        if (item.examstobewritten != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.examstobewritten);
            
        }
        if (item.percentagerequired != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(StringUtils.doubleToString(item.percentagerequired, true));
            
        }
        if (item.role != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.role);
            
        }
        if (item.selectionprocess != null){
            
            TextView view4 = (TextView) view.findViewById(R.id.view4);
            view4.setText(item.selectionprocess);
            
        }
        if (item.furtherpromotions != null){
            
            TextView view5 = (TextView) view.findViewById(R.id.view5);
            view5.setText(item.furtherpromotions);
            
        }
        if (item.websiteForApplication != null){
            
            TextView view6 = (TextView) view.findViewById(R.id.view6);
            view6.setText(item.websiteForApplication);
            bindAction(view6, new OpenUriAction(
            new ActivityIntentLauncher()
            , item.websiteForApplication));
        }
        if (item.askExpert != null){
            
            TextView view7 = (TextView) view.findViewById(R.id.view7);
            view7.setText(item.askExpert.toString());
            
        }
    }

    @Override
    protected void onShow(AirForceDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(item.post);
    }

    @Override
    public void navigateToEditForm() {
        Bundle args = new Bundle();

        args.putInt(Constants.ITEMPOS, 0);
        args.putParcelable(Constants.CONTENT, getItem());
        args.putInt(Constants.MODE, Constants.MODE_EDIT);

        Intent intent = new Intent(getActivity(), AirForceDSItemFormActivity.class);
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
            ((DetailCrudPresenter<AirForceDSItem>) getPresenter()).deleteItem(getItem());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onShare() {
        AirForceDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.qualification != null ? item.qualification : "" ) + "\n" +
                    (item.examstobewritten != null ? item.examstobewritten : "" ) + "\n" +
                    (item.percentagerequired != null ? StringUtils.doubleToString(item.percentagerequired, true) : "" ) + "\n" +
                    (item.role != null ? item.role : "" ) + "\n" +
                    (item.selectionprocess != null ? item.selectionprocess : "" ) + "\n" +
                    (item.furtherpromotions != null ? item.furtherpromotions : "" ) + "\n" +
                    (item.websiteForApplication != null ? item.websiteForApplication : "" ) + "\n" +
                    (item.askExpert != null ? item.askExpert.toString() : "" ));
        intent.putExtra(Intent.EXTRA_SUBJECT, item.post);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

