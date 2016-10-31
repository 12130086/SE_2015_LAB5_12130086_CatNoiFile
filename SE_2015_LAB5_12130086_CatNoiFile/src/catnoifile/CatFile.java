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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class CatFile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldChonFile, textFieldThuMucDich;
	private JLabel labelNguon, labelDich;
	private JButton btnChonFileDich, btnChonThuMuc, btnCatFile;
	private JRadioButton rdbCatTheoSoLuong, rdbCatTheoDungLuong;
	private JSpinner spinnerSoLuong, spinnerDungLuong;
	@SuppressWarnings("rawtypes")
	private JComboBox comboboxDonViDungLuong;
	private JCheckBox checkboxXoaFileNguon;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CatFile() {
		/* GIAO DIEN */
		setSize(580, 430);
		setLayout(null);

		labelNguon = new JLabel("File nguồn");
		labelNguon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNguon.setBounds(10, 11, 90, 23);
		add(labelNguon);

		labelDich = new JLabel("Thư mục chứa các File đích");
		labelDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDich.setBounds(10, 82, 170, 23);
		add(labelDich);

		JLabel labelThuMucRa = new JLabel("File có dung lượng bằng nhau");
		labelThuMucRa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelThuMucRa.setBounds(252, 160, 238, 23);
		add(labelThuMucRa);

		textFieldChonFile = new JTextField();
		textFieldChonFile.setBounds(10, 42, 480, 25);
		add(textFieldChonFile);
		textFieldChonFile.setColumns(10);

		textFieldThuMucDich = new JTextField();
		textFieldThuMucDich.setColumns(10);
		textFieldThuMucDich.setBounds(10, 113, 480, 25);
		add(textFieldThuMucDich);

		btnChonFileDich = new JButton();
		btnChonFileDich.setBounds(500, 22, 60, 60);
		btnChonFileDich.setIcon(new ImageIcon("images\\btnChonFile.png"));
		// btnChonFileDich.setContentAreaFilled(false);
		add(btnChonFileDich);

		btnChonThuMuc = new JButton();
		btnChonThuMuc.setBounds(500, 95, 60, 60);
		btnChonThuMuc.setIcon(new ImageIcon("images\\btnChonThuMuc.png"));
		// btnChonThuMuc.setContentAreaFilled(false);
		add(btnChonThuMuc);

		btnCatFile = new JButton("Cắt File");
		btnCatFile.setBounds(468, 295, 92, 92);
		btnCatFile.setIcon(new ImageIcon("images\\btnCatFile.png"));
		btnCatFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCatFile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCatFile.setHorizontalTextPosition(SwingConstants.CENTER);
		// btnCatFile.setContentAreaFilled(false);
		add(btnCatFile);

		rdbCatTheoSoLuong = new JRadioButton("Cắt thành");
		rdbCatTheoSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbCatTheoSoLuong.setBounds(10, 160, 109, 23);
		add(rdbCatTheoSoLuong);

		rdbCatTheoDungLuong = new JRadioButton(
				"Cắt thành các File có dung lượng");
		rdbCatTheoDungLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbCatTheoDungLuong.setBounds(10, 200, 235, 23);
		add(rdbCatTheoDungLuong);

		final ButtonGroup group = new ButtonGroup();
		group.add(rdbCatTheoSoLuong);
		group.add(rdbCatTheoDungLuong);

		spinnerDungLuong = new JSpinner();
		spinnerDungLuong.setModel(new SpinnerNumberModel(new Double(0),
				new Double(0), null, new Double(1)));
		spinnerDungLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerDungLuong.setBounds(252, 201, 208, 25);
		add(spinnerDungLuong);

		spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerSoLuong.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinnerSoLuong.setBounds(125, 161, 109, 25);
		add(spinnerSoLuong);

		comboboxDonViDungLuong = new JComboBox();
		comboboxDonViDungLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboboxDonViDungLuong.setModel(new DefaultComboBoxModel(new String[] {
				"Bytes", "Kilo bytes", "Mega bytes", "Giga bytes" }));
		comboboxDonViDungLuong.setBounds(470, 201, 90, 25);
		add(comboboxDonViDungLuong);

		checkboxXoaFileNguon = new JCheckBox("Xóa File nguồn sau khi cắt");
		checkboxXoaFileNguon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxXoaFileNguon.setBounds(10, 240, 235, 23);
		add(checkboxXoaFileNguon);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 270, 552, 2);
		add(separator);

		JTextArea text = new JTextArea();
		text.setBackground(UIManager.getColor("Button.background"));
		text.setText("Để cắt một File, hãy nhập vào đường dẫn đến File hoặc chọn từ nút tương ứng và nhập vào đường dẫn tới nơi chứa các File đích hoặc chọn từ nút tương ứng. Sau đó hãy chọn cách cắt File mong muốn theo những lựa chọn đã có và nhấn vào nút Cắt File để tiến hành. Ngoài ra bạn có thể xóa File nguồn sau khi cắt bằng cách đánh dấu vào ô Check tương ứng.\r\n");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text.setEditable(false);
		text.setBounds(10, 295, 448, 124);
		add(text);

		/* XU LY SU KIEN */
		btnChonFileDich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnValue = chooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textFieldChonFile.setText(chooser.getSelectedFile()
							.getAbsolutePath());
					textFieldThuMucDich.setText(chooser.getSelectedFile()
							.getParentFile().getAbsolutePath());
				}

			}
		});

		btnChonThuMuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				int returnValue = chooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textFieldThuMucDich.setText(chooser.getSelectedFile()
							.getAbsolutePath());
				}

			}
		});

		btnCatFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldChonFile.getText().equals("")
						&& !textFieldThuMucDich.getText().equals("")) {
					if (rdbCatTheoSoLuong.isSelected() == true)
						try {
							String file = textFieldChonFile.getText();
							String folder = textFieldThuMucDich.getText();
							int numPart = Integer.parseInt(spinnerSoLuong
									.getValue().toString());
							File f = new File(file);
							File d = new File(folder);
							if (!f.exists())
								; //
							if (f.isFile()) {
								if (!d.exists())
									d.mkdirs();
								BufferedInputStream bis = null;
								bis = new BufferedInputStream(
										new FileInputStream(f));
								BufferedOutputStream bos = null;
								long partSize = f.length() / numPart;

								for (int i = 1; i <= numPart; i++) {
									String numPartFormat = null;
									if (i < 10)
										numPartFormat = "00";
									else if (i < 100)
										numPartFormat = "0";
									else if (i < 1000)
										numPartFormat = "";
									bos = new BufferedOutputStream(
											new FileOutputStream(folder + "\\"
													+ f.getName() + "."
													+ numPartFormat + i));
									int dataRead = 0;
									byte[] buffer;
									int byteReaded = 0;
									while (true) {
										int byteMustRead = ((partSize - byteReaded) > 1024 ? 1024
												: (int) (partSize - byteReaded));
										if (byteMustRead == 0)
											break;
										buffer = new byte[byteMustRead];
										dataRead = bis.read(buffer);
										byteReaded += dataRead;
										bos.write(buffer, 0, dataRead);
									}
									bos.flush();
									bos.close();
								}
								bis.close();
								if (checkboxXoaFileNguon.isSelected() == true)
									f.delete();
								JOptionPane.showMessageDialog(null,
										"Đã cắt File thành công", "Thông tin",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (IOException e) {
							e.printStackTrace();
						} // Cat File theo so luong
					else {
						try {
							String file = textFieldChonFile.getText();
							String folder = textFieldThuMucDich.getText();
							double partSize = (double) spinnerDungLuong
									.getValue();

							if (comboboxDonViDungLuong.getSelectedItem()
									.toString() == "Bytes")
								;
							else if (comboboxDonViDungLuong.getSelectedItem()
									.toString() == "Kilo bytes")
								partSize = partSize * 1024;
							else if (comboboxDonViDungLuong.getSelectedItem()
									.toString() == "Mega bytes")
								partSize = partSize * 1024 * 1024;
							else if (comboboxDonViDungLuong.getSelectedItem()
									.toString() == "Giga bytes")
								partSize = partSize * 1024 * 1024 * 1024;

							File f = new File(file);
							BufferedInputStream bis = new BufferedInputStream(
									new FileInputStream(f));
							BufferedOutputStream bos = null;
							int dataRead = 0;
							byte[] buffer = new byte[1024];
							int byteRead = 0;
							int i = 1;
							bos = new BufferedOutputStream(
									new FileOutputStream(new File(folder + "\\"
											+ f.getName() + ".001")));
							while ((dataRead = bis.read(buffer)) != -1) {
								if (byteRead == partSize) {
									i++;
									String numPartFormat = null;
									if (i < 10)
										numPartFormat = "00";
									else if (i < 100)
										numPartFormat = "0";
									else if (i < 1000)
										numPartFormat = "";
									bos = new BufferedOutputStream(
											new FileOutputStream(
													new File(folder + "\\"
															+ f.getName() + "."
															+ numPartFormat + i)));
									byteRead = 0;
								}
								bos.write(buffer, 0, dataRead);
								byteRead += dataRead;
								buffer = new byte[(int) (partSize - byteRead > 1024 ? 1024
										: partSize - byteRead)];
							}
							bos.flush();
							bos.close();
							bis.close();
							JOptionPane.showMessageDialog(null,
									"Đã cắt File thành công", "Thông tin",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Form không được để trống, vui lòng kiểm tra lại",
							"Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
