package cascading.scheme.util;

import cascading.tuple.TupleEntry;
import cascading.tuple.TupleEntryIterator;

/**
 * This is a line reader which actually reads from a TupleEntryIterator.  It
 * assumes that it returns a single-entry string.
 */
class TupleEntryLineReader implements LineReader {
   private final TupleEntryIterator iterator;
   private int line;


   public TupleEntryLineReader( TupleEntryIterator iterator ) {
      this.iterator = iterator;
   }


   @Override
   public String readLine() {
      TupleEntry entry = iterator.hasNext() ? iterator.next() : null;
      if( entry == null ) {
         return null;
      }
      return entry.getTuple().getString( 0 );
   }


   // Note: There's a side-affect here!
   @Override
   public boolean isFirstLine() {
      return ( ++ line ) == 1;
   }
}
