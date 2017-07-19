package org.deafsapps.androidpatterndesignmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.deafsapps.androidpatterndesignmvp.view.MainActivity;

/**
 * Contract interfaces for 'View' and 'Presenter' regarding {@link MainActivity}
 *
 * @author psor1i
 * @since 1.0
 */
public interface MainContract {
	public interface View {
		public void showInfo(String info);
		public void showErrorMessage(String error);
		public void startSecondActivity(@Nullable Bundle data);
	}

	public interface Presenter {
		// User actions
		public void displayInfoClicked();
		public void startActivityClicked();
		// Model updates
		void viewAboutToGetClosed();
	}

	public interface Model {
		public String getStoredText();
	}
}
