package org.deafsapps.androidpatterndesignmvp.di;

import android.content.Context;
import android.content.SharedPreferences;

import org.deafsapps.androidpatterndesignmvp.model.Repository;
import org.deafsapps.androidpatterndesignmvp.model.SharedPreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 * This class is annotated with the Dagger {@link Module} annotation, which tells Dagger tha this
 * entity will provide dependencies for a part of the application.
 */
@Module
public class ModelModule {

	private Context context;

	public ModelModule(Context ctx) {
		this.context = ctx;
	}

	@Singleton
	@Provides
	public Context provideContext() {
		return this.context;
	}

	/**
	 * Since it is annotated with the Dagger {@link Provides} annotation, this method will provide
	 * a certain type of dependency; specifically, a {@link SharedPreferences} instance.
	 *
	 * @return the dependency to be injected in the app, at some point.
	 */
	@Provides
	@Singleton
	SharedPreferences provideSharedPreferences() {
		return this.context.getSharedPreferences(this.context.getPackageName(), Context.MODE_PRIVATE);
	}

	/**
	 * Since it is annotated with the Dagger {@link Provides} annotation, this method will provide
	 * a certain type of dependency; specifically, a {@link SharedPreferencesHelper} instance.
	 *
	 * @return the dependency to be injected in the app, at some point.
	 */
	@Provides
	@Singleton
	Repository provideSharedPreferencesHelper() {
		return new SharedPreferencesHelper();
	}
}
