import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestCanvas extends JPanel implements MouseListener
{
    int width;
    int height;
    public TestCanvas(int width, int height)
    {
        //super();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(this.width, this.height));
    }

    private void doDraw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(TestData.color);
        g2d.fillOval((int)(TestData.x - TestData.radius),
                (int)(TestData.y - TestData.radius),
                2 * TestData.radius,
                2 * TestData.radius);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDraw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        TestData.click_x = x;
        TestData.click_y = y;
        double temp_dx = x - TestData.x;
        double temp_dy = y - TestData.y;
        double temp_c = Math.sqrt(temp_dx * temp_dx + temp_dy * temp_dy);

        double k = temp_c / TestData.speed;

        TestData.dx = temp_dx / k;
        TestData.dy = temp_dy / k;

        System.out.println(TestData.dx + " " + TestData.dy);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
