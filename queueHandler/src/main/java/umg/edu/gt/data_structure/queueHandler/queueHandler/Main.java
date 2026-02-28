package umg.edu.gt.data_structure.queueHandler.queueHandler;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;
import umg.edu.gt.model.Song;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    // Mejora 1: Contador de tiempo total acumulado
    private static int totalPlaybackTime = 0;

    public static void main(String[] args) {
        QueueLinked<Song> highPriorityQueue = new QueueLinked<>();
        QueueLinked<Song> normalPriorityQueue = new QueueLinked<>();

        // 1. Agregar canciones (Prioridad 1 = Alta, 2 = Normal)
        
        highPriorityQueue.enqueue(new Song("Blinding Lights", "The Weeknd", 8, 1));
        normalPriorityQueue.enqueue(new Song("Bohemian Rhapsody", "Queen", 15, 2)); 
        normalPriorityQueue.enqueue(new Song("Yellow", "Coldplay", 6, 2));
        highPriorityQueue.enqueue(new Song("Starboy", "The Weeknd", 5, 1)); 

        logger.info("Starting playlist...");

        
        playQueue(highPriorityQueue);

       
        playQueue(normalPriorityQueue);

        logger.info("Playlist finished.");
        
        logger.info("Total time played: " + totalPlaybackTime + " seconds.");
    }

    private static void playQueue(QueueLinked<Song> queue) {
        while (!queue.isEmpty()) {
            Song song = queue.dequeue();
            logger.info("Now playing: " + song.toString());

            for (int i = 1; i <= song.getDuration(); i++) {
                try {
                    Thread.sleep(1000); 
                    totalPlaybackTime++; 
                    
                    // Mejora 2: Barra de progreso visual
                    String progressBar = generateProgressBar(i, song.getDuration());
                    
                    logger.info("Playing: " + song.getTitle() + " " + progressBar + " " + i + "s / " + song.getDuration() + "s");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            logger.info("Finished: " + song.getTitle());
        }
    }

    
    private static String generateProgressBar(int current, int total) {
        int barLength = 10; // Tamaño de la barra
        int completedChars = (current * barLength) / total;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < completedChars) sb.append("#");
            else sb.append("-");
        }
        sb.append("]");
        return sb.toString();
    }
}
