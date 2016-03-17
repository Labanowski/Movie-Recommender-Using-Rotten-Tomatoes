package com.team56.ios.ui;

import com.intel.inde.moe.natj.general.Pointer;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.Owned;
import com.intel.inde.moe.natj.general.ann.RegisterOnStartup;
import com.intel.inde.moe.natj.general.ann.Runtime;
import com.intel.inde.moe.natj.objc.ObjCRuntime;
import com.intel.inde.moe.natj.objc.ann.ObjCClassName;
import com.intel.inde.moe.natj.objc.ann.Selector;

import java.text.DateFormatSymbols;

import ios.NSObject;
import ios.uikit.UIPageViewController;
import ios.uikit.UIStoryboard;
import ios.uikit.UIViewController;
import ios.uikit.protocol.UIPageViewControllerDataSource;

@Runtime(ObjCRuntime.class)
@ObjCClassName("ModelController")
@RegisterOnStartup
public class ModelController extends NSObject implements UIPageViewControllerDataSource {

    public String getMonth(long month) {
        return new DateFormatSymbols().getMonths()[((int) month)];
    }

    @Owned
    @Selector("alloc")
    public static native ModelController alloc();

    @Selector("init")
    public native ModelController init();

    @Generated
    protected ModelController(Pointer peer) {
        super(peer);
    }

    @Override
    public UIViewController pageViewControllerViewControllerAfterViewController(UIPageViewController uiPageViewController, UIViewController uiViewController) {
        long index = indexOfViewController((DataViewControllerScene) uiViewController);
        if (index < 0)
            return null;
        index++;
        if (index == 12)
            return null;

        return viewControllerSceneAtIndex(index, uiViewController.storyboard());
    }

    @Override
    public UIViewController pageViewControllerViewControllerBeforeViewController(UIPageViewController uiPageViewController, UIViewController uiViewController) {
        long index = indexOfViewController((DataViewControllerScene) uiViewController);
        if (index <= 0)
            return null;
        index--;
        return viewControllerSceneAtIndex(index, uiViewController.storyboard());
    }

    @Generated
    DataViewControllerScene viewControllerSceneAtIndex(long index, UIStoryboard storyboard) {
        // Return the data view controller for the given index.
        if (index < 0 || index > 11)
            return null;
        // Create a new view controller and pass suitable data.
        DataViewControllerScene dataViewControllerScene = (DataViewControllerScene) storyboard.instantiateViewControllerWithIdentifier("DataViewControllerScene");
        dataViewControllerScene.setDataString(getMonth(index));
        return dataViewControllerScene;
    }

    @Generated
    long indexOfViewController(DataViewControllerScene viewControllerScene) {
        long index = -1;
        for(int i = 0; i < 12; i++) {
            if (getMonth(i) == viewControllerScene.getDataString()) {
                index = i;
                break;
            }
        }
        return index;
    }
}
