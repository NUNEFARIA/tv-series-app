package view;

import javax.swing.*;

public class NicknameDialog {

    public static String askNickname() {

        return JOptionPane.showInputDialog(
                null,
                "Digite seu apelido:",
                "Primeiro acesso",
                JOptionPane.QUESTION_MESSAGE
        );
    }
}
