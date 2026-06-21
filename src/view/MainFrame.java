package view;

import controller.SeriesController;
import model.entities.Serie;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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
    private JButton removeButton;
    private DefaultListModel<Serie> favoritesModel;
    private DefaultListModel<Serie> watchedModel;
    private DefaultListModel<Serie> wantToWatchModel;

    private JList<Serie> favoritesList;
    private JList<Serie> watchedList;
    private JList<Serie> wantToWatchList;

    public MainFrame() throws IOException {

        this.controller = new SeriesController();

        this.checkUser();

        this.initializeComponents();

        this.addTopPanel();

        this.addResultList();

        this.addActionButtons();

        this.addTabs();

        this.refreshLists();

        this.assembleLayout();

        this.configureEvents();

        setVisible(true);
    }

    private void checkUser() throws IOException {

        if (this.controller.getUserData().getUser() == null) {

            String nickname =
                    NicknameDialog.askNickname();

            if (nickname != null &&
            !nickname.isBlank()) {

                this.controller.setNickname(
                        nickname.trim()
                );
            }
        }
    }

    private void initializeComponents() {

        String title = "TV Series APP";

        if (controller.getUserData().getUser() != null) {

            title += " - "
                    + controller.getUserData()
                    .getUser()
                    .getNickName();
        }

        setTitle(title);

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
        this.removeButton = new JButton("Remover");

        this.actionsPanel = new JPanel();

        this.actionsPanel.add(this.favoriteButton);
        this.actionsPanel.add(this.watchedButton);
        this.actionsPanel.add(this.wantToWatchButton);
        this.actionsPanel.add(this.removeButton);
    }

    private void addTabs() {

        this.tabbedPane = new JTabbedPane();

        this.favoritesModel =
                new DefaultListModel<>();

        this.favoritesList =
                new JList<>(favoritesModel);

        this.tabbedPane.addTab(
                "Favoritos",
                new JScrollPane(favoritesList)
        );

        this.watchedModel =
                new DefaultListModel<>();

        this.watchedList =
                new JList<>(watchedModel);

        this.tabbedPane.addTab(
                "Assistidos",
                new JScrollPane(watchedList)
        );

        this.wantToWatchModel =
                new DefaultListModel<>();

        this.wantToWatchList =
                new JList<>(wantToWatchModel);

        this.tabbedPane.addTab(
                "Quero Assistir",
                new JScrollPane(wantToWatchList)
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

    private void configureEvents() {

        this.configureSearchEvent();

        this.configureFavoriteEvent();

        this.configureWatchedEvent();

        this.configureWantToWatchEvent();

        this.configureRemoveEvent();
    }

    private void configureSearchEvent() {

        this.searchButton.addActionListener(e -> {

            try {

                searchSeries();

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void configureFavoriteEvent() {

        this.favoriteButton.addActionListener(e -> {

            Serie selected =
                    this.resultsList.getSelectedValue();

            if (selected == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Selecione uma série."
                );

                return;
            }

            try {

                this.controller.addFavorite(selected);

                this.refreshFavorites();

                JOptionPane.showMessageDialog(
                        this,
                        "Série adicionada aos favoritos."
                );

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void configureWatchedEvent() {

        this.watchedButton.addActionListener(e -> {

            Serie selected =
                    this.resultsList.getSelectedValue();

            if (selected == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Selecione uma série."
                );

                return;
            }

            try {

                this.controller.addWatched(selected);

                this.refreshWatched();

                JOptionPane.showMessageDialog(
                        this,
                        "Série adicionada aos assistidos."
                );

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void configureWantToWatchEvent() {

        this.wantToWatchButton.addActionListener(e -> {

            Serie selected =
                    this.resultsList.getSelectedValue();

            if (selected == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Selecione uma série."
                );

                return;
            }

            try {

                this.controller.addWantToWatch(selected);

                this.refreshWantToWatch();

                JOptionPane.showMessageDialog(
                        this,
                        "Série adicionada à lista."
                );

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        });

    }

    private void configureRemoveEvent() {

        this.removeButton.addActionListener(e -> {

            try {

                removeSelectedSerie();

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        exception.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void searchSeries()
            throws IOException, InterruptedException {

        String name =
                this.searchField.getText().trim();

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite o nome de uma série."
            );

            return;
        }

        List<Serie> series =
                this.controller.searchSeries(name);

        this.resultsModel.clear();

        for (Serie serie : series) {

            this.resultsModel.addElement(serie);
        }
    }

    private void refreshLists() {

        this.refreshFavorites();

        this.refreshWatched();

        this.refreshWantToWatch();
    }

    private void refreshFavorites() {

        favoritesModel.clear();

        for (Serie serie :
                controller.getFavorite()) {

            favoritesModel.addElement(serie);
        }
    }

    private void refreshWatched() {

        watchedModel.clear();

        for (Serie serie :
                controller.getWatched()) {

            watchedModel.addElement(serie);
        }
    }

    private void refreshWantToWatch() {

        wantToWatchModel.clear();

        for (Serie serie :
                controller.getWantToWatch()) {

            wantToWatchModel.addElement(serie);
        }
    }

    private void removeSelectedSerie()
            throws IOException {

        int selectedTab =
                this.tabbedPane.getSelectedIndex();

        Serie selected = null;

        switch (selectedTab) {

            case 0:

                selected =
                        this.favoritesList.getSelectedValue();

                if (selected != null) {

                    controller.removeFavorite(selected);

                    refreshFavorites();
                }

                break;

            case 1:

                selected =
                        this.watchedList.getSelectedValue();

                if (selected != null) {

                    controller.removeWatched(selected);

                    refreshWatched();
                }

                break;

            case 2:

                selected =
                        this.wantToWatchList.getSelectedValue();

                if (selected != null) {

                    controller.removeWantToWatch(selected);

                    refreshWantToWatch();
                }

                break;
        }

        if (selected == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma série para remover."
            );

            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Série removida."
        );
    }

}
