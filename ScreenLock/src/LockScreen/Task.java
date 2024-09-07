package LockScreen;

import javax.swing.JFrame;

public class Task {

    private JFrame jframe = null;

    public Task(JFrame f) {
        this.jframe = f;
    }

    public void SetBlock() {
        front();
    }

    public void front() {
        jframe.toFront();
    }

}
