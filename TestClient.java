import javax.swing.*;
import java.util.TimerTask;

public class TestClient extends JFrame
{
    TestCanvas canvas;
    java.util.Timer timer;

    public TestClient(int width, int height)
    {
        super();
        TestData.width = width;
        TestData.height = height;
        TestData.x = width / 2;
        TestData.y = height / 2;
        initUI();
        initAC();
    }

    private void initUI()
    {
        canvas = new TestCanvas(TestData.width, TestData.height);
        canvas.setDoubleBuffered(true);

        add(canvas);
        pack();
        setVisible(true);
        setTitle("TEST EXAMPLE GAME");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initAC()
    {
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {

            @Override
            public void run()
            {
                TestData.counter++;
                update();
                if (TestData.counter % TestData.repaint == 0)
                {
                    repaint();
                }
            }
        }, 0, 1);
        canvas.addMouseListener(canvas);
    }

    private void update()
    {
        boolean b1 = TestData.x + TestData.dx > 0;
        boolean b2 = TestData.x + TestData.dx < TestData.width;
        boolean b3 = TestData.y + TestData.dy > 0;
        boolean b4 = TestData.y + TestData.dy < TestData.height;

        if(b1 && b2 && b3 && b4)
        {
            if(Math.sqrt((TestData.click_x - TestData.x) * (TestData.click_x - TestData.x) + (TestData.click_y - TestData.y) * (TestData.click_y - TestData.y)) > TestData.delta)
            {
                TestData.x += TestData.dx;
                TestData.y += TestData.dy;
            }
        }
    }

    public static void main(String[] args)
    {
        TestClient client = new TestClient(1000, 1000);
    }
}
