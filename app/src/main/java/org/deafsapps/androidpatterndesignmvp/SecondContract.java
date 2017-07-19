package org.deafsapps.androidpatterndesignmvp;

import org.deafsapps.androidpatterndesignmvp.view.SecondActivity;

/**
 * Contract interfaces for 'View' and 'Presenter' regarding {@link SecondActivity}
 *
 * @author psor1i
 * @since 1.0
 */
public interface SecondContract {
	public interface View {
		public void showErrorMessage(String error);
		public void showInfoStoredMessage(String info);
		public void clearEditText();
	}

	public interface Presenter {
		// User actions
		public void okClicked(String input);
		// Model updates
		public <T extends MainContract.Model> void onDataChanged(T returnData);
	}

	public interface Model {
		public void storeInputText(String input);
	}
}
