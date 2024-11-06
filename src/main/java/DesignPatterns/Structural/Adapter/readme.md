The **Adapter** design pattern allows incompatible interfaces to work together. It acts as a bridge between two interfaces, converting one type of interface to another that the client expects.

### Example Scenario

Let's imagine a `MediaPlayer` interface that can play audio files in MP3 format. However, there’s another class, `AdvancedMediaPlayer`, that can play both MP4 and VLC formats. Using the Adapter pattern, we can create an adapter that allows the `MediaPlayer` to play MP4 and VLC files using the `AdvancedMediaPlayer`.

### Example Code

```java
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
```

### Explanation of the Code

1. **Target Interface (`MediaPlayer`)**:
    - `MediaPlayer` defines the `play()` method that accepts a file type and filename. This is the expected interface the client works with.

2. **Adaptee Interfaces and Classes (`AdvancedMediaPlayer`, `MP4Player`, `VLCPlayer`)**:
    - `AdvancedMediaPlayer` has methods for playing MP4 and VLC files.
    - `MP4Player` and `VLCPlayer` implement `AdvancedMediaPlayer` to handle each specific file type.

3. **Adapter Class (`MediaAdapter`)**:
    - `MediaAdapter` implements `MediaPlayer` and acts as a bridge between `MediaPlayer` and `AdvancedMediaPlayer`.
    - It initializes the correct `AdvancedMediaPlayer` (either `MP4Player` or `VLCPlayer`) based on the file type.

4. **Client Class (`AudioPlayer`)**:
    - `AudioPlayer` uses `MediaAdapter` when it needs to play files other than MP3.
    - If the file type is MP3, it plays the file directly. If the file type is MP4 or VLC, it uses `MediaAdapter`.

5. **Client Code**:
    - The client creates an `AudioPlayer` instance and calls `play()` with different audio types.
    - The adapter pattern allows `AudioPlayer` to support new audio types without modifying its own implementation.

### Output

```plaintext
Playing MP3 file. Name: song.mp3
Playing MP4 file. Name: video.mp4
Playing VLC file. Name: movie.vlc
Invalid media. avi format not supported
```

### Advantages of the Adapter Pattern

1. **Decouples Client and Adaptee**: The client works with a standard interface, while the adapter handles the specifics of the adaptee.
2. **Easy to Extend**: New file types (e.g., `flv`, `mov`) can be supported by adding new `AdvancedMediaPlayer` classes and updating the adapter without modifying the client.
3. **Improves Code Reusability**: Allows the reuse of legacy or third-party code by adapting it to the client's expected interface.

The Adapter pattern is useful when integrating incompatible interfaces and is common in APIs, legacy code integration, and bridging different systems.