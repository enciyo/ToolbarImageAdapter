# ToolbarImageAdapter

<img src="https://github.com/enciyo/ToolbarImageAdapter/blob/master/app/src/main/java/art/enciyo.gif?raw=true" width="320" height="560" />

## Installation
# [![](https://jitpack.io/v/enciyo/ToolbarImageAdapter.svg)](https://jitpack.io/#enciyo/ToolbarImageAdapter)
build.gradle(Module)
```
dependidependencies {
	    implementation 'com.github.enciyo:ToolbarImageAdapter:$version'

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
toolbarImageAdapter.addImage(mImageUrl);
toolbarImageAdapter.setTitle("Title")
toolbarImageAdapter.setSubTitle("SubTitle")
toolbarImageAdapter.setmImageButton(mImageButton);
toolbarImageAdapter.setmToolbar(mToolbar);
toolbarImageAdapter.getmImageButton().setOnClickListener(new View.OnClickListener() {..//do Something}

//You must add this line
setSupporActionBar(toolbarImageAdapter.getmToolbar());
```
Xml

```
//You must use CoordinatorLayout
<android.support.design.widget.CoordinatorLayout	
...>
 
   <com.enciyo.enciyoappbarlayout.CustomView
       android:layout_width="match_parent"
       android:id="@+id/toolbarImageAdapter"
       android:layout_height="300dp"
       app:appBarTitle="Title"
       app:appBarSubtitle="Subtitle"
       app:imageTitle="ImageTitle"
       app:imageSubtitle="ImageSubtitle"
       app:toolbar_color="@color/toolbar_color"
       app:appbarTitleColor="@color/title_color"
       app:appbarSubTitleColor="@color/subtitle_color"
       app:imageSubTitleColor="@color/image_subtitle_color"
       app:imageTitleColor="@color/image_title_color"/>
   
   <android.support.v4.widget.NestedScrollView  
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    ...>
	
```
