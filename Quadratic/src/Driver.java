//    ██████╗ ██╗   ██╗ █████╗ ██████╗ ██████╗  █████╗ ████████╗██╗ ██████╗
//   ██╔═══██╗██║   ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝
//   ██║   ██║██║   ██║███████║██║  ██║██████╔╝███████║   ██║   ██║██║
//   ██║▄▄ ██║██║   ██║██╔══██║██║  ██║██╔══██╗██╔══██║   ██║   ██║██║
//   ╚██████╔╝╚██████╔╝██║  ██║██████╔╝██║  ██║██║  ██║   ██║   ██║╚██████╗
//    ╚══▀▀═╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝
//         Author: Lee Moriarity // Course: CIS111-B //  Date: 2/22/22

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.text.NumberFormatter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;

public class Driver {
    // declare global variables
    private JFrame frame;
    private JFormattedTextField textA, textB, textC;
    private JTextField textEq;
    private JTextArea textSol;
    private JTextPane textFrm;
    private JLabel labelEq;
    private JLabel labelWA;

    /**
     * Main Method
     */
    public static void main(String[] args) {
        Driver d = new Driver();
        d.GUI();
    }

    /**
     * GUI method
     */
    private void GUI() {
        JPanel content = new JPanel(null);

        /* Labels */
        // create label objects
        JLabel labelA = new JLabel();
        JLabel labelB = new JLabel();
        JLabel labelC = new JLabel();
        labelEq = new JLabel();
        JLabel labelFrm = new JLabel();
        JLabel labelSol = new JLabel();
        labelWA = new JLabel();
        JScrollPane scrollWA = new JScrollPane(labelWA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // set text of labels
        labelA.setText("Quadratic coefficient (a):");
        labelB.setText("Linear coefficient (b):");
        labelC.setText("Constant coefficient (c):");
        labelFrm.setText("Quadratic formula:");
        labelSol.setText("Solution:");
        // set bounds of labels
        labelA.setBounds(10, 10, 200, 20);
        labelB.setBounds(10, 50, 200, 20);
        labelC.setBounds(10, 90, 200, 20);
        labelEq.setBounds(10, 170, 200, 20);
        labelFrm.setBounds(10, 210, 200, 20);
        labelSol.setBounds(10, 473, 200, 20);
        scrollWA.setBounds(214, 10, 562, 598);
        labelWA.setBounds(214, 10, 562, 598);
        // add labels to content panel
        content.add(labelA);
        content.add(labelB);
        content.add(labelC);
        content.add(labelEq);
        content.add(labelFrm);
        content.add(labelSol);
        content.add(scrollWA);

        /* Text Fields */
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        format.setMaximumFractionDigits(10);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        // create text field objects
        textA = new JFormattedTextField(formatter);
        textB = new JFormattedTextField(formatter);
        textC = new JFormattedTextField(formatter);
        textEq = new JTextField();
        textFrm = new JTextPane();
        JPanel panelFrm = new JPanel(new BorderLayout());
        JScrollPane scrollFrm = new JScrollPane(panelFrm, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textSol = new JTextArea();
        JScrollPane scrollSol = new JScrollPane(textSol, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // set bounds of text fields
        textA.setBounds(7, 30, 200, 20);
        textB.setBounds(7, 70, 200, 20);
        textC.setBounds(7, 110, 200, 20);
        textEq.setBounds(7, 190, 200, 20);
        scrollFrm.setBounds(10,230,193,243);
        panelFrm.setBounds(10,230,900,243);
        textFrm.setBounds(10,230,900,243);
        scrollSol.setBounds(10,493,193,115);
        textSol.setBounds(10,493,193,115);
        // add text fields to content panel
        panelFrm.add(textFrm);
        content.add(textA);
        content.add(textB);
        content.add(textC);
        content.add(textEq);
        content.add(scrollSol);
        content.add(scrollFrm);
        // add HTML capabilities to formula text field
        StyledDocument doc = textFrm.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        textFrm.setContentType("text/html");

        /* Calculate button */
        JButton calc = new JButton();
        calc.setBounds(10, 140, 70, 20);
        calc.setText("Calculate");
        calc.addActionListener(e -> {
            try {
                submit();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        content.add(calc);

        /* Clear button */
        JButton clear = new JButton();
        clear.setBounds(90, 140, 60, 20);
        clear.setText("Clear");
        clear.addActionListener(e -> clear());
        content.add(clear);

        /* Frame */
        frame = new JFrame("Quadratic"); // new frame
        frame.setPreferredSize(new Dimension(212, 200)); // set dimensions
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allow exit on close
        frame.add(content); // add content panel
        frame.pack(); //sizes the frame
        frame.setLocationRelativeTo(null); // center application in middle of screen
        frame.setVisible(true); // set visible
    }

    /**
     * Submit Method to call Quadratic class and get Wolfram Alpha simple API image
     */
    public void submit() throws IOException {
        Quadratic quad = new Quadratic(Double.parseDouble(textA.getText()), Double.parseDouble(textB.getText()), Double.parseDouble(textC.getText()));
        String[] eq = quad.equation(); // get equation
        labelEq.setText(eq[0]); // set label of equation type
        textEq.setText(eq[1]); // set equation
        textFrm.setText(quad.formula()); // get and display text for formula
        textSol.setText(quad.solution()); // get and display text for solution

        // get Wolfram Alpha simple api image
        String URL;
        String query = URLEncoder.encode(eq[1], StandardCharsets.UTF_8);
        if (quad.getA() == 0 && quad.getB() == 0 && quad.getC() != 0)
            URL = "https://api.wolframalpha.com/v1/simple?appid=PXPX7H-UR2XYVE9GA&i=" + query;
        else
            URL = "https://api.wolframalpha.com/v1/simple?appid=PXPX7H-UR2XYVE9GA&i=quadratic%20equation%20" + query;
        BufferedImage image = ImageIO.read(new URL(URL));
        labelWA.setIcon(new ImageIcon(image));
        frame.setSize(new Dimension(775, 645)); // set dimensions
        frame.setLocationRelativeTo(null); // center application in middle of screen
    }

    /**
     * Clear Method to clear all text fields and reset frame size
     */
    public void clear() {
        // clear all text boxes
        textA.setText("");
        textB.setText("");
        textC.setText("");
        textEq.setText("");
        textFrm.setText("");
        textSol.setText("");
        // reset size of frame
        frame.setSize(new Dimension(212, 200)); // set dimensions
        frame.setLocationRelativeTo(null); // center application in middle of screen
    }
}