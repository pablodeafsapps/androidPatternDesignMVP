package org.deafsapps.androidpatterndesignmvp.model;

import org.deafsapps.androidpatterndesignmvp.MyApp;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This class defines how data sources are accessed within this app. Since it has to be available
 * during the whole lifecycle, it is defined as a singleton.
 * <p>
 * This class is annotated with {@link Singleton} to make it a singleton class in the dependency
 * graph of Dagger.
 *
 * @author psor1i
 * @since 1.0
 */
public class DataManager {

	public static final String RETURN_TEXT_KEY = "RETURN_TEXT_KEY";
	private static final String TAG = DataManager.class.getSimpleName();

	@Inject
	Repository prefsHelper;

	private static DataManager dataManager;

	private DataManager() {
		MyApp.app().getModelComponent().injectDependency(this);
	}

	public static DataManager getInstance() {
		if (DataManager.dataManager == null) {
			DataManager.dataManager = new DataManager();
		}
		return DataManager.dataManager;
	}

	public Repository getHelper() {
		return this.prefsHelper;
	}
}
