package org.deafsapps.androidpatterndesignmvp.presenter;

import android.text.TextUtils;

import org.deafsapps.androidpatterndesignmvp.MainContract;
import org.deafsapps.androidpatterndesignmvp.model.DataManager;
import org.deafsapps.androidpatterndesignmvp.model.data.ReturnData;

import java.lang.ref.WeakReference;

/**
 * This class
 *
 * @author psor1i
 * @since 1.0
 */
public class MainActivityPresenter implements MainContract.Presenter {

	// Layer View reference
	private WeakReference<MainContract.View> mainView;
	// Layer Model reference

	public MainActivityPresenter(MainContract.View view) {
		this.mainView = new WeakReference<>(view);
	}

	@Override
	public void displayInfoClicked() {
		final ReturnData data = DataManager.getInstance().getHelper().fetch(DataManager.RETURN_TEXT_KEY);

		if (!TextUtils.isEmpty(data.getReturnText())) {
			this.mainView.get().showInfo(data.getReturnText());
		} else {
			this.mainView.get().showErrorMessage("Info not available!");
		}
	}

	@Override
	public void startActivityClicked() {
		this.mainView.get().startSecondActivity(null);
	}

	@Override
	public void viewAboutToGetClosed() {
		DataManager.getInstance().getHelper().remove(DataManager.RETURN_TEXT_KEY);
	}
}
