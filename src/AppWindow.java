import java . awt . * ;
import java.awt . event . * ;
import java.util.Random;

public class AppWindow extends Frame {

    public AppWindow() {
        addWindowListener(new MyWindowAdapter());
    }

    public static void main(String args[]) {
        AppWindow appwin = new AppWindow();
        appwin.setSize(new Dimension(300, 200));
        appwin.setTitle("An AWT-Based Application ");

        Button button = new Button("Click Here");
        int w = 60;
        int h = 30;
        button.setBounds(50, 100, w, h);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("is clicked");
            }
        });
        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = rangeRand(0, appwin.getBounds().width);
                if(x < 30) {
                    x = x + 30;
                }
                if(x > appwin.getBounds().width - 100) {
                    x = x - 100;
                }
                int y = rangeRand(0, appwin.getBounds().height);
                if(y < 45) {
                    y = y + 45;
                }
                if(y > appwin.getBounds().height - 30) {
                    y = y - 30;
                }
                button.setBounds(x, y, w, h);
            }
        });
        appwin.setLayout(null);
        appwin.add(button);
        appwin.setVisible(true);
    }

    private static int rangeRand(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
