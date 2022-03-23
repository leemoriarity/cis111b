import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class comparableDriver {
    public static void main(String[] args) {
        Random rand = new Random(); // generate random number
        Note note1 = new Note((rand.nextInt(36)+48), rand.nextInt(120)+1, rand.nextInt(6000)+1); // create note 1
        Note note2 = new Note((rand.nextInt(36)+48), rand.nextInt(120)+1, rand.nextInt(6000)+1); // create note 2
        Note note3 = new Note((rand.nextInt(36)+48), rand.nextInt(120)+1, rand.nextInt(6000)+1); // create note 3

        System.out.println("note1 (" + note1.getKey() + ") equals note2 (" + note2.getKey() + "): " + note1.compareTo(note2)); // compare note 1 to note 2
        System.out.println("note2 (" + note2.getKey() + ") equals note3 (" + note3.getKey() + "): " + note2.compareTo(note3)); // compare note 2 to note 3
        System.out.println("note3 (" + note3.getKey() + ") equals note1 (" + note1.getKey() + "): " + note3.compareTo(note1) + "\n"); // compare note 3 to note 1

        List<Note> noteList = new ArrayList<>(); // create new Note list
        noteList.add(note1); // add note 1 to note list
        noteList.add(note2); // add note 2 to note list
        noteList.add(note3); // add note 3 to note list
        Collections.sort(noteList); // sort list by note frequency using Collections class and compareTo method
        for (Note note : noteList) { // for each note in list
            System.out.println(note + "\n"); // print note
        }

        Note sortedNoteList = new Note(); // create new sorted note list
        System.out.println(sortedNoteList.sortNotes(noteList)); // print note list sorted by length of note then by frequency
    }
}