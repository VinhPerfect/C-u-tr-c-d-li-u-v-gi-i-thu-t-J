package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleGame extends JPanel implements ActionListener {
    private Timer timer;
    private Player player;
    private List<Enemy> enemies;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public SimpleGame() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        player = new Player();
        enemies = new ArrayList<>();
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        spawnEnemies();
        moveEnemies();
        checkCollisions();
        repaint();
    }

    private void spawnEnemies() {
        if (new Random().nextInt(20) == 0) {
            enemies.add(new Enemy(WIDTH, HEIGHT));
        }
    }

    private void moveEnemies() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.move();
            if (enemy.getY() > HEIGHT) {
                enemies.remove(i);
                i--;
            }
        }
    }

    private void checkCollisions() {
        Rectangle playerBounds = player.getBounds();
        for (Enemy enemy : enemies) {
            if (playerBounds.intersects(enemy.getBounds())) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Game");
        SimpleGame game = new SimpleGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class Player {
    private int x, y, dx;
    private final int SIZE = 50;

    public Player() {
        x = 375;
        y = 500;
    }

    public void move() {
        x += dx;
        if (x < 0) x = 0;
        if (x > 750) x = 750;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE);
    }
}

class Enemy {
    private int x, y;
    private final int SIZE = 20;
    private final int SPEED = 5;

    public Enemy(int width, int height) {
        x = new Random().nextInt(width - SIZE);
        y = 0;
    }

    public void move() {
        y += SPEED;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, SIZE, SIZE);
    }

    public int getY() {
        return y;
    }
}
