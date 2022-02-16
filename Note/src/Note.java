//          ;;;;;;;;;;;;;;;;;;;;;;;;;
//          ;;;;;;;;;;;;;;;;;;;;;;;;;
//          ;                       ;
//          ; Title:  Note Class    ;
//          ; Author: Lee Moriarity ;
//          ; Course: CIS111-B      ;
//          ; Date:   02/12/22      ;
//     ,;;;;;                  ,;;;;;
//     ;;;;;;                  ;;;;;;
//     `;;;;'                  `;;;;'

import java.lang.Math;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Note Class
 */
public class Note {
    private Map<Integer,String> piano = new LinkedHashMap<>();
    private int key, midi; // key value & midi note value
    private String note, length, keyType; // musical note (ex: A1), length of note (ex: whole note), & key type (ex: sharp)
    private double frequency, bpm; // frequency of note $ beats per minute

    /**
     * Default Note Constructor with no parameters
     */
    public Note() {
        setNote(0);  // set default note to A2
        setMidiNote(69); // A2 Midi note
        setKey(0); // key value 0 (A2)
        setBPM(60); // set default bpm to 60
        setLength(60,1000); // set length to quarter note
        setFreq(0); // set frequency of A2
        setKeyType("A2"); // set key type of A2
    }

    /**
     * @param key key value of pressed key
     * @param bpm value of beats per minute set by user
     * @param ms duration of key press in milliseconds
     */
    public Note(int key, double bpm, long ms ) {
        setNote(key);
        setMidiNote(key+69);
        setKey(key-69);
        setBPM(bpm);
        setLength(bpm,ms);
        setFreq(key-69);
        setKeyType(note);
    }

    /**
     * Set Methods
     * @param key key value of pressed key
     */
    public void setNote(int key) {
        // add key numbers and values sequence to LinkedHashMap
        piano.put(1,"C");
        piano.put(2,"C#Db");
        piano.put(3,"D");
        piano.put(4,"D#Eb");
        piano.put(5,"E");
        piano.put(6,"F");
        piano.put(7,"F#Gb");
        piano.put(8,"G");
        piano.put(9,"G#Ab");
        piano.put(10,"A");
        piano.put(11,"A#Bb");
        piano.put(12,"B");
        int n = key; // get original key value
        if (key > 12) // if key is greater than 12
            key = key%12 + 1; // find key by using key mod 12 + 1
        note = piano.get(key) + (n/12 - 3); // get key and octave
    }

    public void setMidiNote(int key) { midi = key - 69; }
    public void setKey(int key) { this.key = key; }
    public void setBPM(double bpm) { this.bpm = bpm; }
    public void setLength(double bpm, long ms) {
        long bpm2ms = 60000 / (long)bpm; // get quarter note value in milliseconds for specified bpm
        if (ms <= bpm2ms / 64) // if note is less than or equal to Five hundred twelfth note
            length = "Five hundred twelfth note (" + ms + "ms) goal: "+ bpm2ms / 128 + "ms"; // define length and milliseconds including official note length
        else if (ms >= bpm2ms / 64 && ms < bpm2ms / 32) // if length is greater than or equal to 1/256 note amd less than 1/128 note
            length = "Two hundred fifty-sixth note (" + ms + "ms) goal: "+ bpm2ms / 64 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms / 32 && ms < bpm2ms / 16) // if length is greater than or equal to 1/128 note amd less than 1/64 note
            length = "Hundred twenty-eighth note (" + ms + "ms) goal: "+ bpm2ms / 32 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms / 16 && ms < bpm2ms / 8) // if length is greater than or equal to 1/64 note amd less than 1/32 note
            length = "Sixty-fourth note (" + ms + "ms) goal: "+ bpm2ms / 16 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms / 8 && ms < bpm2ms / 4) // if length is greater than or equal to 1/32 note amd less than 1/16 note
           length = "Thirty-second note (" + ms + "ms) goal: "+ bpm2ms / 8 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms / 4 && ms < bpm2ms / 2) // if length is greater than or equal to 1/16 note amd less than 1/8 note
            length = "Sixteenth note (" + ms + "ms) goal: "+ bpm2ms / 4 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms /2 && ms < bpm2ms) // if length is greater than or equal to 1/8 note amd less than 1/4 note
            length = "Eighth note (" + ms + "ms) goal: "+ bpm2ms / 2 + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms && ms < bpm2ms * 2) // if length is greater than or equal to 1/4 note amd less than 1/2 note
            length = "Quarter note (" + ms + "ms) goal: "+ bpm2ms + "ms";// define length and milliseconds including official note length
        else if (ms >= bpm2ms * 2 && ms < bpm2ms * 4)// if length is greater than or equal to 1/2 note amd less than whole note
            length = "Half note (" + ms + "ms) goal: "+ bpm2ms * 2 + "ms";// define length and milliseconds including official note length
        else // if length is greater than or equal to whole note
            length = "Whole note (" + ms + "ms) goal: "+ bpm2ms * 4 + "ms";// define length and milliseconds including official note length
    }
    public void setFreq(int n) { frequency = 440 * Math.pow(2,n/12F); } // calculate frequency
    public void setKeyType(String note) {
        if (note.contains("#")) //if key is black
            keyType = "Sharp"; // key type is sharp
        else // if key is white
            keyType = "Normal"; // key type is normal
    }

    /**
     * Get Methods
     */
    public String getNote() {  return note; } // @return note of key
    public int getMidiNote() {  return midi; } // @return midi note
    public int getKey() { return key; } // @return key value
    public int getBPM() { return (int)bpm; } // @return bpm as int
    public String getLength() { return length; } // @return length of note
    public String getFreq() { return String.format("%.2f",frequency) + "Hz"; } // @return frequency formatted to 2 decimal places
    public String getKeyType() { return keyType; } // @return key type

    /**
     * toString Method
     * @return all information about the key pressed by user
     */
    public String toString() {

        return "Note: " + getNote() +
                "\nMidi note: " + getMidiNote() +
                "\nKey value: " + getKey() +
                "\nKey number: " + (getKey()+22) +
                "\nBPM: " + getBPM() +
                "\nLength: " + getLength() +
                "\nFrequency: " + getFreq() +
                "\nKey type: " + getKeyType();
    }
}