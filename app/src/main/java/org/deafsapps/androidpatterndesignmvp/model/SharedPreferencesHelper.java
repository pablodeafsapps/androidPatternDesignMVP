package org.deafsapps.androidpatterndesignmvp.model;

import android.content.SharedPreferences;

import org.deafsapps.androidpatterndesignmvp.model.data.ReturnData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This class defines a helper to access/handle {@link SharedPreferences} in the app. An instance of
 * this class will be used by {@link DataManager}, in order to integrate the solution in the MVP
 * paradigm.
 * <p>
 * This class is annotated with {@link Singleton} to make it a singleton class in the dependency
 * graph of Dagger.
 *
 * @author psor1i
 * @since 1.0
 */
@Singleton
public class SharedPreferencesHelper implements Repository {

	SharedPreferences preferences;

	/**
	 * The constructor is annotated with {@link Inject} to instruct Dagger to accumulate all the
	 * parameter dependencies when the class is being constructed.
	 */
	@Inject
	public SharedPreferencesHelper(SharedPreferences sharedPreferences) {
		this.preferences = sharedPreferences;
	}

	@Override
	public void add(ReturnData returnData, String preferenceKey) {
		this.preferences.edit().putString(preferenceKey, returnData.getReturnText()).apply();
	}

	@Override
	public ReturnData fetch(String preferenceKey) {

		final String returnString = this.preferences.getString(preferenceKey, null);

		return new ReturnData(returnString);
	}

	@Override
	public void remove(String preferenceKey) {
		this.preferences.edit().remove(preferenceKey).apply();
	}
}
