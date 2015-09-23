package com.quantumjockey.dialogs;

import com.quantumjockey.dialogs.base.ChooserWrapperBase;
import com.quantumjockey.system.SystemAttributes;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;

public class FileOpenChooserWrapper extends ChooserWrapperBase {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private FileChooser chooser;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public FileOpenChooserWrapper(String title) {
        super(title);
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public File getFileToOpen() {
        return this.chooser.showOpenDialog(this.chooserWindow);
    }

    public void setFilters(ExtensionFilter[] filters) {
        for (ExtensionFilter item : filters)
            this.chooser.getExtensionFilters().add(item);
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    @Override
    protected void initializeChooserObjects() {
        this.chooser = new FileChooser();
    }

    @Override
    protected void initializeChooserAttributes() {
        this.chooser.setInitialDirectory(new File(SystemAttributes.UserHome()));
        this.chooser.setTitle(chooserTitle);
    }

}
