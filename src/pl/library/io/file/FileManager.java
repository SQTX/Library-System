/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io.file;

import pl.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
