package gr.michalisvitos.timberutils;

import timber.log.Timber;

/**
 * A {@link timber.log.Timber.Tree Tree} for debug builds. This trees prints a tag in the
 * following format: className[threadName].methodName()#lineNumber
 * <p>
 * Created by Michalis Vitos on 21/11/2016.
 */
public class DebugTree extends Timber.DebugTree
{
	public DebugTree()
	{
		super();
	}

  @Override
  protected String createStackElementTag(StackTraceElement element)
  {
    final String stackElementTag = super.createStackElementTag(element);
    final String threadName = Thread.currentThread().getName();
    final int lineNumber = element.getLineNumber();
    String methodName = element.getMethodName();
    if (methodName.contains("\\$"))
      methodName = methodName.split("\\$")[0];

    return String.format("%s[%s].%s()#%s",
        stackElementTag,
        threadName,
        methodName,
        lineNumber
    );
  }
}
