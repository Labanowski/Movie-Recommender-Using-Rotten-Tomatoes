package com.team56.ios.ui;

import com.intel.inde.moe.natj.general.Pointer;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.Owned;
import com.intel.inde.moe.natj.general.ann.RegisterOnStartup;
import com.intel.inde.moe.natj.objc.ObjCRuntime;
import com.intel.inde.moe.natj.objc.ann.ObjCClassName;
import com.intel.inde.moe.natj.general.ann.Runtime;
import com.intel.inde.moe.natj.objc.ann.Property;
import com.intel.inde.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.NSMutableArray;
import ios.uikit.UIDevice;
import ios.uikit.UIPageViewController;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIInterfaceOrientation;
import ios.uikit.enums.UIPageViewControllerNavigationDirection;
import ios.uikit.enums.UIPageViewControllerNavigationOrientation;
import ios.uikit.enums.UIPageViewControllerSpineLocation;
import ios.uikit.enums.UIPageViewControllerTransitionStyle;
import ios.uikit.enums.UIUserInterfaceIdiom;
import ios.uikit.protocol.UIPageViewControllerDelegate;

@Runtime(ObjCRuntime.class)
@ObjCClassName("RootViewControllerScene")
@RegisterOnStartup
public class RootViewControllerScene extends UIViewController implements UIPageViewControllerDelegate {

    private ModelController modelController;

    @Owned
    @Selector("alloc")
    public static native RootViewControllerScene alloc();

    @Selector("init")
    public native RootViewControllerScene init();

    @Generated
    protected RootViewControllerScene(Pointer peer) {
        super(peer);
    }

    @Override
    public void viewDidLoad() {
        // Do any additional setup after loading the view, typically from a nib.
        // Configure the page view controller and add it as a child view controller.
        setPageViewController(
                UIPageViewController.alloc().initWithTransitionStyleNavigationOrientationOptions(
                        UIPageViewControllerTransitionStyle.PageCurl,
                        UIPageViewControllerNavigationOrientation.Horizontal, null));
        pageViewController().setDelegate(this);

        modelController = ModelController.alloc().init();
        DataViewControllerScene startingViewController = modelController.viewControllerSceneAtIndex(0, storyboard());
        NSMutableArray viewControllers = NSMutableArray.alloc().init();
        viewControllers.addObject(startingViewController);

        pageViewController().setViewControllersDirectionAnimatedCompletion(viewControllers, UIPageViewControllerNavigationDirection.Forward, false, null);
        pageViewController().setDataSource(modelController);

        addChildViewController(pageViewController());
        view().addSubview(pageViewController().view());

        // Set the page view controller's bounds using an inset rect so that self's view is visible around the edges of the pages.
        CGRect pageViewRect = view().bounds();
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Pad) {
            pageViewRect = CoreGraphics.CGRectInset(pageViewRect, 40.0, 40.0);
        }

        pageViewController().view().setFrame(pageViewRect);
        pageViewController().didMoveToParentViewController(this);

        // Add the page view controller's gesture recognizers to the book view controller's view so that the gestures are started more easily.
        view().setGestureRecognizers(pageViewController().gestureRecognizers());
    }

    @Generated
    @Property
    @Selector("pageViewController")
    public native UIPageViewController pageViewController();

    @Generated
    @Property
    @Selector("setPageViewController:")
    public native void setPageViewController(UIPageViewController controller);

    @Override
    public long pageViewControllerSpineLocationForInterfaceOrientation(UIPageViewController pageViewController, long orientation) {
        if (UIInterfaceOrientation.Portrait == orientation || UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
            // In portrait orientation or on iPhone: Set the spine position to "min" and the page view controller's view controllers array to
            // contain just one view controller. Setting the spine position to 'UIPageViewControllerSpineLocationMid' in landscape orientation
            // sets the doubleSided property to YES, so set it to NO here.
            UIViewController currentViewController = (UIViewController) pageViewController().viewControllers().get(0);
            NSMutableArray viewControllers = NSMutableArray.alloc().init();
            viewControllers.addObject(currentViewController);

            pageViewController().setViewControllersDirectionAnimatedCompletion(viewControllers, UIPageViewControllerNavigationDirection.Forward, true, null);

            pageViewController().setDoubleSided(false);

            return UIPageViewControllerSpineLocation.Min;
        }

        // In landscape orientation: Set set the spine location to "mid" and the page view controller's view controllers array to contain two view
        // controllers. If the current page is even, set it to contain the current and next view controllers; if it is odd, set the array to contain
        // the previous and current view controllers.
        DataViewControllerScene currentViewController = (DataViewControllerScene) pageViewController().viewControllers().get(0);

        NSMutableArray viewControllers = NSMutableArray.alloc().init();

        long indexOfCurrentViewController = modelController.indexOfViewController(currentViewController);
        if (indexOfCurrentViewController == 0 || indexOfCurrentViewController % 2 == 0) {
            UIViewController nextViewController = modelController.pageViewControllerViewControllerAfterViewController(
                    pageViewController(), currentViewController);
            viewControllers.addObject(currentViewController);
            viewControllers.addObject(nextViewController);
        } else {
            UIViewController previousViewController = modelController.pageViewControllerViewControllerBeforeViewController(
                    pageViewController(), currentViewController);
            viewControllers.addObject(previousViewController);
            viewControllers.addObject(currentViewController);
        }

        pageViewController().setViewControllersDirectionAnimatedCompletion(viewControllers, UIPageViewControllerNavigationDirection.Forward, true, null);

        return UIPageViewControllerSpineLocation.Mid;
    }
}
