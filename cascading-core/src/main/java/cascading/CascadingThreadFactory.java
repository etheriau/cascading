package cascading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Providing a generic fixture for overriding thread creation properties. 
 */
public class CascadingThreadFactory {
   public static class ThreadFactory {
     public Thread createThread() {
       return new Thread();
     }

     public Thread createThread( Runnable runnable ) {
       return new Thread( runnable );
     }

     public Thread createThread( Runnable runnable, String name ) {
       return new Thread( runnable, name );
     }

     public Thread createThread( String name ) {
       return new Thread( name );
     }

     public ExecutorService createNewFixedExecutorService( int size ) {
       return Executors.newFixedThreadPool( size );
     }

     public ExecutorService createSingleThreadExecutor() {
       return Executors.newSingleThreadExecutor();
     }

     public ExecutorService createSingleThreadExecutor( java.util.concurrent.ThreadFactory threadFactory ) {
       return Executors.newSingleThreadExecutor( threadFactory );
     }
   }

   private static ThreadFactory threadFactory = new ThreadFactory();

   /**
    * Installs your own thread factory.  This is primarily for Local Mode at the moment.
    */
   public static void initializeThreadFactory( ThreadFactory tf ) {
     threadFactory = tf;
   }

   /**
    * Creates a generic thread.
    */
   public static Thread createThread() {
     return threadFactory.createThread();
   }

   /**
    * Creates a thread for this runnable.
    */
   public static Thread createThread( Runnable runnable ) {
     return threadFactory.createThread( runnable );
   }

   /**
    * Creates a named thread for this runnable.
    */
   public static Thread createThread( Runnable runnable, String name ) {
     return threadFactory.createThread( runnable, name );
   }

   /**
    * Creates a named thread.
    */
   public static Thread createThread( String name ) {
     return threadFactory.createThread( name );
   }

   /**
    * Creates a fixed-thread executor service.
    */
   public static ExecutorService createNewFixedExecutorService( int size ) {
     return threadFactory.createNewFixedExecutorService( size );
   }

   /**
    * Creates a single-thread executor service.
    */
   public static ExecutorService createSingleThreadExecutor() {
     return threadFactory.createSingleThreadExecutor();
   }

   public static ExecutorService createSingleThreadExecutor( java.util.concurrent.ThreadFactory tf ) {
     return threadFactory.createSingleThreadExecutor( tf );
   }
}
