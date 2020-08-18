import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import java.util.Scanner;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;
	private static Scanner user_input;
	private int price; 
	private int counter;
	private int selectionOpt;
	private int country;
	
	
	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();
		price = 0;
		country = 0;
		counter = 0;
		user_input = new Scanner(System.in);
		selectionOpt = 0;
		
		final int numEuropeDest		= 1;
		final int numUsaDest		= 3;
		final int numCostaRicaDest	= 1;
		
	
		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		// User selection preferences "price" or "country"
		System.out.print("Search by price or country \n"
				+ "1. PRICE\n"
				+ "2. United Kingdom\n"
				+ "3. United States\n"
				+ "4. Costa Rica\n");
		selectionOpt = user_input.nextInt();
		
		
		// Show option for query selection
		
		if (selectionOpt == 1) {
			
			getPricingOpt();
	
			//logic to add each of the slides and text]]]]]]]]]]]]]]]]]
			for (int i = 1; i <= counter; i++) {
				lblSlide = new JLabel();
				lblTextArea = new JLabel();
				lblSlide.setText(getResizeIcon(i));
				lblTextArea.setText(getTextDescription(i));
				slidePane.add(lblSlide, "card" + i);
				textPane.add(lblTextArea, "cardText" + i);
			}

		}
		
		else if (selectionOpt == 2) {
			
			for (int i = 1; i <= numEuropeDest; i++) {
				lblSlide = new JLabel();
				lblTextArea = new JLabel();
				lblSlide.setText(getResizeIcon2(i));
				lblTextArea.setText(getTextDescription2(i));
				slidePane.add(lblSlide, "card" + i);
				textPane.add(lblTextArea, "cardText" + i);
			}
			
		}
		
		else if (selectionOpt == 3) {
			
			for (int i = 1; i <= numUsaDest; i++) {
				lblSlide = new JLabel();
				lblTextArea = new JLabel();
				lblSlide.setText(getResizeIcon3(i));
				lblTextArea.setText(getTextDescription3(i));
				slidePane.add(lblSlide, "card" + i);
				textPane.add(lblTextArea, "cardText" + i);
			}
			
		}
		
		else if (selectionOpt == 4) {
			
			for (int i = 1; i <= numCostaRicaDest; i++) {
				lblSlide = new JLabel();
				lblTextArea = new JLabel();
				lblSlide.setText(getResizeIcon4(i));
				lblTextArea.setText(getTextDescription4(i));
				slidePane.add(lblSlide, "card" + i);
				textPane.add(lblTextArea, "cardText" + i);
			}
			
		}
				

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}
	

	/**
	 * Get pricing option for available destinations
	 */
	public int getPricingOpt() {
		System.out.print("Enter desired price: \n"
				+ "$500 \n"
				+ "$1000\n"
				+ "$1500\n"
				+ "$2000\n"
				+ "$2500\n"
				+ "$ ");
		
		price = user_input.nextInt();
		counter = price / 500;
		
		return counter;	
	}
	

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}
	
	
	/**
	 * Method to get the images when pricing option is selected
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/bath_england.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/bedford_springs.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/canyon_ranch.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/red_rock.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/costa_rica.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the images for Europe
	 */
	private String getResizeIcon2(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/bath_england.jpg") + "'</body></html>";
		}

		return image;
	}
	
	/**
	 * Method to get the images for destination in the United States
	 */
	private String getResizeIcon3(int i) {
		String image = ""; 
		 if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/bedford_springs.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/canyon_ranch.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/red_rock.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the images for destination in Costa Rica
	 */
	private String getResizeIcon4(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/costa_rica.jpg") + "'</body></html>";
		}
		return image;
	}

	
	/**
	 * Method to get the text values. Description includes author of photos provided in slideshow
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		
		if (i==1){
			text = "<html><body><font size='4'>$500 Bath, England.</font> <br>European spas will rejuvinate your body."
					+ "</font> <br>By Diego Delso, https://commons.wikimedia.org/w/index.php?curid=35323216</body></html>";
		} else if (i==2){
			text = "<html><body><font size='4'>$1000 Bedford Springs.</font> <br>A relaxing getaway that will restore you."
					+ "</font> <br>By Adam W. Ritchey, https://commons.wikimedia.org/w/index.php?curid=73215355\r\n" + 
					"</body></html>";
		} else if (i==3){
			text = "<html><body><font size='4'>$1500 Canyon Ranch.</font> <br> Enjoy the relaxing Tucson sun and views."
					+ "</font> <br>By Erik Wilde, https://commons.wikimedia.org/w/index.php?curid=71047671</body></html>";
		} else if (i==4){
			text = "<html><body><font size='4'>$2000 Red Rock.</font> <br> Beautiful scenery and hiking for all skill levels."
					+ "</font> <br>By Serge Melki, https://commons.wikimedia.org/w/index.php?curid=24321686</body></html>";
		} else if (i==5){
			text = "<html><body><font size='4'>$2500 Costa Rica.<font> <br>Lush forest, gardens and views second to none."
					+ "</font> <br>By Lars0001, https://commons.wikimedia.org/w/index.php?curid=3659600</body></html>";
		}
		return text;
	}
	
	/**
	 * Method to get the text values of European destinations. Description includes author of photos privided in slideshow
	 */
	private String getTextDescription2(int i) {
		String text = ""; 
		
		if (i==1){
			text = "<html><body><font size='4'>$500 Bath, England.</font> <br>European spas will rejuvinate your body."
					+ "</font> <br>By Diego Delso, https://commons.wikimedia.org/w/index.php?curid=35323216</body></html>";
		} 
		return text;
	}
	
	/**
	 * Method to get the text values. Description includes author of photos provided in slideshow.
	 */
	private String getTextDescription3(int i) {
		String text = ""; 
		
		if (i==1){
					+ "</font> <br>By Adam W. Ritchey, https://commons.wikimedia.org/w/index.php?curid=73215355\r\n" + 
					"</body></html>";
		} else if (i==2){
			text = "<html><body><font size='4'>$1500 Canyon Ranch.</font> <br> Enjoy the relaxing Tucson sun and views."
					+ "</font> <br>By Erik Wilde, https://commons.wikimedia.org/w/index.php?curid=71047671</body></html>";
		} else if (i==3){
			text = "<html><body><font size='4'>$2000 Red Rock.</font> <br> Beautiful scenery and hiking for all skill levels."
					+ "</font> <br>By Serge Melki, https://commons.wikimedia.org/w/index.php?curid=24321686</body></html>";
		}
		return text;
	}
	
	/**
	 * Method to get the text values. Description includes author of phots provided in slideshow.
	 */
	private String getTextDescription4(int i) {
		String text = ""; 
		
		if (i==1){
			text = "<html><body><font size='4'>$2500 Costa Rica.<font> <br>Lush forest, gardens and views second to none."
					+ "</font> <br>By Lars0001, https://commons.wikimedia.org/w/index.php?curid=3659600</body></html>";
		}
		return text;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			

			@Override
			public void run() {
								
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}