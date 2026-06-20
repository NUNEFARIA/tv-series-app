package view;

import controller.SeriesController;
import model.entities.Serie;

import javax.swing.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private final SeriesController controller;

    private JTextField searchField;
    private JButton searchButton;
    private JButton favoriteButton;
    private JButton watchedButton;
    private JButton wantToWatchButton;
    private DefaultListModel<Serie> resultsModel;
    private JList<Serie> resultsList;
    private JScrollPane resultsScrollPane;
    private JPanel searchPanel;
    private JPanel actionsPanel;
    private JTabbedPane tabbedPane;

    public MainFrame() throws IOException {

        this.controller = new SeriesController();

        this.initializeComponents();

        addTopPanel();

        addResultList();

        addActionButtons();

        addTabs();

        assembleLayout();

        setVisible(true);
    }

    private void initializeComponents() {

        setTitle("TV Series APP");

        setSize(1000, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void addTopPanel() {

        this.searchPanel = new JPanel();

        this.searchField = new JTextField(30);

        this.searchButton = new JButton("Buscar");

        this.searchPanel.add(this.searchField);
        this.searchPanel.add(this.searchButton);

    }

    private void addResultList() {

        this.resultsModel = new DefaultListModel<>();

        this.resultsList = new JList<>(this.resultsModel);

        this.resultsScrollPane =
                new JScrollPane(this.resultsList);

    }

    private void addActionButtons() {
        this.favoriteButton = new JButton("Favorito");

        this.watchedButton = new JButton("Assistido");

        this.wantToWatchButton = new JButton("Quero Assistir");

        this.actionsPanel = new JPanel();

        this.actionsPanel.add(this.favoriteButton);
        this.actionsPanel.add(this.watchedButton);
        this.actionsPanel.add(this.wantToWatchButton);
    }

    private void addTabs() {
        this.tabbedPane = new JTabbedPane();

        this.tabbedPane.addTab(
                "Favoritos",
                new JPanel()
        );

        this.tabbedPane.addTab(
                "Assistidos",
                new JPanel()
        );

        this.tabbedPane.addTab(
                "Quero Assistir",
                new JPanel()
        );
    }

    private void assembleLayout() {

        setLayout(new BoxLayout(
                getContentPane(),
                BoxLayout.Y_AXIS
        ));

        add(this.searchPanel);
        add(this.resultsScrollPane);
        add(this.actionsPanel);
        add(this.tabbedPane);
    }

}
