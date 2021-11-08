package Ejecutar;

import Controller.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.vista();
    }
    public void vista(){
        menuPrincipalController mp = new menuPrincipalController();
        mp.mostrarVista();
    }
}
