
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Main
{
    private JFrame frame;
    private JButton button;
    private JTextField field1;
    private JTextField field2;
    private CustomPanel panel;
    private Timer timer;
    private ProjectileMotion projectile;
    private double xAxis;
    
    public Main()
    {
        projectile = new ProjectileMotion();
        
        button = new JButton("Go!");
        button.setBounds(30, 470, 100, 20);
        button.addActionListener((e)->{
            
            projectile.compute(Double.parseDouble(field1.getText()), Double.parseDouble(field2.getText()));
            
            xAxis = 0.0;
            
            timer = new Timer(1, (evt)->{
                panel.setX(xAxis);
                panel.setY(400 - projectile.computeY(xAxis));
                panel.repaint();

                System.out.println("X: " + xAxis + "\tY: " + (400 - projectile.computeY(xAxis)));

                if (xAxis >= projectile.getDisplacement())
                {
                    timer.stop();
                }
                else
                {
                    //xAxis += 0.01;
                    xAxis += (Double.parseDouble(field2.getText()) > 85) ? 0.01 : 0.1;
                }
            });
           
            timer.start();
        });
        
        field1 = new JTextField();
        field1.setBounds(30, 420, 100, 20);
        field2 = new JTextField();
        field2.setBounds(30, 445, 100, 20);
        
        panel = new CustomPanel();
        panel.setPreferredSize(new Dimension(1500, 500));
        panel.setLayout(null);
        panel.add(button);
        panel.add(field1);
        panel.add(field2);
        
        frame = new JFrame("Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }
    
    public static void main(String[] args)
    {
        Main main = new Main();
    }
}
