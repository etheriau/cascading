package cascading.scheme.local;

import java.io.IOException;
import java.io.LineNumberReader;

import cascading.scheme.util.LineReader;

/**
 * This is a LineReader that wraps a LineReaderInputStream.
 */
class LineReaderInputStreamLineReader implements LineReader {
   private final LineNumberReader lineReader;


   public LineReaderInputStreamLineReader( LineNumberReader lineReader ) {
      this.lineReader = lineReader;
   }


   public boolean isFirstLine() {
      return lineReader.getLineNumber() == 1;
   }


   @Override
   public String readLine() throws IOException {
      return lineReader.readLine();
   }
}
