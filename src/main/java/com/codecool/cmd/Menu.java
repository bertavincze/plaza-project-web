package com.codecool.cmd;

class Menu {

    private String title;
    private String[] options;

    Menu(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    void displayMenu() {
        System.out.println(title + "\n");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ")" + " " + options[i]);
        }
    }
}
