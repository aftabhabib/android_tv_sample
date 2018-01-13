package com.nambv.android_tv_sample.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;

import com.nambv.android_tv_sample.GlideBackgroundManager;
import com.nambv.android_tv_sample.R;
import com.nambv.android_tv_sample.data.models.Movie;
import com.nambv.android_tv_sample.presenter.CardPresenter;
import com.nambv.android_tv_sample.presenter.GridItemPresenter;

/**
 * BrowseFragment class is supplied by Android SDK Leanback library, and it creates standard UI for Android TV application
 *
 * BrowseFragment supports to set listener when the itemview is selected & clicked.
 * Current target is to be get notified when the user move the cursor and change the selection of item.
 */
public class MainFragment extends BrowseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private static GlideBackgroundManager simpleBackgroundManager = null;
    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        simpleBackgroundManager = new GlideBackgroundManager(getActivity());

        setupUIElements();
        loadRows();
        setupEventListeners();
    }

    private void setupUIElements() {

        // Use this to display logo app
//         setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.app_icon_your_company));

         // Use this to display title
        setTitle("Hello Android TV!"); // Badge, when set, takes precedent

        // over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void loadRows() {

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "Sample Grid Data");

        GridItemPresenter mGridPresenter = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);

        gridRowAdapter.add("ITEM 1");
        gridRowAdapter.add("ITEM 2");
        gridRowAdapter.add("ITEM 3");

        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

        HeaderItem cardPresenterHeader = new HeaderItem(1, "Series Devil May Cry");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for (int i = 1; i <= 10; i++) {
            Movie movie = new Movie();
            movie.setTitle("Devil May Cry " + i);
            movie.setOverview("Description here");
            movie.setPosterPath("http://heavyarm-asia.com/wp-content/uploads/2017/12/ps4-devil-may-cry.jpg");
            movie.setBackdropPath("https://static.zerochan.net/Vergil.%28Devil.May.Cry%29.full.1862449.jpg");
            cardRowAdapter.add(movie);
        }

        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
        setAdapter(mRowsAdapter);
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {

        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {

            // Each time the item is selected, code inside here will be executed.
            if (item instanceof String) {
                simpleBackgroundManager.updateBackgroundWithDelay("https://cdn3.dualshockers.com/wp-content/uploads/2015/05/maxresdefault2.jpg");
            } else if (item instanceof Movie) {
                if (getActivity() != null) {
                    simpleBackgroundManager.updateBackgroundWithDelay(((Movie) item).getBackdropPath());
                }
            }
        }
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {

        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            // Each time the item is clicked, code inside here will be executed.
        }
    }
}

