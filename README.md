# View States Switcher

![CI](https://github.com/Sergioct/ViewStatesSwitcher/workflows/CI/badge.svg)
[![Download](https://api.bintray.com/packages/sergioct/SergioCrespoToubes/ViewStatesSwitcher/images/download.svg) ](https://bintray.com/sergioct/SergioCrespoToubes/ViewStatesSwitcher/_latestVersion)
[![MinSdk](https://img.shields.io/badge/%20MinSdk%20-%2019%2B%20-f0ad4e.svg)](https://android-arsenal.com/api?level=19)

## About
Library that control the different states of a view, SUCCESS, LOADING, EMPTY, ERROR. Perfect for a simple recycler view control views.

- IDLE state show all views at the same time.

![Alt Text](https://i.imgur.com/osgI6yI.gif)

## Setup

#### Add the dependency
>

```groovy
dependencies {
    implementation 'com.sergiocrespotoubes.viewstatesswitcherlib:ViewStatesSwitcher:$version'
}
```

#### Attrs.xml
```xml
<declare-styleable name="view_states_switcher_attributes">
        <attr name="state" format="enum">
            <enum name="idle" value="0"/>
            <enum name="success" value="1"/>
            <enum name="loading" value="2"/>
            <enum name="error" value="3"/>
            <enum name="empty" value="4"/>
        </attr>
        <attr name="successView" format="reference" />
        <attr name="loadingView" format="reference" />
        <attr name="errorView" format="reference" />
        <attr name="emptyView" format="reference" />
    </declare-styleable>
```

## Usage
	
#### XML
```xml
<com.sergiocrespotoubes.viewstatesswitcherlib.ViewStatesSwitcher
            android:id="@+id/viewStatesSwitcher"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
	    custom:state="loading"
            tools:state="idle"
            custom:successView="@+id/hello"
            custom:emptyView="@+id/empty"
            custom:errorView="@+id/error"
            custom:loadingView="@+id/loading">
            
            ...
            
</com.sergiocrespotoubes.viewstatesswitcherlib.ViewStatesSwitcher>           
```
	
#### Code Java
```java
ViewStatesSwitcher viewStatesSwitcher = (ViewStatesSwitcher)findViewById(R.id.viewStatesSwitcher)
viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.SUCCESS)
viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.LOADING)
viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.EMPTY)
viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.ERROR)
```

#### Code Kotlin Ext
```java
viewStatesSwitcher.success()
viewStatesSwitcher.loading()
viewStatesSwitcher.empty()
viewStatesSwitcher.error()
```

# License
```
MIT License

Copyright (c) 2018 Sergio Crespo Toubes

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```




