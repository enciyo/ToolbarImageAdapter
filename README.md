# ToolbarImageAdapter

<img src="https://github.com/enciyo/ToolbarImageAdapter/blob/master/app/src/main/java/art/enciyo.gif?raw=true" width="320" height="560" />

## Installation
# [![](https://jitpack.io/v/enciyo/ToolbarImageAdapter.svg)](https://jitpack.io/#enciyo/ToolbarImageAdapter)
build.gradle(Module)
```
dependidependencies {
	    implementation 'com.github.enciyo:ToolbarImageAdapter:v0.1'

}
```
build.gradle(Project)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

## Usage

```
// mArrayList consists of url values of image.
toolbarImageAdapter = (CustomView) findViewById(R.id.container);
toolbarImageAdapter.setAdapter(mArrayList);
toolbarImageAdapter.setTitle("Title")
toolbarImageAdapter.setSubTitle("SubTitle")
toolbarImageAdapter.setImageButtonIcon(mIcon);

```
