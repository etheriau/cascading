/*
 * Copyright (c) 2007-2013 Concurrent, Inc. All Rights Reserved.
 *
 * Project and contact information: http://www.cascading.org/
 *
 * This file is part of the Cascading project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cascading.scheme.util;

import java.io.IOException;

/**
 * The LineReader class reads a single line from the data to aid in parsing data,
 * particularly multi-line streams.
 */
public interface LineReader {
   /**
    * Is this the first line?  Note: Some implementations may use this as a counter
    * to determine if this is the actual first line or not.  In such cases, repeatedly
    * calling this method will return false even if you don't read.
    */
   boolean isFirstLine();

   /**
    * Reads the next line in a file.  If we are at the end of the file, it will
    * return null.
    */
   String readLine() throws IOException;
}
