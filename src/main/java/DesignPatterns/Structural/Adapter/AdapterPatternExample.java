package DesignPatterns.Structural.Adapter;
// Step 1: Define the Target interface (MediaPlayer)
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Step 2: Define the Adaptee classes (AdvancedMediaPlayer, MP4Player, and VLCPlayer)
interface AdvancedMediaPlayer {
    void playMP4(String fileName);
    void playVLC(String fileName);
}

class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file. Name: " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }
}

class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }

    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

// Step 3: Create an Adapter class that implements the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    // Constructor decides which player to use based on audioType
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVLC(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMP4(fileName);
        }
    }
}

// Step 4: Implement the MediaPlayer interface with an AudioPlayer class, which uses the adapter
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Built-in support for MP3 files
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file. Name: " + fileName);
        }
        // Use the adapter for VLC or MP4 files
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Step 5: Client code to use the AudioPlayer
public class AdapterPatternExample {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "unsupported.avi");
    }
}