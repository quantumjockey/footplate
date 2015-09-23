package com.quantumjockey.paths.filters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class FilterWrapperTest {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    String[] extensions;
    FilterWrapper wrapper;

    /////////// Setup/Teardown //////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {
        this.extensions = new String[]{".java", ".fxml", ".gitignore", ".iml", ".md"};
        this.wrapper = new FilterWrapper(this.extensions);
    }

    @After
    public void tearDown() throws Exception {

    }

    /////////// Tests ///////////////////////////////////////////////////////////////////////

    @Test
    public void getFilter_PassFilteredFileType_True() {
        File testDirectory;
        String testFile;

        testDirectory = new File(".");
        testFile = "FilterWrapperTest.java";

        Assert.assertTrue(this.wrapper.getFilter().accept(testDirectory, testFile));
    }

    @Test
    public void getFilter_PassNonFilteredFileType_False() {
        File testDirectory;
        String testFile;

        testDirectory = new File(".");
        testFile = "FilterWrapperTest.j";

        Assert.assertFalse(this.wrapper.getFilter().accept(testDirectory, testFile));
    }

}
