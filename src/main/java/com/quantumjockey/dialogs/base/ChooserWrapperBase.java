package com.quantumjockey.dialogs.base;

import javafx.stage.Stage;

public abstract class ChooserWrapperBase {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    protected String chooserTitle;
    protected Stage chooserWindow;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    protected ChooserWrapperBase(String title) {
        this.initializeChooserDefaults(title);
        this.initializeChooserObjects();
        this.initializeChooserAttributes();
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    private void initializeChooserDefaults(String _title) {
        this.chooserWindow = new Stage();
        this.chooserTitle = _title;
    }

    /////////// Protected Methods /////////////////////////////////////////////////////////////

    protected abstract void initializeChooserObjects();

    protected abstract void initializeChooserAttributes();

}
