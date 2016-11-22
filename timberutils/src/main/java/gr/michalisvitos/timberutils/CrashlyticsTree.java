package gr.michalisvitos.timberutils;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

/**
 * A {@link timber.log.Timber.Tree Tree} that logs crashes on Crashlytics.
 * <p>
 * Created by Michalis Vitos on 21/11/2016.
 */
public class CrashlyticsTree extends Timber.Tree
{
	private static final String KEY_PRIORITY = "priority";
	private static final String KEY_TAG = "tag";
	private static final String KEY_MESSAGE = "message";

	public CrashlyticsTree()
	{
		super();
	}

	@Override
	protected void log(int priority, String tag, String message, Throwable t)
	{
		if(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO)
			return;

		Crashlytics.setInt(KEY_PRIORITY, priority);
		Crashlytics.setString(KEY_TAG, tag);
		Crashlytics.setString(KEY_MESSAGE, message);

		if(t == null)
			Crashlytics.logException(new Exception(message));
		else
			Crashlytics.logException(t);
	}

}