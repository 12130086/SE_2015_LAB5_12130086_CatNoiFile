package catnoifile;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

public class GiaoDien extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane jtp = new JTabbedPane();

	public GiaoDien() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ứng dụng Cắt Ghép File (CatNoi v0.1)");
		setSize(600, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		getContentPane().setLayout(null);

		jtp = new JTabbedPane(SwingConstants.TOP);
		jtp.setBounds(7, 7, 580, 457);
		jtp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(jtp);

		ImageIcon imageIconCatFile = new ImageIcon("images\\iconCatFile.png");
		jtp.addTab("Cắt File", imageIconCatFile, new CatFile());

		ImageIcon imageIconGhepFile = new ImageIcon("images\\iconGhepFile.png");
		jtp.addTab("Nối File", imageIconGhepFile, new NoiFile());
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		GiaoDien catGhepFile = new GiaoDien();
	}
}
