package com.quantumjockey.paths;

import com.quantumjockey.system.SystemAttributes;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PathWrapper {

    /////////// Properties //////////////////////////////////////////////////////////////////

    protected StringProperty injectedPath = new SimpleStringProperty();

    public final String getInjectedPath() {
        return this.injectedPath.get();
    }

    public final void setInjectedPath(String value) {
        this.injectedPath.set(value);
    }

    public StringProperty injectedPathProperty() {
        return this.injectedPath;
    }

    protected StringProperty pathHead = new SimpleStringProperty();

    public final String getPathHead() {
        return this.pathHead.get();
    }

    public final void setPathHead(String value) {
        this.pathHead.set(value);
    }

    public StringProperty pathHeadProperty() {
        return this.pathHead;
    }

    protected StringProperty pathTail = new SimpleStringProperty();

    public final String getPathTail() {
        return this.pathTail.get();
    }

    public final void setPathTail(String value) {
        this.pathTail.set(value);
    }

    public StringProperty pathTailProperty() {
        return this.pathTail;
    }

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public PathWrapper(String _injectedPath) {
        this.setInjectedPath(_injectedPath);
        this.parsePath(_injectedPath);
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    private void parsePath(String path) {
        String[] pathTemp;
        int numComponents;

        pathTemp = PathSplicer.getPathComponents(path);
        numComponents = pathTemp.length;

        this.setPathTail(pathTemp[numComponents - 1]);
        this.setPathHead(path.replace(SystemAttributes.FileSeparator() + getPathTail(), ""));
    }

}
