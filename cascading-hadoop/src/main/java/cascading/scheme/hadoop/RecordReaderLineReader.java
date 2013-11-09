package cascading.scheme.hadoop;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.RecordReader;

import cascading.scheme.util.LineReader;

/**
 * This is a LineReader implementation surrounding the RecordReader as used from
 * the TextDelimited.
 */
class RecordReaderLineReader implements LineReader {
   private RecordReader input;
   private Object [] context;
   private int line;


   public RecordReaderLineReader( RecordReader input, Object [] context ) {
      this.input = input;
      this.context = context;
   }


   @Override
   public boolean isFirstLine() {
      return ( line ++ ) == 1;
   }


   @Override
   public String readLine() throws IOException {
      if ( ! input.next( context[ 0 ], context[ 1 ] ) ) {
         return null;
      } else {
         return makeEncodedString( context );
      }
   }


   protected String makeEncodedString( Object[] context ) {
      Text text = (Text) context[ 1 ];
      return new String( text.getBytes(), 0, text.getLength(), (Charset) context[ 2 ] );
   }
}
