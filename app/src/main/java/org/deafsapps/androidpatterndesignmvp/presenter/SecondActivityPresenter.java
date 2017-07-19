package org.deafsapps.androidpatterndesignmvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import org.deafsapps.androidpatterndesignmvp.MainContract;
import org.deafsapps.androidpatterndesignmvp.SecondContract;
import org.deafsapps.androidpatterndesignmvp.model.DataManager;
import org.deafsapps.androidpatterndesignmvp.model.data.ReturnData;

import java.lang.ref.WeakReference;

/**
 * This class
 *
 * @author psor1i
 * @since 1.0
 */
public class SecondActivityPresenter implements SecondContract.Presenter {

	private static final String TAG = SecondActivityPresenter.class.getSimpleName();

	// Layer View reference
	private WeakReference<SecondContract.View> secondView;


	public SecondActivityPresenter(SecondContract.View view) {
		this.secondView = new WeakReference<>(view);
	}

	@Override
	public void okClicked(String input) {
		Log.d(SecondActivityPresenter.TAG, "In-okClicked");
		if (this.validateUserInput(input)) {
			DataManager.getInstance().getHelper().add(new ReturnData(input), DataManager.RETURN_TEXT_KEY);
			secondView.get().showInfoStoredMessage("\"" + input + "\" saved");
			secondView.get().clearEditText();
		} else {
			secondView.get().showErrorMessage("Input data not valid!");
		}
	}

	private boolean validateUserInput(String input) {
		Log.d(SecondActivityPresenter.TAG, "In-validateUserInput");

		return !TextUtils.isEmpty(input);
	}

	@Override
	public <T extends MainContract.Model> void onDataChanged(T returnData) {
		this.secondView.get().showInfoStoredMessage("\"" + returnData.getStoredText() + " \" stored successfully");
	}
}
