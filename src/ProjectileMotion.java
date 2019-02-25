import java.util.Scanner;

public class ProjectileMotion
{
    private double velocity;
    private double angle;
    private double displacement;
    
    public ProjectileMotion()
    {
        velocity = 0.0;
        angle = 0.0;
        displacement = 0.0;
    }
    
    public void compute(double velocity, double angle)
    {
        this.velocity = velocity;
        this.angle = angle;
        
        displacement = (Math.pow(velocity, 2) * Math.sin(Math.toRadians(angle * 2))) / 9.8;
    }
    
    public double computeY(double x)
    {
        double a = x * Math.tan(Math.toRadians(angle));
        double b = 9.8 * Math.pow(x, 2);
        double c = 2 * Math.pow((velocity * Math.cos(Math.toRadians(angle))), 2);
        
        return a - (b / c);
    }
    
    public double getDisplacement()
    {
        return displacement;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ProjectileMotion projectile = new ProjectileMotion();
        projectile.compute(100.0, 89);
        
        while (true)
        {
            System.out.print("x: ");
            double x = sc.nextDouble();
            System.out.println("y: " + projectile.computeY(x) + "\n");
        }
    }
}