package nl.codeforall.pr3d1t0rs.gjm.ships;


import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class MusicPlayer {

    public static void start() throws Exception {


        // obtain an audio input stream from the provided file
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("resources/music.au"));

        // obtain the audio format of the sound data in this audio input stream
        AudioFormat format = stream.getFormat();

        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {

            format = new AudioFormat(

                    AudioFormat.Encoding.PCM_SIGNED,

                    format.getSampleRate(),

                    format.getSampleSizeInBits()*2,

                    format.getChannels(),

                    format.getFrameSize()*2,

                    format.getFrameRate(),

                    true

            );

            stream = AudioSystem.getAudioInputStream(format, stream);
        }

        // construct a data line's info object from the specified information,
        // which includes a single audio format and a desired buffer size
        SourceDataLine.Info lineInfo = new DataLine.Info(
                SourceDataLine.class,
                stream.getFormat(),
                ((int)stream.getFrameLength()*format.getFrameSize())
        );

        // obtain a line that matches the description in the specified Line.Info
        SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(lineInfo);

        // open the line with the specified format, causing the line to acquire any
        // required system resources and become operational
        dataLine.open(stream.getFormat());

        // allow the line to engage in data I/O.
        dataLine.start();

        int bytesRead = 0;
        byte[] buffer = new byte[dataLine.getBufferSize()];

        // read from the input file and play
        while ((bytesRead = stream.read(buffer, 0, buffer.length)) >= 0) {

            int offset = 0;

            while (offset < bytesRead) {

                offset += dataLine.write(buffer, offset, bytesRead-offset);

            }
        }

        // drain queued data from the line by continuing data I/O until the
        // data line's internal buffer has been emptied
        //dataLine.drain();

        // stop the line, a stopped line should cease I/O activity
        dataLine.stop();

        // closes the line, indicating that any system resources
        // in use by the line can be released.
        dataLine.close();

    }

}