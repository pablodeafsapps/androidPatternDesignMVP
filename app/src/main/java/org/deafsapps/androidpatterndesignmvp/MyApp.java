package org.deafsapps.androidpatterndesignmvp;

import android.app.Application;

import org.deafsapps.androidpatterndesignmvp.di.DaggerModelComponent;
import org.deafsapps.androidpatterndesignmvp.di.ModelComponent;
import org.deafsapps.androidpatterndesignmvp.di.ModelModule;

/**
 * Created by psor1i on 18-Jul-17.
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
