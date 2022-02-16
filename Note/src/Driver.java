//          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
//          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
//          ;                           ;
//          ; Title:  Note Class Driver ;
//          ; Author: Lee Moriarity     ;
//          ; Course: CIS111-B          ;
//          ; Date:   02/12/22          ;
//     ,;;;;;                      ,;;;;;
//     ;;;;;;                      ;;;;;;
//     `;;;;'                      `;;;;'
//
// Credit: https://stackoverflow.com/questions/29314733/how-to-create-a-piano-using-jscrollpane-and-jlayeredpane

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Note Class Driver
 */
public class Driver implements MouseListener {

    private final BlackKey[] black = new BlackKey[15]; // Declare array with number of black keys
    private final WhiteKey[] white = new WhiteKey[22]; // Declare array with number of white keys
    private MidiChannel channel; // declare midi channel
    private final ArrayList<String> chan = new ArrayList<>(); // array list to hold all instruments
    private long timestamp; // global variable timestamp to access when mouse released
    private JSpinner bpm;  // global variable bpm to pass variable when mouse released
    private int vol; //

    /**
     * Main Method
     */
    public static void main(String[] args) {
        Driver d = new Driver(); // Create new object to load non-static method from main
        d.GUI(); // Start GUI
    }

    /**
     * Driver Constructor
     */
    private Driver() {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer(); // declare new midi synthesizer
            synth.open(); // open synthesizer
            synth.loadAllInstruments(synth.getDefaultSoundbank()); // load all instruments
            Instrument[] instrument = synth.getLoadedInstruments(); //get synthesizer loaded instruments
            MidiChannel[] channels = synth.getChannels(); // get set of channels controlled by synthesizer
            for (MidiChannel midiChannel : channels) { // for each channel in synthesizer
                if (midiChannel != null) { // of channel is not empty
                    channel = midiChannel; // add channel to MidiChannel
                    break;
                }
            }
            channel.programChange(0); // set default channel to piano
            for (Instrument value : instrument) { // for each instrument in synthesizer
                chan.add(value.toString()); // add to array list chan
            }
        } catch (MidiUnavailableException ex) { // catch midi unavailable exception error
            ex.printStackTrace (); // print error details
        }
    }

    public void mousePressed(MouseEvent e) {
        Key key = (Key)e.getSource(); // get object of event
        channel.noteOn(key.getNote(), vol); // start midi note
        timestamp = System.currentTimeMillis(); // get current time that note starts
    }
    public void mouseReleased(MouseEvent e){
        Key key = (Key)e.getSource(); // get object of event
        channel.noteOff(key.getNote()); // turn off midi note
        var timestamp2 = System.currentTimeMillis(); // get current time that note ends
        long ms = timestamp2 - timestamp; // calculate total milliseconds of note length
        Note keyboard = new Note((key.getNote()), Double.parseDouble(bpm.getValue().toString()), ms); // call Note Constructor
        System.out.println("-------------------------------------------------"); // line divider
        System.out.println(keyboard); // Note.toString()
    }
    //add required mouse listener methods
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    /**
     * GUI method for midi keyboard
     */
    private void GUI() {
        JPanel contentPane = new JPanel(null) {
            // Allows black keys to stay on top of white keys
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
            // Add background image so volume bar is visible on black background
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    g.drawImage(ImageIO.read(new File("bg.png")), 0, 0, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        contentPane.setBackground(Color.BLACK); // set content panel background color to black

        // Add piano keys
        for (int i = 0; i < white.length; i++) { // for each white key
            white[i] = new WhiteKey(i); // call WhiteKey method
            contentPane.add(white[i]); // add white key
            white[i].addMouseListener(this); // add mouse listener
            contentPane.setComponentZOrder(white[i], 0); // set z order
        }
        for (int i = 0; i < black.length; i++) { // for each black key
            black[i] = new BlackKey(i); // call BlackKey method
            contentPane.add(black[i]); // add black key
            black[i].addMouseListener(this); // add mouse listener
            contentPane.setComponentZOrder(black[i], 1); // set z order
        }

        //Volume JSlider
        JSlider slider = new JSlider(); // create new JSlider for midi velocity volume
        slider.addChangeListener(e -> vol = slider.getValue()); // get velocity value when slider changes
        slider.setBounds(440,4,100,20); // set size of jslider
        slider.setMinimum(0); // minimum velocity value
        slider.setMaximum(127); // maximum velocity value
        slider.setValue(127); // default value
        contentPane.add(slider); // add slider to content panel

        //BPM JSpinner
        SpinnerModel model = new SpinnerNumberModel(60, 1, 999, 1); // create spinner number model from 1-999
        bpm = new JSpinner(model); // make new JSpinner using Spinner Number Model
        bpm.setBounds(35,4,60,20); // set size of combo box
        bpm.getEditor().getComponent(0).setBackground(Color.black); // set background color to black
        bpm.getEditor().getComponent(0).setForeground(Color.white); // set text color to white
        contentPane.add(bpm); // add bpm spinner to content panel
        JLabel lbl = new JLabel("BPM:"); // add bpm label
        lbl.setBounds(10,4,30,20); // set size of label
        lbl.setForeground(Color.white); // set text color to white
        contentPane.add(lbl); // add label to content panel

        //Instrument JComboBox
        JComboBox<Object> inst = new JComboBox<>(chan.toArray()); // new combo box holding all instruments
        inst.setBounds(130,5,300,20); // set size of combo box
        contentPane.add(inst); // add box to content panel
        inst.addActionListener(e -> channel.programChange(inst.getSelectedIndex())); // change instrument when selected

        //Frame
        JFrame frame = new JFrame("Keyboard"); // new frame
        frame.setPreferredSize(new Dimension(545, 160)); // set dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allow exit on close
        frame.setResizable(false); // set unresizable
        frame.add(contentPane); // add content panel
        frame.pack(); //sizes the frame
        frame.setLocationRelativeTo(null); // center application in middle of screen
        frame.setVisible(true); // set visible
    }
}

/**
 * Key interface for mouse listener
 */
interface Key {
 int getNote(); // get note from BlackKey or WhiteKey getNote method
}

/**
 * Class to add the individual black keys with correct layout
 */
class BlackKey extends JButton implements Key {
    final int note;
    public BlackKey(int pos) {
        note = 48 + 1 + 2 * pos + (pos + 3) / 5 + pos / 5; // get midi value of note
        int left = 24 + ((16 * 3) / 2) * (pos + (pos / 5) + ((pos + 3) / 5)); // set key position
        setBounds(left, 30, 15, 50); // set size of key
        setIcon(new ImageIcon("black-key.png")); // set background image of black keys
    }
    public int getNote () { // getNote method
        return note; // @return midi note
    }
}

/**
 * Class to add the individual white keys with correct layout
 */
class WhiteKey extends JButton implements Key {
    final int note; // @return midi note
    public WhiteKey(int pos) {
        note = 48 + 2 * pos - (pos + 4) / 7 - pos / 7; // get midi value of note
        int left = 5 + 24 * pos;// set key position
        setBounds((left + 4), 30, 23, 100); /// set size of key
        setIcon(new ImageIcon("white-key.png")); // set background image of white keys
    }
    public int getNote () { // getNote method
        return note; // @return midi note
    }
}