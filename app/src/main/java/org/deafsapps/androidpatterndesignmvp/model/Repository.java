package org.deafsapps.androidpatterndesignmvp.model;

import org.deafsapps.androidpatterndesignmvp.model.data.ReturnData;

/**
 * This interface defines the base definition of the "Repository" pattern.
 *
 * @author psor1i
 * @since 1.0
 */
public interface Repository {
	public void add(ReturnData preference, String key);
	public ReturnData fetch(String key);
	public void remove(String preferenceKey);
}
