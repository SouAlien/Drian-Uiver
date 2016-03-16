import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Scrollbar;


public class Htmlrender extends JFrame {

	private JPanel contentPane;
	public static JEditorPane editorPane;
	public static JTextPane textPane = new JTextPane();
	public static JLabel htmlRederizado = new JLabel();
	public static JLabel lblNewLabel = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Htmlrender frame = new Htmlrender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Htmlrender() {
		setTitle("Drian Uiver 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 564);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu_1 = new JMenu("File");
		menuBar.add(menu_1);
		
		JMenuItem menuSalvar = new JMenuItem("Salvar");
		//Acão do botão
		menuSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fc = new JFileChooser();  
				 String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo , não é nescessário a extensão!!").concat(".html");
                 // restringe a amostra a diretorios apenas  
                 fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  

                 int res = fc.showSaveDialog(null);  

                 if(res == JFileChooser.APPROVE_OPTION){  
                     File diretorio = fc.getSelectedFile();
                     Path caminho = Paths.get(diretorio.getPath().concat("/").concat(nomeArquivo));
                     try {
						Files.write(caminho, editorPane.getText().toString().getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                     JOptionPane.showMessageDialog(null, "Voce escolheu o diretório: " + caminho.toString());  
                 }  
                 else  
                     JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum diretorio.");  
             }  

				
			
		});
		menu_1.add(menuSalvar);
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String html= "<html>\n<head>\n<title>Titulo</title>\n</head><body><h2> <center> Pagina de Exemplo </center> </h2></body></html>";
		textPane.setVisible(false);
		textPane.setText(html);
		textPane.setEditable(false);
		
		
		editorPane = new JEditorPane();
		JScrollPane editor = new JScrollPane(editorPane);
		
		editor.setBounds(12, 293, 588, 165);
		editorPane.setText(html);
		contentPane.add(editor);
		
		lblNewLabel.setText(html);
		JScrollPane js = new JScrollPane(lblNewLabel);
		
		js.setBounds(184, 5, 338, 276);
		contentPane.add(js);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(editorPane.getText());
			}
		});
		btnAtualiza.setBounds(22, 458, 132, 25);
		contentPane.add(btnAtualiza);
		

		;
	}
}
