package com.quantumjockey.paths.filters;

import java.io.FilenameFilter;

public class FilterWrapper {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private FilenameFilter filter;

    /////////// Accessors /////////////////////////////////////////////////////////////////////

    public FilenameFilter getFilter() {
        return filter;
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public FilterWrapper(final String[] filters) {
        this.filter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();

            for (String filter : filters)
                if (lowercaseName.endsWith(filter))
                    return true;

            return false;
        };
    }

}
