package com.quantumjockey.dialogs;

import com.quantumjockey.dialogs.base.ChooserWrapperBase;
import com.quantumjockey.system.SystemAttributes;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class DirectoryChooserWrapper extends ChooserWrapperBase {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private DirectoryChooser chooser;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public DirectoryChooserWrapper(String title) {
        super(title);
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public File getSelectedDirectory() {
        return this.chooser.showDialog(this.chooserWindow);
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    @Override
    protected void initializeChooserObjects() {
        this.chooser = new DirectoryChooser();
    }

    @Override
    protected void initializeChooserAttributes() {
        this.chooser.setInitialDirectory(new File(SystemAttributes.UserHome()));
        this.chooser.setTitle(chooserTitle);
    }

}
