
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class CustomPanel extends JPanel
{
    private final int SIZE = 10;
    private double xAxis;
    private double yAxis;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawLine(0, 410, 1500, 410);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(xAxis, yAxis, SIZE, SIZE));
    }
    
    public void setX(double xAxis)
    {
        this.xAxis = xAxis;
    }
    
    public void setY(double yAxis)
    {
        this.yAxis = yAxis;
    }
}
