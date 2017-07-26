package org.deafsapps.androidpatterndesignmvp;

import android.app.Application;

import org.deafsapps.androidpatterndesignmvp.di.DaggerModelComponent;
import org.deafsapps.androidpatterndesignmvp.di.ModelComponent;
import org.deafsapps.androidpatterndesignmvp.di.ModelModule;

/**
 * This class extends from {@link Application}, and allows to configure general aspects of the app.
 * In this particular case, it is employed to set up Dagger2 for dependency injection.
 *
 * @author psor1i
 * @since 1.0
 */
public class MyApp extends Application {

	private ModelComponent modelComponent;
	private static MyApp app;

	@Override
	public void onCreate() {
		super.onCreate();
		app = this;

		this.modelComponent = DaggerModelComponent.builder()
				.modelModule(new ModelModule(this))
				.build();
	}

	public static MyApp app() {
		return app;
	}

	public ModelComponent getModelComponent() {
		return this.modelComponent;
	}
}
