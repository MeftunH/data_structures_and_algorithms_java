package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class BomberGame extends JPanel implements KeyListener {
        private static final long serialVersionUID=1L;
        private static final int WIDTH=800;
        private static final int HEIGHT=600;
        private static final int BLOCK_SIZE=50;
        private static final int PLAYER_SIZE=30;
        private static final int ENEMY_SIZE=20;
        private static final int BOMB_SIZE=30;
        private static final int SPEED=5;
        private static final int BOMB_SPEED=3;
        private static final int BOMB_TIME=1000;
        private int playerX, playerY, enemyX, enemyY, bombX, bombY, bombTimer;
        private ArrayList<Integer> bombs;
        private boolean bombPlaced;
        private Random random;

        public BomberGame() {
            JFrame frame=new JFrame("Bomber Game");
            frame.add(this);
            frame.addKeyListener(this);
            frame.setSize(WIDTH, HEIGHT);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            playerX=WIDTH/2-PLAYER_SIZE/2;
            playerY=HEIGHT/2-PLAYER_SIZE/2;
            enemyX=BLOCK_SIZE;
            enemyY=BLOCK_SIZE;
            bombX=-BOMB_SIZE;
            bombY=-BOMB_SIZE;
            bombTimer=0;
            bombs=new ArrayList<>();
            bombPlaced=false;
            random=new Random();
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.fillRect(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
            g.setColor(Color.RED);
            g.fillRect(enemyX, enemyY, ENEMY_SIZE, ENEMY_SIZE);
            for (int i=0; i<bombs.size(); i+=2) {
                g.setColor(Color.YELLOW);
                g.fillOval(bombs.get(i), bombs.get(i+1), BOMB_SIZE, BOMB_SIZE);
            }
        }
    public void update() {
        if (playerX < 0) {
            playerX = 0;
        }
        if (playerX + PLAYER_SIZE > WIDTH) {
            playerX = WIDTH - PLAYER_SIZE;
        }
        if (playerY < 0) {
            playerY = 0;
        }
        if (playerY + PLAYER_SIZE > HEIGHT) {
            playerY = HEIGHT - PLAYER_SIZE;
        }
        if (enemyX < playerX) {
            enemyX += SPEED;
        }
        if (enemyX > playerX) {
            enemyX -= SPEED;
        }
        if (enemyY < playerY) {
            enemyY += SPEED;
        }
        if (enemyY > playerY) {
            enemyY -= SPEED;
        }
        if (bombPlaced) {
            bombTimer++;
            if (bombTimer >= BOMB_TIME) {
                bombTimer = 0;
                bombs.add(bombX);
                bombs.add(bombY);
                bombPlaced = false;
            }
        }
        for (int i = 0; i < bombs.size(); i += 2) {
            int x = bombs.get(i);
            int y = bombs.get(i + 1);
            if (x + BOMB_SIZE > playerX && x < playerX + PLAYER_SIZE && y + BOMB_SIZE > playerY && y < playerY + PLAYER_SIZE) {
                // player is hit
                System.out.println("Player is hit!");
                bombs.remove(i);
                bombs.remove(i);
                break;
            }

            // check if bomb collides with enemy
            if (x + BOMB_SIZE > enemyX && x < enemyX + ENEMY_SIZE && y + BOMB_SIZE > enemyY && y < enemyY + ENEMY_SIZE) {
                // enemy is hit
                System.out.println("Enemy is hit!");
                bombs.remove(i);
                bombs.remove(i);
                // randomly move enemy to a new location
                int newEnemyX = random.nextInt(WIDTH - ENEMY_SIZE);
                int newEnemyY = random.nextInt(HEIGHT - ENEMY_SIZE);
                enemyX = newEnemyX;
                enemyY = newEnemyY;
                break;
            }

            // move bomb
            if (x < playerX) {
                x += BOMB_SPEED;
            } else if (x + BOMB_SIZE > playerX + PLAYER_SIZE) {
                x -= BOMB_SPEED;
            }
            if (y < playerY) {
                y += BOMB_SPEED;
            } else if (y + BOMB_SIZE > playerY + PLAYER_SIZE) {
                y -= BOMB_SPEED;
            }
            bombs.set(i, x);
            bombs.set(i + 1, y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
