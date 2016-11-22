# TimberUtils

Complementary trees for [Timber](https://github.com/JakeWharton/timber).

Includes:

 1. **DebugTree** for debugging
 2. **CrashlyticsTree** for sending non-fatal exceptions to [Fabric.io](Fabric.io) (Crashlytics).


Usage
-----
Plant the trees to Timber as you would normally do:

    Timber.plant(new DebugLog());

or

    Timber.plant(new CrashlyticsTree());

Installation
----
Add this in your root **build.gradle** at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

Add the dependency

	dependencies {
	        compile 'com.github.michalis-vitos:timberutils:1.0.0'
	}
