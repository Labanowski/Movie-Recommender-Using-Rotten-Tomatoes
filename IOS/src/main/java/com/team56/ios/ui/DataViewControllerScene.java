package com.team56.ios.ui;

import com.intel.inde.moe.natj.general.Pointer;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.Owned;
import com.intel.inde.moe.natj.general.ann.RegisterOnStartup;
import com.intel.inde.moe.natj.general.ann.Runtime;
import com.intel.inde.moe.natj.objc.ObjCRuntime;
import com.intel.inde.moe.natj.objc.ann.ObjCClassName;
import com.intel.inde.moe.natj.objc.ann.Property;
import com.intel.inde.moe.natj.objc.ann.Selector;

import ios.uikit.UILabel;
import ios.uikit.UIViewController;
import ios.uikit.enums.NSTextAlignment;

@Runtime(ObjCRuntime.class)
@ObjCClassName("DataViewControllerScene")
@RegisterOnStartup
public class DataViewControllerScene extends UIViewController {

    private String dataString;

    private UILabel dataLabel;

    @Owned
    @Selector("alloc")
    public static native DataViewControllerScene alloc();

    @Selector("init")
    public native DataViewControllerScene init();

    protected DataViewControllerScene(Pointer peer) {
        super(peer);
    }

    @Generated
    @Property
    @Selector("dataLabel")
    public native UILabel getDataLabel();

    @Generated
    @Property
    @Selector("setDataLabel:")
    public native void setDataLabel(UILabel controller);

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String string) {
        dataString = string;
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        dataLabel = getDataLabel();
        dataLabel.setText(dataString);
        dataLabel.setTextAlignment(NSTextAlignment.Center);
    }


}
