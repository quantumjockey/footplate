package com.quantumjockey.paths;

import com.quantumjockey.system.SystemAttributes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathWrapperTest {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    String pathFull;
    String pathHead;
    String pathTail;
    PathWrapper wrapped;

    /////////// Setup/Teardown //////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {
        this.pathFull = "C:" + SystemAttributes.FileSeparator() + "Users" + SystemAttributes.FileSeparator() + "example.txt";
        this.pathHead = "C:" + SystemAttributes.FileSeparator() + "Users";
        this.pathTail = "example.txt";
        this.wrapped = new PathWrapper(this.pathFull);
    }

    @After
    public void tearDown() throws Exception {

    }

    /////////// Tests ///////////////////////////////////////////////////////////////////////

    @Test
    public void getInjectedPath_GetsFullPath() {
        Assert.assertEquals(this.pathFull, this.wrapped.getInjectedPath());
    }

    @Test
    public void getPathHead_GetsDirectory() {
        Assert.assertEquals(this.pathHead, this.wrapped.getPathHead());
    }

    @Test
    public void getPathTail_GetsFilename() {
        Assert.assertEquals(this.pathTail, this.wrapped.getPathTail());
    }

}
