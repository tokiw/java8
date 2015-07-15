package ex01_05;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

/**
 * Code Lines 100 (-11)
 */
@SuppressWarnings("serial")
public class DigitalWatchLamda extends Frame {
	private int h;
	private int m;
	private int s;
	private boolean watchRun = true;
	private Thread th;
	private Button startButton = new Button("start");
	private Button stopButton = new Button("stop");
	private boolean isStarted = true;
	private final int windowWidth = 640;
	private final int windowHeight = 400;
	private String str;
	

	public DigitalWatchLamda(final int width, final int height) {
		this.setLayout(new FlowLayout());
		this.setSize(width, height);
		startButton.addActionListener( (e) -> {
			isStarted = true;
			repaint();
		});
		stopButton.addActionListener( (e) -> {
			isStarted = false;
			repaint();
		});
		this.add(startButton);
		this.add(stopButton);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){   //×を押されたときの処理
				System.exit(0);
			}
		});
		th = new Thread( () -> {
			while(watchRun){
				h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //時を代入
				m = Calendar.getInstance().get(Calendar.MINUTE);      //分を代入
				s= Calendar.getInstance().get(Calendar.SECOND);       //秒を代入
				repaint();									//更新
				try{
					Thread.sleep(1000);  //スリープ１秒
				}catch(InterruptedException e){
				}
			}
		});
	}
	
	public void paint(Graphics g)
	{
		Dimension size = getSize();
		g.setFont(new Font("TimesRoman",Font.ITALIC, 1 * size.width / 10));
		FontMetrics fm = g.getFontMetrics();
		if (this.isStarted) {
			g.clearRect(0, 0, windowWidth - 1, windowHeight - 1);
			
		}
		if (this.isStarted) {
			if (m < 10 && s >= 10) {
				str = h+":0"+m+":"+s;
			} else if (m >= 10 && s < 10) {
				str = h+":"+m+":0"+s;
			}else if (m < 10 && s < 10) {
				str = h+":0"+m+":0"+s;
			} else {
				str = h+":"+m+":"+s;
			}
			g.drawString(str, (size.width - fm.stringWidth(str)) / 2 , (size.height + fm.getHeight()) / 2);
		} else {
			g.drawString(str, (size.width - fm.stringWidth(str)) / 2, (size.height + fm.getHeight()) / 2);
		}
	}
	
	private void start() {
		this.setVisible(true);
		th.start();
	}
	
	/* main */
	public static void main(String args[]){
		DigitalWatchLamda digitalWatch = new DigitalWatchLamda(640, 400);
		digitalWatch.start();
	}
}