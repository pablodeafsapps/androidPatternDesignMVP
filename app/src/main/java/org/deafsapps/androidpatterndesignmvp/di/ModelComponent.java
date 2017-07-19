package org.deafsapps.androidpatterndesignmvp.di;

import org.deafsapps.androidpatterndesignmvp.model.DataManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * This interface is used to connect objects to their dependencies, typically by use of overridden
 * {@link Inject} methods.
 * <p>
 * This interface is annotated with the Dagger {@link Component} annotation, which takes a list of
 * modules as an input. In this case, {@link ModelModule} has been added to the list.
 */
@Singleton
@Component(modules = {ModelModule.class})
public interface ModelComponent {
	void injectDependency(DataManager dataManager);
}
