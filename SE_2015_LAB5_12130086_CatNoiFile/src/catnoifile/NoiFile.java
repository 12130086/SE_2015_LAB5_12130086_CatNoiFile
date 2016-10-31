package catnoifile;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class NoiFile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldChonFileNguon, textFieldChonFileDich;
	private JLabel labelNguon, labelDich;
	private JButton btnChonFileNguon, btnChonThuMuc, btnNoiFile;
	private JCheckBox checkboxXoaFileNguon;

	@SuppressWarnings("unused")
	public NoiFile() {
		/* GIAO DIEN */
		setSize(580, 430);
		setLayout(null);

		labelNguon = new JLabel("File nguồn (có phần mở rộng .001)");
		labelNguon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNguon.setBounds(10, 11, 220, 23);
		add(labelNguon);

		labelDich = new JLabel("Thư mục chứa File đích");
		labelDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDich.setBounds(10, 82, 150, 23);
		add(labelDich);

		textFieldChonFileNguon = new JTextField();
		textFieldChonFileNguon.setBounds(10, 42, 480, 25);
		add(textFieldChonFileNguon);
		textFieldChonFileNguon.setColumns(10);

		textFieldChonFileDich = new JTextField();
		textFieldChonFileDich.setColumns(10);
		textFieldChonFileDich.setBounds(10, 113, 480, 25);
		add(textFieldChonFileDich);

		btnChonFileNguon = new JButton();
		btnChonFileNguon.setBounds(500, 22, 60, 60);
		btnChonFileNguon.setIcon(new ImageIcon("images\\btnChonFile.png"));
		btnChonFileNguon.setContentAreaFilled(true);
		add(btnChonFileNguon);

		btnChonThuMuc = new JButton();
		btnChonThuMuc.setBounds(500, 95, 60, 60);
		btnChonThuMuc.setIcon(new ImageIcon("images\\btnChonThuMuc.png"));
		btnChonThuMuc.setContentAreaFilled(true);
		add(btnChonThuMuc);

		btnNoiFile = new JButton("Nối File");
		btnNoiFile.setBounds(468, 295, 92, 92);
		btnNoiFile.setIcon(new ImageIcon("images\\btnGhepFile.png"));
		btnNoiFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNoiFile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNoiFile.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNoiFile.setContentAreaFilled(true);
		add(btnNoiFile);

		final ButtonGroup group = new ButtonGroup();

		checkboxXoaFileNguon = new JCheckBox("Xóa các File nguồn sau khi nối");
		checkboxXoaFileNguon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxXoaFileNguon.setBounds(10, 153, 235, 23);
		add(checkboxXoaFileNguon);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 270, 552, 2);
		add(separator);

		JTextArea txtrNiCc = new JTextArea();
		txtrNiCc.setWrapStyleWord(true);
		txtrNiCc.setText(
				"Để nối các File .001, .002, ... từ một Folder, hãy nhập vào đường dẫn đến Folder hoặc chọn từ nút tương ứng và nhập vào đường dẫn tới nơi chứa File đích tạo thành hoặc chọn từ nút tương ứng. Sau đó hãy nhấn vào nút Cắt File để tiến hành. Ngoài ra bạn có thể xóa các File nguồn sau khi cắt bằng cách đánh dấu vào ô Check tương ứng.\r\n");
		txtrNiCc.setLineWrap(true);
		txtrNiCc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrNiCc.setEditable(false);
		txtrNiCc.setBackground(SystemColor.menu);
		txtrNiCc.setBounds(10, 295, 448, 124);
		add(txtrNiCc);

		/* XU LY SU KIEN */
		btnChonFileNguon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("*.001 files", "001");
				chooser.setFileFilter(filter);

				int returnValue = chooser.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textFieldChonFileNguon.setText(chooser.getSelectedFile().getAbsolutePath());

					String tempName = chooser.getSelectedFile().getAbsolutePath();
					int pos = tempName.lastIndexOf(".");
					if (pos > 0) {
						tempName = tempName.substring(0, pos);
					}
					textFieldChonFileDich.setText(tempName);
				}
			}
		});

		btnChonThuMuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textFieldChonFileDich.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});

		btnNoiFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldChonFileNguon.getText().equals("") && !textFieldChonFileDich.getText().equals("")) {
					File tempFile = new File(textFieldChonFileNguon.getText());
					String folder = tempFile.getParentFile().getAbsolutePath();
					String file = textFieldChonFileDich.getText();

					// FilenameFilter

					File source = new File(folder);
					if (!source.exists())
						;
					if (source.isDirectory()) {
						try {
							BufferedInputStream bis;
							BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
							File[] list = source.listFiles(/* FilenameFilter */);

							for (File item : list) {
								bis = new BufferedInputStream(new FileInputStream(item));
								int dataRead;
								byte[] buffer = new byte[1024];
								while ((dataRead = bis.read(buffer)) != -1) {
									bos.write(buffer, 0, dataRead);
								}
								bis.close();
								if (checkboxXoaFileNguon.isSelected() == true)
									item.delete();
							}
							bos.close();
							JOptionPane.showMessageDialog(null, "Đã nối File thành công", "Thông tin",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Form không được để trống, vui lòng kiểm tra lại",
							"Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
