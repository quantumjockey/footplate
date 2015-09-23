package com.quantumjockey.dialogs;

import com.quantumjockey.dialogs.base.ChooserWrapperBase;
import com.quantumjockey.system.SystemAttributes;
import javafx.stage.FileChooser;

import java.io.File;

public class FileSaveChooserWrapper extends ChooserWrapperBase {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private FileChooser chooser;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public FileSaveChooserWrapper(String title) {
        super(title);
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public File getSaveDirectory() {
        return this.chooser.showSaveDialog(this.chooserWindow);
    }

    public void setFileType(FileChooser.ExtensionFilter filter) {
        this.chooser.getExtensionFilters().add(filter);
    }

    public void setInitialFileName(String filename) {
        this.chooser.setInitialFileName(filename);
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
